package leetcode.hard.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/61/design/162/
 *
 * 给出一个嵌套的整型列表。设计一个迭代器，遍历这个整型列表中的所有整数。
 * 列表中的项或者为一个整数，或者是另一个列表。
 *
 * 示例 1:
 * 给定列表 [[1,1],2,[1,1]],
 * 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1].
 *
 * 示例 2:
 * 给定列表 [1,[4,[6]]],
 * 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> nums = new ArrayList<>();
    private Iterator<Integer> iterator = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        nestedList.forEach(this::addNestedInteger);
        iterator = nums.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void addNestedInteger(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            nums.add(nestedInteger.getInteger());
        } else {
            nestedInteger.getList().forEach(this::addNestedInteger);
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
