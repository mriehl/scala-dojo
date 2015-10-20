package transitive

case class Dependencies[T](dependencies: (T, Set[T])*) {

  def expand: Dependencies[T] = Dependencies[T]()

}
