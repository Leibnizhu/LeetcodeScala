package codewars.kyu4

/**
  * 2022-06-07
  * {@see <a href='https://www.codewars.com/kata/55b7bb74a0256d4467000070/train/scala'/> }
  */
object NumberOfProperFractionsWithDenominatorD {
  /**
    * 其实就是欧拉函数
    * 定义：对于正整数n，φ(n)是小于或等于n的正整数中，与n互质的数的数目。
    * 例如：φ(8)=4，因为1，3，5，7均和8互质。
    * 性质：
    * 1.若p是质数，φ(p)= p-1.
    * 2.若n是质数p的k次幂，φ(n)=(p-1)*p^(k-1)。因为除了p的倍数都与n互质
    * 3.欧拉函数是积性函数，若m,n互质，φ(mn)= φ(m)φ(n).
    * 根据这3条性质我们就可以推出一个整数的欧拉函数的公式。因为一个数总可以写成一些质数的乘积的形式。
    * E(k)=(p1-1)(p2-1)...(pi-1)*(p1^(a1-1))(p2^(a2-1))...(pi^(ai-1))
    * = k*(p1-1)(p2-1)...(pi-1)/(p1*p2*...*pi)
    * = k*(1-1/p1)*(1-1/p2)...(1-1/pk)
    * 在程序中利用欧拉函数如下性质，可以快速求出欧拉函数的值（a为N的质因素）
    * 若( N%a ==0&&(N/a)%a ==0)则有：E(N)= E(N/a)*a;
    * 若( N%a ==0&&(N/a)%a !=0)则有：E(N)= E(N/a)*(a-1);
    */
  def properFractions(n: Long): Long = {
    if (n == 1L) {
      0
    } else {
      var (ans, x, i) = (1L, n, 2L)
      while (i * i <= x) {
        if (x % i == 0) {
          x /= i
          ans *= (i - 1)
          while (x % i == 0) {
            x /= i
            ans *= i
          }
        }
        i += 1
      }
      if (x > 1) ans *= (x - 1)
      ans
    }
  }
}
