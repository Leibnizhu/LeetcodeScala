package codewars.kyu5

object PerimeterOfSquaresInARectangle {
  def perimeter(n: BigInt): BigInt = {
    var (l, r, sum): (BigInt, BigInt, BigInt) = (1, 1, 2)
    for (_ <- BigInt(1) until n) {
      r = l + r
      l = r - l
      sum += r
    }
    4 * sum
  }
}
