package integerlist;

import exception.IncorrectIndexException;
import exception.NoArrayException;
import exception.IntegerNotFoundException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] IntegerList;
    public IntegerListImpl() {
        this.IntegerList = new Integer[0];
    }

    @Override
    public Integer add(Integer item) {
        int newSize = IntegerList.length + 1;
        Integer[] Integers = new Integer[newSize];
        for (int i=0; i< IntegerList.length; i++) {
            Integers[i] = IntegerList[i];
        }
        Integers[newSize - 1] = item;
        IntegerList = Integers;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index >= IntegerList.length) {
            throw new IncorrectIndexException("index out of bounds");
        }
        int newSize = IntegerList.length + 1;
        Integer[] Integers = new Integer[newSize];
        for (int i=0; i< index; i++) {
            Integers[i] = IntegerList[i];
        }
        Integers[index] = item;
        for (int i=index+1; i< newSize; i++) {
            Integers[i] = IntegerList[i - 1];
        }
        IntegerList = Integers;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= IntegerList.length) {
            throw new IncorrectIndexException("index out of bounds");
        }
        IntegerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int newSize = IntegerList.length - 1;
        Integer[] Integers = new Integer[newSize];
        int index = this.indexOf(item);
        if (index == -1) {
            throw new IntegerNotFoundException("Element is not found");
        }
        for (int i=0; i< index; i++) {
            Integers[i] = IntegerList[i];
        }
        for (int i=index + 1; i< IntegerList.length; i++) {
            Integers[i - 1] = IntegerList[i];
        }
        IntegerList = Integers;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= IntegerList.length) {
            throw new IncorrectIndexException("index out of bounds");
        }
        Integer item = IntegerList[index];
        int newSize = IntegerList.length - 1;
        Integer[] Integers = new Integer[newSize];
        for (int i=0; i< index; i++) {
            Integers[i] = IntegerList[i];
        }
        for (int i=index + 1; i< IntegerList.length; i++) {
            Integers[i - 1] = IntegerList[i];
        }
        IntegerList = Integers;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        for (int i=0; i< IntegerList.length; i++) {
            if (IntegerList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i=0; i< IntegerList.length; i++) {
            if (IntegerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i=IntegerList.length - 1; i>=0 ; i--) {
            if (IntegerList[i].equals(item)) {
                return IntegerList.length - 1 - i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return IntegerList[index];
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
        return IntegerList.length;
    }

    @Override
    public boolean isEmpty() {
        return (IntegerList.length == 0);
    }

    @Override
    public void clear() {
        IntegerList = new Integer[0];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(IntegerList, this.size());
    }

    @Override
    public String toString() {
        return Arrays.toString(IntegerList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(IntegerList);
    }
}
