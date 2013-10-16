def pack[T](list: List[T]) : List[List[T]] = {
  list.foldRight(List[List[T]]()) { (item, r) =>
    if (r.isEmpty || r.head.head != item) List(item) :: r
    else (item :: r.head) :: r.tail
  }
}

def encodeModified[T](in : List[T]) : List[Any] =
  pack(in) map(i => if (i.size > 1) (i.size, i.head) else i.head)
val result = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


val expected = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))




assert (result == expected)




