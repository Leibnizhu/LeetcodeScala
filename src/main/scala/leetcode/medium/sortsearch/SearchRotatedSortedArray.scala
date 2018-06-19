package leetcode.medium.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/102/
  *
  * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
  * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
  * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
  * 你可以假设数组中不存在重复的元素。
  * 你的算法时间复杂度必须是 O(log n) 级别。
  */
object SearchRotatedSortedArray {
  /**
    * 二分查找,值得注意的是,因为旋转了,所以如果二分的时候,左/右区间是单调增的,则该区间内是没有打乱顺序的,
    * 如果target在这个区间范围内, 可以在里面查找.
    * 在另外一个区间内, 取值范围应该是相反;如果target不在两者范围内,可以直接返回-1了
    * 例如,left=7,mid=2,right=5,那么右区间没有打乱,左区间存在一个旋转点
    * 此时如果:
    *  - 查找2, 直接返回mid下标
    *  - 查找4(大于mid,小于right),那么去右区间查找;
    *  - 查找8(大于left)或者1(小于mid),应该在左区间查找;
    *  - 查找6(大于right,小于left),则应该不存在,直接返回-1
    */
  def search(nums: Array[Int], target: Int): Int = {
    if (nums == null || nums.isEmpty) return -1
    var l = 0
    var r = nums.length - 1
    while (l != r) {
      val mid = l + (r - l) / 2
      if (nums(mid) == target)
        return mid
      else if (nums(l) <= nums(mid)) {
        //左区间单调增,旋转点在右区间
        if (target >= nums(l) && target < nums(mid))
          r = mid - 1
        else if (target > nums(mid) || target <= nums(r))
          l = mid + 1
        else
          return -1
      } else {
        //右区间单调增,旋转点在左区间
        if (target > nums(mid) && target <= nums(r))
          l = mid + 1
        else if (target >= nums(l) || target < nums(mid))
          r = mid - 1
        else
          return -1
      }
    }
    if (nums(l) == target) l else -1
  }
}
