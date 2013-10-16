import scala.annotation.tailrec

def compress[t](l : List[t]) : List[t] = {

  @tailrec
  def compressHelper(toCompress : List[t], compressed : List[t]) : List[t] = {
    (toCompress, compressed) match {
      case (Nil, c) => c
      case (h1 :: tail, Nil) => compressHelper(tail, h1 :: Nil)
      case (h1 :: t1, h2 :: t2) => compressHelper(t1, if (h1 == h2) compressed else h1 :: h2 :: t2)
    }
  }

  compressHelper(l.reverse, List())
}



//Better:
def compressTailRecursive[A](ls: List[A]): List[A] = {

  @tailrec
  def compressR(result: List[A], curList: List[A]): List[A] = curList match {
    case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
    case Nil       => result.reverse
  }
  compressR(Nil, ls)
}

// Functional.
def compressFunctional[A](ls: List[A]): List[A] =
  ls.foldRight(List[A]()) { (h, r) =>
    if (r.isEmpty || r.head != h) h :: r
    else r
  }

compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

