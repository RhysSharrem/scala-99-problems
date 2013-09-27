def isPalindrome[t](l : List[t]) : Boolean = {
  def isPalindromeHelper(one : List[t], two : List[t]) : Boolean =
    (one, two) match {
      case (Nil, Nil) => true
      case (Nil, _) => false
      case (_, Nil) => false
      case (h1 :: t1, h2 :: t2) => h1 == h2 && isPalindromeHelper(t1, t2)
    }

  isPalindromeHelper(l, l.reverse)
}

def isPalindromeSimple[A](ls: List[A]): Boolean = ls == ls.reverse

isPalindrome(List(1, 2, 3, 2, 1))
isPalindrome(List(1, 2, 3, 2, 1, 1))