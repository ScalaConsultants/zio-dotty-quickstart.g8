package $package$

import zio.Has

object api {
  type Api = Has[Api.Service]
}
