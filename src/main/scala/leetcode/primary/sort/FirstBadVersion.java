package leetcode.primary.sort;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 *
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 */
public class FirstBadVersion {
    /**
     * 其实就是二分查找
     */
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while(l < r){
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean isBadVersion(int version) {
        return version >= firstBad;
    }

    private int firstBad;

    public FirstBadVersion(int firstBad) {
        this.firstBad = firstBad;
    }
}
