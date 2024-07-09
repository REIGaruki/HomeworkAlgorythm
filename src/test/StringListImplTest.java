package test;

import exception.IncorrectIndexException;
import exception.NoArrayException;
import exception.StringNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringlist.StringListImpl;

class StringListImplTest {
    StringListImpl array;
    @BeforeEach
    void init() {
        array = new StringListImpl();
        for (int i=0; i<9; i++) {
            array.add("00"+i);
        }
    }

    @Test
    @DisplayName("Тест проверяет правильность добавления элемента")
    void add() {
        String expectedString = ("009");
        String actualString = array.add("009");
        Assertions.assertEquals(expectedString,actualString);
        Assertions.assertEquals(10,array.size());
    }
    @Test
    @DisplayName("Тест проверяет правильность добавления элемента по индексу")
    void addIndex() {
        String expectedString = ("009");
        String actualString = array.add(2,"009");
        Assertions.assertEquals(expectedString,actualString);
        Assertions.assertEquals(10,array.size());
    }

    @Test
    @DisplayName("Тест проверяет выброс исключения IncorrectIndex при добавлении элемента")
    void testAdd() {
        //index<0
        Assertions.assertThrows(IncorrectIndexException.class, () -> array.add(-1, "009"));
        //index больше чем массив
        Assertions.assertThrows(IncorrectIndexException.class, () -> array.add(10, "009"));    }

    @Test
    @DisplayName("Проверяет изменение элемента")
    void set() {
        String expected = ("009");
        String actual = array.set(2, "009");
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(9,array.size());
    }
    @Test
    @DisplayName("Проверяет выброс исключения при изменении элемента")
    void setTest() {
        Assertions.assertThrows(IncorrectIndexException.class, ()-> array.set(-1, "009"));
    }

    @Test
    @DisplayName("Тест проверяет корректность удаления элемента")
    void remove() {
        String expected = ("008");
        String actual = array.remove("008");
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(8,array.size());
    }

    @Test
    @DisplayName("Тест проверяет выброс исключения при удалении несуществующего элемента")
    void testRemove() {
        Assertions.assertThrows(StringNotFoundException.class, ()-> array.remove("009"));
    }

    @Test
    void contains() {
        Assertions.assertTrue(array.contains("004"));
    }

    @Test
    void indexOf() {
        int expected = 8;
        int actual = array.indexOf("008");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void indexOfTest() {
        int expected = -1;
        int actual = array.indexOf("009");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf() {
        int expected = 0;
        int actual = array.lastIndexOf("008");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void lastIndexOfTest() {
        int expected = -1;
        int actual = array.lastIndexOf("009");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get() {
        String expected = "003";
        String actual = array.get(3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        StringListImpl expected = array;
        StringListImpl actual = new StringListImpl();
        for (int i=0; i<9; i++) {
            actual.add("00"+i);
        }
        Assertions.assertTrue(expected.equals(actual));
    }
    @Test
    void testEqualsExcept() {
        StringListImpl expected = array;
        StringListImpl actual = null;
        Assertions.assertThrows(NoArrayException.class, ()-> expected.equals(actual));
    }

    @Test
    void size() {
        int expected = 9;
        int actual = array.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(array.isEmpty());
        array.clear();
        Assertions.assertTrue(array.isEmpty());
    }

    @Test
    void clear() {
        array.clear();
        int expected = 0;
        int actual = array.size();
        Assertions.assertEquals(expected, actual);
    }

}