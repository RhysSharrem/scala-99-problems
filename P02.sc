object P02 {
  def penultimate[x](l : List[x]) : x =
    l match {
      case h :: i :: Nil => h
      case h :: t => penultimate(t)
      case Nil => throw new NoSuchElementException
    }
}

P02.penultimate(List(1, 2, 3))
P02.penultimate(List(1, 2))
P02.penultimate(List(1))







































P02.penultimate(List())






































