def compress[t](l : List[t]) : List[t] = {
  def compressHelper(toCompress : List[t], compressed : List[t]) : List[t] = {
    (toCompress, compressed) match {
      case (Nil, c) => c
      case (h1 :: tail, Nil) => compressHelper(tail, h1 :: Nil)
      case (h1 :: t1, h2 :: t2) => compressHelper(t1, if (h1 == h2) compressed else h1 :: h2 :: t2)
    }
  }

  compressHelper(l.reverse, List())
}

compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

