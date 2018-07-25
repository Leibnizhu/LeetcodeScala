package leetcode.hard.other

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/169/
  *
  * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
  * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
  */
object LargestRectangleInHistogram {
  /**
    * 跟之前MaxArea问题不一样,MaxArea只要拿到区间两边较小者即可计算面积(即O(1))时间
    * 这题要计算面积的时候,要知道整个区间的最小值,亦即O(n)
    * 而且这样就不能简单地判断两边缩小右边的条件了,只能暴力,因此不要(n*n*n)时间,会超时
    * 问题在于确定矩形的左右边界,如果我们维护一个递增的数组,那么每个区间最小值都是左边,比较的时候遍历一次左值*(最右-左)即可
    * 但是题目给出的柱状图不是单调增的,因此遍历源数组插入到递增数组,出现比数组最后一位更大的时候,需要合并,维护单调增
    * 为了方便这样的操作,可以用栈来维护这个单调增数组
    * 合并的操作其实就是计算当前单调增栈的最大面积, 就是出栈的值作为矩形高度,
    * 右边界为遍历的下标i(不包含),左边界为新栈顶索引(栈空则宽度为i)
    * 合并直到栈顶比i对应值小
    */
  def largestRectangleArea(heights: Array[Int]): Int = {
    val len = heights.length
    var stack = List[Int]() //Stack类已经废弃,源码注释里建议用var的List对象替代

    /**
      * 因为要递归,因此不能直接写在fold的参数里,要定义一个函数用来递归调用
      * 满足栈单调增的入栈,否则合并前面的柱子计算面积,直到满足单调增为止
      *
      * @param curArea fold传递的中间结果值
      * @param i       当前下标, 当i=数组长度时,不再入栈,直接合并计算面积
      * @return 本次迭代计算的面积
      */
    def calCurArea(curArea: Int, i: Int): Int =
      if (stack.isEmpty || i < len && heights(stack.head) <= heights(i)) { //<len是考虑到最后一次必须合并计算面积
        stack ::= i //满足条件的可以入栈
        curArea //无需合并计算面积,直接返回
      } else {
        val height = heights(stack.head) //当前要计算的矩形的高度
        stack = stack.tail //相当于出栈
        val newArea = height * (if (stack.isEmpty) i else i - stack.head - 1) //计算面积
        calCurArea(Math.max(curArea, newArea), i) //继续递归计算面积直到栈顶比当前值小,满足单调性,即合并成功
      }

     (0 /: (0 to len)) (calCurArea) //递归计算面积,考虑到最大矩形的右边界出现在数组最右边的情况,要算到len为止,在递归里面约束
  }
}