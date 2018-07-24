package leetcode.hard.other

import scala.collection.mutable.ListBuffer

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/166/
 * 
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：总人数少于1100人。
 */
object QueueReconstruction {
  /**
   * 因为k是排在前面身高大于等于h的个数,所以①h相同时,更小的k必然在前面
   * 同理,②k相同时,更小的h应该在前面(否则,更大的h在前面,则更小的h对应的k应该比更大的h对应的k至少大1,
   * 如(4,n)(5,n)是可能的,(5,n)(4,n+1)也是可能的,但(5,n)(4,n)就不可能了,因为这个4至少比5多了一个5身高比他高
   * 我们可以按h降序排序(h相同时,k升序),然后按k作为下标插入到新数组
   * 由于按k下标插入,所以k相同时, h更小的是后面才插入,把更大的h挤到后面去,满足②
   * 而同一个h不同k的是一起先后插入的,因为已经对k升序,所以满足条件①
   */
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val buf = new ListBuffer[Array[Int]]()
    people.sortWith((l, r) => if (l(0) == r(0)) l(1) < r(1) else l(0) > r(0)) //按h降序k升序排序
      .foreach(p => buf.insert(p(1), p)) //以k作为下标插入到List缓存
    buf.toArray
  }
}