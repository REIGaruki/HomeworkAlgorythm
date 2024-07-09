package integerlist;

import exception.IncorrectIndexException;
import exception.NoArrayException;
import exception.IntegerNotFoundException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    public IntegerListImpl() {
        this.integerList = new Integer[0];
    }

    @Override
    public Integer add(Integer item) {
        int newSize = integerList.length + 1;
        Integer[] Integers = new Integer[newSize];
        for (int i = 0; i< integerList.length; i++) {
            Integers[i] = integerList[i];
        }
        Integers[newSize - 1] = item;
        integerList = Integers;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index >= integerList.length) {
            throw new IncorrectIndexException("index out of bounds");
        }
        int newSize = integerList.length + 1;
        Integer[] Integers = new Integer[newSize];
        for (int i=0; i< index; i++) {
            Integers[i] = integerList[i];
        }
        Integers[index] = item;
        for (int i=index+1; i< newSize; i++) {
            Integers[i] = integerList[i - 1];
        }
        integerList = Integers;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= integerList.length) {
            throw new IncorrectIndexException("index out of bounds");
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int newSize = integerList.length - 1;
        Integer[] Integers = new Integer[newSize];
        int index = this.indexOf(item);
        if (index == -1) {
            throw new IntegerNotFoundException("Element is not found");
        }
        for (int i=0; i< index; i++) {
            Integers[i] = integerList[i];
        }
        for (int i = index + 1; i< integerList.length; i++) {
            Integers[i - 1] = integerList[i];
        }
        integerList = Integers;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= integerList.length) {
            throw new IncorrectIndexException("index out of bounds");
        }
        Integer item = integerList[index];
        int newSize = integerList.length - 1;
        Integer[] Integers = new Integer[newSize];
        for (int i=0; i< index; i++) {
            Integers[i] = integerList[i];
        }
        for (int i = index + 1; i< integerList.length; i++) {
            Integers[i - 1] = integerList[i];
        }
        integerList = Integers;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        long start = System.currentTimeMillis();
//        Integer[] sortedList1 = toArray();
//        sortListBubble(sortedList1);
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        Integer[] sortedList2 = toArray();
//        sortListSelection(sortedList2);
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
        Integer[] sortedList3 = toArray();
        sortListInsertion(sortedList3);
        System.out.println(System.currentTimeMillis() - start);
        int min = 0;
        int max = sortedList3.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == sortedList3[mid]) {
                return true;
            }

            if (item < sortedList3[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        return getIndex(item);
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index = getIndex(item);
        if (index>=0) {
            index = integerList.length - 1 - index;
        }
        return index;
    }
    private int getIndex(Integer item) {
        for (int i = 0; i<= integerList.length/2; i++) {
            int j = integerList.length - 1 - i;
            if (integerList[j].equals(item)) {
                return j;
            }
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NoArrayException("Integer list is null");
        }
        if (this.size() != otherList.size()) {
            return false;
        }
        for (int i=0; i<this.size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
//        Integerlist.IntegerListImpl that = (Integerlist.IntegerListImpl) otherList;
//        return Arrays.equals(IntegerList, that.IntegerList);
    }

    @Override
    public int size() {
        return integerList.length;
    }

    @Override
    public boolean isEmpty() {
        return (integerList.length == 0);
    }

    @Override
    public void clear() {
        integerList = new Integer[0];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, this.size());
    }
    private Integer[] sortListBubble(Integer[] integerList) {
        for (int i = 0; i < integerList.length - 1; i++) {
            for (int j = 0; j < integerList.length - 1 - i; j++) {
                if (integerList[j] > integerList[j + 1]) {
                    swapElements(integerList, j, j + 1);
                }
            }
        }
        return integerList;
    }
    private Integer[] sortListSelection(Integer[] integerList) {
        for (int i = 0; i < integerList.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integerList.length; j++) {
                if (integerList[j] < integerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integerList, i, minElementIndex);
        }
        return integerList;
    }
    private Integer[] sortListInsertion(Integer[] integerList) {
        for (int i = 0; i < integerList.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integerList.length; j++) {
                if (integerList[j] < integerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integerList, i, minElementIndex);
        }
        return integerList;
    }

private static void swapElements(Integer[] arr, int indexA, int indexB) {
    int tmp = arr[indexA];
    arr[indexA] = arr[indexB];
    arr[indexB] = tmp;
}

    @Override
    public String toString() {
        return Arrays.toString(integerList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerList);
    }
}
