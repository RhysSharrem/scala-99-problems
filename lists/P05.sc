import scala.annotation.tailrec

def reverseFold[t](l : List[t]) : List[t] =
  l.foldRight[List[t]](Nil)((left, right) => left :: right)

def reverse[t](l: List[t]): List[t] = {
  @tailrec
  def reverseHelper(toReverse: List[t], reversed: List[t]): List[t] =
    toReverse match {
      case Nil => reversed
      case h :: tail => reverseHelper(tail, h :: reversed)
    }

  reverseHelper(l, List())
}

// Pure functional
def reverseFunctional[A](ls: List[A]): List[A] =
  ls.foldLeft(List[A]()) { (r, h) => h :: r }


reverse(List(1, 1, 2, 3, 5, 8))

