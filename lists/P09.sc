def pack[T](list: List[T]) : List[List[T]] = {
   list.foldRight(List[List[T]]()) { (item, r) =>
     if (r.isEmpty || r.head.head != item) List(item) :: r
     else (item :: r.head) :: r.tail
   }
}


def packSlightlyMoreEfficient[A](ls: List[A]): List[List[A]] = {
  if (ls.isEmpty) List(List())
  else {
    val (packed, next) = ls span { _ == ls.head }
    if (next == Nil) List(packed)
    else packed :: pack(next)
  }
}


val r = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


val expected = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

assert (r == expected)





