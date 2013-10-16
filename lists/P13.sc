def encodeDirect[T](list: List[T]) : List[(Int, T)] = {
  if (list.isEmpty) List()
  else {
    val (packed, next) = list span { _ == list.head }
    if (next == Nil) List((packed.length, list.head))
    else (packed.length, list.head) :: encodeDirect(next)
  }
}


val result = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))



assert(result == expected)