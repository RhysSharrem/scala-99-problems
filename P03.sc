object P03 {
  def nth[x](n : Int, l : List[x]) : x = {
    def nthRec(c : Int, r : List[x]) : x =
      if (r.isEmpty) throw new NoSuchElementException
      else if (c == n) r.head
      else nthRec(c + 1, r.tail)

    nthRec(0, l)
  }

  def nthBetter[A](n: Int, ls: List[A]): A =
    (n, ls) match {
      case (0, h :: _   ) => h
      case (n, _ :: tail) => nthBetter(n - 1, tail)
      case (_, Nil      ) => throw new NoSuchElementException
    }
}


P03.nth(2, List(1, 1, 2, 3, 5, 8))
P03.nth(2, List(1, 1))









































