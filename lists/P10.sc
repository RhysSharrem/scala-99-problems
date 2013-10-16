def pack[T](list: List[T]) : List[List[T]] = {
  list.foldRight(List[List[T]]()) { (item, r) =>
    if (r.isEmpty || r.head.head != item) List(item) :: r
    else (item :: r.head) :: r.tail
  }
}

def encode[T](in : List[T]) : List[(Int, T)] =
  pack(in) map(i => (i.size, i.head))

val result = encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))



assert (result == expected)