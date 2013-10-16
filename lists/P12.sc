def decode[T](list: List[(Int, T)]) : List[T] = {
  list.foldRight(List[T]()){ (item, right) =>
    val items = for (c <- 1 to item._1) yield item._2
    items.toList ::: right
  }
}

val result = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))


val expected = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)



assert (result == expected)

