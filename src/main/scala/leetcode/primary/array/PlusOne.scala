package leetcode.primary.array

object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    def plus(digits: Array[Int], delta: Int, i: Int): Array[Int] = {
      val res = digits(i) + delta
      digits(i) = res % 10
      if (res < 10) digits else if (i == 0) (1 :: digits.toList).toArray else plus(digits, 1, i - 1)
    }

    plus(digits, 1, digits.length - 1)
  }
}
