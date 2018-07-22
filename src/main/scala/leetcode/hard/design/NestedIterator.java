package leetcode.hard.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
