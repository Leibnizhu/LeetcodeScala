package leetcode.medium.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/96/
  *
  * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
  * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
  * 注意: 不能使用代码库中的排序函数来解决这道题。
  *
  * 进阶：
  * 一个直观的解决方案是使用计数排序的两趟扫描算法。首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
  * 你能想出一个仅使用常数空间的一趟扫描算法吗？
  */
object SortColors {
  /**
    * 记录0,1,2的个数再排的话需要两趟.
    * 要一趟搞掂的话,可以使用两个游标记录下一个0/2需要插入的位置(初始是0和length-1)
    * 然后用一个游标遍历数组,遇到0则与0的游标交换,遇到2则与2的游标交换,否则游标前进
    */
  def sortColors(nums: Array[Int]): Unit = {
    def swap(arr: Array[Int], x: Int, y: Int): Unit = {
      val tmp = arr(x)
      arr(x) = arr(y)
      arr(y) = tmp
    }

    var red = 0 //红色游标
    var blue = nums.length - 1 //蓝色游标
    var p = 0 //遍历的游标
    while (red < blue && p <= blue) //p <= blue因为blue是蓝色下一次要插入的位置,也就是比蓝色真实位置要小1
      nums(p) match {
        case 0 =>
          swap(nums, p, red)
          red += 1
          p += 1
        case 1 => p += 1
        case 2 =>
          swap(nums, p, blue)
          blue -= 1
      }
  }
}
