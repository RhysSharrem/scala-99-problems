def duplicateN[T](n: Int, in: List[T]) = {
  in.foldRight(List[T]()) {
    (item, right) =>
      val dupes = for (i <- 1 to n) yield item
      dupes.toList ::: right
  }
}

val result = duplicateN(3, List('a, 'b, 'c, 'c, 'd))


val expected = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

assert(result == expected)