def duplicate[T](in: List[T]) : List[T] =
  in.foldRight(List[T]())((item, right) => item :: item :: right)

val result = duplicate(List('a, 'b, 'c, 'c, 'd))
val expected = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)


assert (result == expected)