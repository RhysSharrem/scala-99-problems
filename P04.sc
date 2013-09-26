def length[t](l : List[t]) : Int =
  l match {
    case Nil => 0
    case x => 1 + length(x.tail)
  }

length(List(1, 1, 2, 3, 5, 8))