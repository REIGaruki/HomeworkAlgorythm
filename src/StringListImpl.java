import java.util.Arrays;

public class StringListImpl implements StringList{
    private String[] stringList;
    public StringListImpl() {
        this.stringList = new String[0];
    }

    @Override
    public String add(String item) {
        int newSize = stringList.length + 1;
        String[] strings = new String[newSize];
        for (int i=0; i< stringList.length; i++) {
            strings[i] = stringList[i];
        }
        strings[newSize - 1] = item;
        stringList = strings;
        return item;
    }

    @Override
    public String add(int index, String item) {
        int newSize = stringList.length + 1;
        String[] strings = new String[newSize];
        for (int i=0; i< index; i++) {
            strings[i] = stringList[i];
        }
        strings[index] = item;
        for (int i=index+1; i< newSize; i++) {
            strings[i] = stringList[i - 1];
        }
        stringList = strings;
        return item;
    }

    @Override
    public String set(int index, String item) {
        stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int newSize = stringList.length - 1;
        String[] strings = new String[newSize];
        int index = this.indexOf(item);
        for (int i=0; i< index; i++) {
            strings[i] = stringList[i];
        }
        for (int i=index + 1; i< stringList.length; i++) {
            strings[i - 1] = stringList[i];
        }
        stringList = strings;
        return item;
    }

    @Override
    public String remove(int index) {
        String item = stringList[index];
        int newSize = stringList.length - 1;
        String[] strings = new String[newSize];
        for (int i=0; i< index; i++) {
            strings[i] = stringList[i];
        }
        for (int i=index + 1; i< stringList.length; i++) {
            strings[i - 1] = stringList[i];
        }
        stringList = strings;
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (int i=0; i< stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i=0; i< stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i=stringList.length - 1; i>=0 ; i--) {
            if (stringList[i].equals(item)) {
                return stringList.length - 1 - i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        StringListImpl that = (StringListImpl) otherList;
        return Arrays.equals(stringList, that.stringList);
    }

    @Override
    public int size() {
        return stringList.length;
    }

    @Override
    public boolean isEmpty() {
        return (stringList.length == 0);
    }

    @Override
    public void clear() {
        stringList = new String[0];
    }

    @Override
    public String[] toArray() {
        String[] strings = new String[stringList.length];
        for (int i=0; i< stringList.length; i++) {
            strings[i] = stringList[i];
        }
        return strings;
    }

    @Override
    public String toString() {
        return Arrays.toString(stringList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(stringList);
    }
}
