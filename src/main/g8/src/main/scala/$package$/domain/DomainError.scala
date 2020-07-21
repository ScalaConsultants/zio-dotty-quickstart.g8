package $package$.domain

enum DomainError {
  case RepositoryError(cause: Exception)
  case ValidationError(msg: String)

  def asThrowable: Throwable = this match {
    case RepositoryError(cause) => cause
    case ValidationError(msg)   => new Throwable(msg)
  }
}