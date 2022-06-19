package codewars.kyu1

/**
  * 2022-06-19
  * {@see <a href='https://www.codewars.com/kata/5976c5a5cd933a7bbd000029/train/scala'/> }
  * scala版总是超时，改成java就可以了
  * {@link codewars.kyu1.FabergeEasterEggsCrushTestLinearJava}
  */
object FabergeEasterEggsCrushTestLinear {
  val MOD: BigInt = BigInt(998244353)
  val ZERO: BigInt = BigInt(0)
  val ONE: BigInt = BigInt(1)
  val memo = new scala.collection.mutable.ListBuffer[BigInt]
  memo += 0
  memo += 1
  for (i <- 2 to 80000) {
    memo += (MOD - MOD / i) * memo((MOD % i).intValue) % MOD
  }
//  memo.grouped(1000).map(g => s"List(${g.mkString(",")})").foreach(println)

  //0. 之前有 length(n, m) = C(m, 1) + ... + C(m, n)
  //1. n < MOD, length(n, m) = length(n, m % MOD)
  //2. n > m时 C(m, n) = 0，则 length(n, m) = length(min(n, m), m)
  //3. C(m, 1) = m, C(m, i+1) (mod MOD)= C(m, i) * (m-i) / (i+1)  (mod MOD)= C(m, i) * (m-i) * (i+1) ^ (MOD-2)  (mod MOD)
  def height(n: BigInt, m: BigInt): BigInt = if (m == ZERO || n == ZERO) ZERO else {
    val finalM = m % MOD
    val finalN = n.min(finalM)
    var (curSum, prevCombine) = (ZERO, ONE)
    for (i <- ONE to finalN) {
      val curCombine = prevCombine * (finalM - (i - 1)) * memo(i.intValue) % MOD
      curSum = curSum + curCombine % MOD
      prevCombine = curCombine
    }
    curSum % MOD
  }
}
