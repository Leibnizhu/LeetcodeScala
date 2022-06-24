package codewars.kyu1

/**
  * 2022-06-24
  * {@see <a href='https://www.codewars.com/kata/59c132fb70a3b7efd3000024/train/scala'/> }
  */
object ScottEncoding {
  trait STuple[+A, +B] {
    def apply[C]: ((A, B) => C) => C
  }

  trait SOption[+A] {
    def apply[B]: (=> B, A => B) => B
  }

  trait SEither[+A, +B] {
    def apply[C]: (A => C, B => C) => C
  }

  trait SList[+A] {
    def apply[B]: (=> B, (A, SList[A]) => B) => B
  }

  def toTuple[A, B](tuple: STuple[A, B]): (A, B) =
    tuple[(A, B)]((a, b) => (a, b))

  def fromTuple[A, B](tuple: (A, B)): STuple[A, B] = new STuple[A, B] {
    def apply[C] = _ (tuple._1, tuple._2)
  }

  def fst[A, B](tuple: STuple[A, B]): A =
    tuple[A]((a, _) => a)

  def snd[B](tuple: STuple[_, B]): B =
    tuple[B]((_, b) => b)

  def swap[A, B](tuple: STuple[A, B]): STuple[B, A] =
    tuple[STuple[B, A]]((a, b) => new STuple[B, A] {
      def apply[C] = _ (b, a)
    })

  def curry[A, B, C](f: STuple[A, B] => C): A => B => C =
    a => b => f(new STuple[A, B] {
      def apply[C] = _ (a, b)
    })

  def uncurry[A, B, C](f: A => B => C): STuple[A, B] => C =
    tuple => tuple[C](Function.uncurried(f))

  def toOption[A](option: SOption[A]): Option[A] =
    option[Option[A]](Option.empty[A], Some(_))

  def fromOption[A](option: Option[A]): SOption[A] = new SOption[A] {
    def apply[B] = (ifEmpty, f) => option.fold(ifEmpty)(f)
  }

  def isSome(option: SOption[_]): Boolean =
    option[Boolean](false, _ => true)

  def isNone(option: SOption[_]): Boolean =
    option[Boolean](true, _ => false)

  def catOptions[A](list: SList[SOption[A]]): SList[A] =
    list[SList[A]](nil[A], (head, tail) =>
      head[SList[A]](catOptions(tail), a => cons(a, catOptions(tail))))

  def toEither[A, B](either: SEither[A, B]): Either[A, B] =
    either[Either[A, B]](Left[A, B], Right[A, B])

  def fromEither[A, B](either: Either[A, B]): SEither[A, B] = new SEither[A, B] {
    def apply[C] = (left, right) => either.fold(left, right)
  }

  def isLeft(either: SEither[_, _]): Boolean =
    either[Boolean](_ => true, _ => false)

  def isRight(either: SEither[_, _]): Boolean =
    either[Boolean](_ => false, _ => true)

  def nil[A]: SList[A] = new SList[A] {
    def apply[B] = (b, _) => b
  }

  def toList[A](list: SList[A]): List[A] =
    list[List[A]](List[A](), (head, tail) => head :: toList(tail))

  def fromList[A](list: List[A]): SList[A] =
    list.foldRight(nil[A])(cons)

  def cons[A](head: A, list: SList[A]): SList[A] = new SList[A] {
    def apply[B] = (_, f) => f(head, list)
  }

  def concat[A](left: SList[A], right: SList[A]): SList[A] =
    left[SList[A]](right, (leftHead, rightHead) => new SList[A] {
      def apply[B] = (_, f) => f(leftHead, concat(rightHead, right))
    })

  def empty(list: SList[_]): Boolean =
    list[Boolean](true, (_, _) => false)

  def length(list: SList[_]): Int =
    list[Int](0, (_, tail) => 1 + length(tail))

  def map[A, B](f: (A => B), list: SList[A]): SList[B] =
    list[SList[B]](nil[B], (head, tail) => cons(f(head), map(f, tail)))

  def zip[A, B](listA: SList[A], listB: SList[B]): SList[STuple[A, B]] =
    listA[SList[STuple[A, B]]](nil[STuple[A, B]],
      (headA, tailA) => listB[SList[STuple[A, B]]](nil[STuple[A, B]],
        (headB, tailB) => cons(fromTuple(headA, headB), zip(tailA, tailB))))

  def foldLeft[A, B](f: ((B, A) => B), z: B, list: SList[A]): B =
    list[B](z, (head, tail) => foldLeft(f, f(z, head), tail))

  def foldRight[A, B](f: ((A, B) => B), z: B, list: SList[A]): B =
    list[B](z, (head, tail) => f(head, foldRight(f, z, tail)))

  def take[A](n: Int, list: SList[A]): SList[A] =
    if (n == 0) nil[A]
    else list[SList[A]](nil[A], (head, tail) => cons(head, take(n - 1, tail)))

  def partition[A, B](list: SList[SEither[A, B]]): STuple[SList[A], SList[B]] =
    list[STuple[SList[A], SList[B]]](fromTuple(nil[A], nil[B]),
      (head, tail) => partition(tail)[STuple[SList[A], SList[B]]](
        (leftList, rightList) => head[STuple[SList[A], SList[B]]](
          leftHead => fromTuple(cons(leftHead, leftList), rightList),
          rightHead => fromTuple(leftList, cons(rightHead, rightList)))))
}
