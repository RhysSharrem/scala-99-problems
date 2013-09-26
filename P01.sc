object P01 {
  def last[x](l : List[x]) : x =
    l match {
      case h :: Nil => h
      case h :: t => last(t)
      case Nil => throw new NoSuchElementException
    }
}

P01.last(List(1, 2, 3, 4))
P01.last(Nil)






































