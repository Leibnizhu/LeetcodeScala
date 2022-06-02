package codewars.kyu4

import codewars.kyu4.FiveFundamentalMonads._
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FiveFundamentalMonadsTest extends AnyPropSpec with ScalaCheckPropertyChecks with Matchers {
  def leftASSO[M[_], A, B, C](amb: A => M[B])(bmc: B => M[C])(ma: M[A])(implicit m: Monad[M]): M[C] = m.bind(m.bind(ma)(amb))(bmc)

  def rightASSO[M[_], A, B, C](amb: A => M[B])(bmc: B => M[C])(ma: M[A])(implicit m: Monad[M]): M[C] = m.bind(ma)((a: A) => m.bind(amb(a))(bmc))

  def leftID[M[_], A, B](a: A)(amb: A => M[B])(implicit m: Monad[M]): M[B] = m.bind(m.unit(a))(amb)

  def rightID[M[_], A](ma: M[A])(implicit m: Monad[M]): M[A] = m.bind(ma)(m.unit)

  property("Identity") {
    val m = implicitly[Monad[Identity]]

    def addOne(x: Int): Identity[Int] = m.unit(x)

    forAll { (x: Int, y: Int, z: Int) => {
      leftID(x)(addOne) should be(addOne(x))
      rightID(addOne(x)) should be(addOne(x))

      def f(a: Int): Identity[Int] = m.unit(a + x)

      def g(a: Int): Identity[Int] = m.unit(a + y)

      leftASSO(f)(g)(m.unit(z)) should be(rightASSO(f)(g)(m.unit(z)))
    }
    }
  }

  property("Maybe") {
    val m = implicitly[Monad[Maybe]]

    def isEven(x: Int): Maybe[Int] = if (x % 2 == 0) {
      Just(x)
    } else {
      None
    }

    forAll { (x: Int, y: Int, z: Int) => {
      leftID(x)(isEven) should be(isEven(x))
      rightID(isEven(x)) should be(isEven(x))

      def f(a: Int): Maybe[Int] = if (x % 2 == 0) {
        isEven(a)
      } else {
        None
      }

      def g(a: Int): Maybe[Int] = if (y % 2 == 0) {
        isEven(a)
      } else {
        None
      }

      leftASSO(f)(g)(isEven(z)) should be(rightASSO(f)(g)(isEven(z)))
    }
    }

  }

  property("State") {
    def m: Monad[({
      type x[a] = State[Int, a]
    })#x] = implicitly[Monad[({type x[a] = State[Int, a]})#x]]

    def f(x: Int): State[Int, Int] = State((s: Int) => (s - 1, x + 1))

    def g(x: Int): State[Int, Int] = m.unit(x + 1)

    leftID(5)(f).run(1) should be(f(5).run(1))
    rightID(f(5)).run(1) should be(f(5).run(1))
    leftASSO(f)(g)(m.unit(5)).run(1) should be(rightASSO(f)(g)(m.unit(5)).run(1))
  }

  property("Reader") {
    def m: Monad[({
      type x[a] = Reader[Int, a]
    })#x] = implicitly[Monad[({type x[a] = Reader[Int, a]})#x]]

    def f(x: Int): Reader[Int, Int] = Reader((r: Int) => r + x)

    def g(x: Int): Reader[Int, Int] = m.unit(x + 1)

    leftID(5)(f).run(1) should be(f(5).run(1))
    rightID(f(5)).run(1) should be(f(5).run(1))
    leftASSO(f)(g)(m.unit(5)).run(1) should be(rightASSO(f)(g)(m.unit(5)).run(1))
  }

  property("Writer") {
    implicit val intMonoid = new Monoid[Int] {
      def mempty: Int = 0

      def mappend(x: Int)(y: Int) = x + y
    }

    def m: Monad[({
      type x[a] = Writer[Int, a]
    })#x] = implicitly[Monad[({type x[a] = Writer[Int, a]})#x]]

    def f(x: Int): Writer[Int, Int] = Writer((x + 1, x))

    def g(x: Int): Writer[Int, Int] = m.unit(x)

    leftID(5)(f) should be(f(5))
    rightID(f(5)) should be(f(5))
    leftASSO(f)(g)(m.unit(5)) should be(rightASSO(f)(g)(m.unit(5)))
  }
}