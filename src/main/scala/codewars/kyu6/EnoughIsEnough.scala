package codewars.kyu6

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 2022-05-25
  * {@see <a href='https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/scala'/> }
  */
object EnoughIsEnough {
  //直接flatMap会变Map，丢失其他数据
  def deleteNth(elements: List[Int], maxOccurrences: Int): List[Int] =
    elements.zipWithIndex.groupBy(_._1).map(_._2.take(maxOccurrences)).flatten.toList.sortBy(_._2).map(_._1)
}
