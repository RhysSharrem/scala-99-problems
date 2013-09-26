import scala.annotation.tailrec

def length[t](l : List[t]) : Int =
  l match {
    case Nil => 0
    case x => 1 + length(x.tail)
  }

/*
Tail recursive method.
See http://oldfashionedsoftware.com/2008/09/27/tail-recursion-basics-in-scala/
*/
def lengthTRec[t](l : List[t]) : Int = {

  @tailrec
  def lengthHelper(s : Int, remainder : List[t]) : Int =
    remainder match {
      case Nil => s
      case r => lengthHelper(s + 1, r.tail)
    }

  lengthHelper(0, l)
}

length(List(1, 1, 2, 3, 5, 8))
lengthTRec(List(1, 1, 2, 3, 5, 8))