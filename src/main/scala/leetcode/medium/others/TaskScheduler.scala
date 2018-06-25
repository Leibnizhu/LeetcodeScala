package leetcode.medium.others

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/122/
  *
  * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
  * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
  * 你需要计算完成所有任务所需要的最短时间。
  */
object TaskScheduler {
  /**
    * 为了满足间隔需求,首先考虑把出现次数最多的任务按n个间隔进行排布
    * 因此需要先根据出现次数进行排序(Xm[k],Xm-1[..],...X1[1],中括号内为出现次数)
    * 剩下的任务,如果出现次数与出现最多的任务Xm相同,那么应该跟Xm一起按n间隔进行排布
    * 其他任务塞在n间隔之间剩余的空位.
    * 这样就会有两种情况,:
    * 1. n间隔之间剩余空位足以安排剩下的任务(n足够大),此时总消耗时间为 (n+1)*(k-1) + 重复次数为k的任务数, 就是前面k-1次部分,以及最后一次重复只有重复次数为k的任务出现.
    * 2. n间隔之间空位不足以安排剩下任务(n足够小),此时因为剩余任务重复次数小于k,可以推断必然可以通过合理排布在Xm等重复k次的任务排布完之后,把剩下任务依次放好,但本题不要求给出排列,只要给出时间,因此这种情况耗时为 总任务数
    */
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val freq = Array.fill[Int](26)(0)
    for (task <- tasks) freq(task - 'A') += 1 //统计出现频率
    val sortedFreq = freq.sorted //按频率排序,本体不要求给出排列,因此关注重复次数即可,无需考虑对应的任务名
    val kTasks = sortedFreq.count(_ == sortedFreq.last) // 重复次数与最大重复次数相同的任务数
    Math.max(tasks.length, (n + 1) * (sortedFreq.last - 1) + kTasks)
  }
}
