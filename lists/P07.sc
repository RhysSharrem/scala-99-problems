def flatten(l : List[Any]) : List[Any] = {
  l match {
    case Nil => Nil
    case (h : List[Any]) :: tail => flatten(h) ::: flatten(tail)
    case h :: tail => h :: flatten(tail)
  }
}

def flattenFlatMap(ls: List[Any]): List[Any] = ls flatMap {
  case ms: List[_] => flatten(ms)
  case e => List(e)
}


flatten(List(List(1, 1), 2, List(3, List(5, 8))))

flattenFlatMap(List(List(1, 1), 2, List(3, List(5, 8))))




