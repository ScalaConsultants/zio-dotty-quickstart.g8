package $package$.infrastructure

import $package$.domain._
import $package$.infrastructure.EntityIdMappers._
import $package$.infrastructure.tables.ItemsTable
import slick.interop.zio.DatabaseProvider
import slick.interop.zio.syntax._
import slick.jdbc.H2Profile.api._
import zio.logging._
import zio.{ IO, ZIO, ZLayer }

final class SlickItemRepository(env: DatabaseProvider with Logging)
    extends ItemRepository.Service {
  val items = ItemsTable.table

  def add(data: ItemData): IO[RepositoryError, ItemId] = {
    val insert = (items returning items.map(_.id)) += Item.withData(ItemId(0), data)

    log.info(s"Adding item \$data") *>
    ZIO
      .fromDBIO(insert)
      .refineOrDie {
        case e: Exception => RepositoryError(e)
      }

  }.provide(env)

  def delete(id: ItemId): IO[RepositoryError, Unit] = {
    val delete = items.filter(_.id === id).delete

    log.info(s"Deleting item \${id.value}") *>
    ZIO
      .fromDBIO(delete)
      .unit
      .refineOrDie {
        case e: Exception => RepositoryError(e)
      }
  }.provide(env)

  val getAll: IO[RepositoryError, List[Item]] =
    ZIO.fromDBIO(items.result).provide(env).map(_.toList).refineOrDie {
      case e: Exception => RepositoryError(e)
    }

  def getById(id: ItemId): IO[RepositoryError, Option[Item]] = {
    val query = items.filter(_.id === id).result

    ZIO.fromDBIO(query).provide(env).map(_.headOption).refineOrDie {
      case e: Exception => RepositoryError(e)
    }
  }

  def getByIds(ids: Set[ItemId]): IO[RepositoryError, List[Item]] = {
    val query = items.filter(_.id inSet ids).result

    ZIO.fromDBIO(query).provide(env).map(_.toList).refineOrDie {
      case e: Exception => RepositoryError(e)
    }
  }

  def update(id: ItemId, data: ItemData): IO[RepositoryError, Option[Unit]] = {
    val q      = items.filter(_.id === id).map(item => (item.name, item.price))
    val update = q.update((data.name, data.price))

    val foundF = (n: Int) => if (n > 0) Some(()) else None

    log.info(s"Updating item \${id.value} to \$data") *>
    ZIO.fromDBIO(update).map(foundF).refineOrDie {
      case e: Exception => RepositoryError(e)
    }
  }.provide(env)
}

object SlickItemRepository {

  val live: ZLayer[DatabaseProvider with Logging, Throwable, ItemRepository] =
    ZLayer.fromFunctionM { env =>
      val initialize = ZIO.fromDBIO(ItemsTable.table.schema.createIfNotExists)
      initialize.provide(env).as(new SlickItemRepository(env))
    }
}
