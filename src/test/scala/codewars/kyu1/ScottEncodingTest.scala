package codewars.kyu1

import org.scalatest.funsuite.AnyFunSuite
import codewars.kyu1.ScottEncoding._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ScottEncodingTest extends AnyFlatSpec with Matchers {

  "The Option type" can "be cast to scala Option" in {
    toOption(new SOption[Int] {
      def apply[B] = (z, _) => z
    }) should be(None)
    toOption(new SOption[Int] {
      def apply[B] = (_, f) => f(4)
    }) should be(Some(4))
  }
  it can "be cast from scala Option" in {
    fromOption[Int](None)[Int](0, _ + 1) should be(0)
    fromOption(Some(4))[Int](0, _ + 1) should be(5)
  }

  "The List type" can "be cast to scala List" in {
    toList(nil[Int]) should be(List())
    toList(new SList[Int] {
      override def apply[B] = (_, f) => f(1, new SList[Int] {
        override def apply[B] = (_, g) => g(2, nil[Int])
      })
    }) should be(List(1, 2))
  }
  it can "be cast from scala List" in {
    fromList[Int](List())[Int](0, reduce) should be(0)
    fromList[Int](List(1, 2, 3))[Int](0, reduce) should be(321)
  }

  "The Either type" can "be cast to scala Either" in {
    toEither(new SEither[Int, String] {
      override def apply[C] = (left, _) => left(3)
    }) should be(Left(3))

    toEither(new SEither[Int, String] {
      override def apply[C] = (_, right) => right("hello")
    }) should be(Right("hello"))
  }
  it can "be cast from scala Either" in {
    fromEither[Int, String](Left(3))[String](_.toString, identity) should be("3")
    fromEither[Int, String](Right("hello"))[String](_.toString, identity) should be("hello")
  }

  "The tuple type" can "be cast to (,)" in {
    toTuple(new STuple[Int, String] {
      override def apply[C] = f => f(2, "hi")
    }) should be((2, "hi"))
  }
  it can "be cast from (,)" in {
    fromTuple((2, "hi"))[List[String]](List.fill(_)(_)) should be(List("hi", "hi"))
    fromTuple((3, 6))[Int](_ * _) should be(18)
  }


  def reduce(i: Int, is: SList[Int]): Int =
    i + 10 * is[Int](0, reduce)
}
