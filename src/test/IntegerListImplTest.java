package test;

import exception.IncorrectIndexException;
import exception.NoArrayException;
import exception.IntegerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import integerlist.IntegerListImpl;

class IntegerListImplTest {
    IntegerListImpl array;
    @BeforeEach
    void init() {
        array = new IntegerListImpl();
        for (int i=0; i<9; i++) {
            array.add(i);
        }
    }

    @Test
    @DisplayName("Тест проверяет правильность добавления элемента")
    void add() {
        Integer expectedInteger = (9);
        Integer actualInteger = array.add(9);
        Assertions.assertEquals(expectedInteger,actualInteger);
        Assertions.assertEquals(10,array.size());
    }
    @Test
    @DisplayName("Тест проверяет правильность добавления элемента по индексу")
    void addIndex() {
        Integer expectedInteger = (9);
        Integer actualInteger = array.add(2,9);
        Assertions.assertEquals(expectedInteger,actualInteger);
        Assertions.assertEquals(10,array.size());
    }

    @Test
    @DisplayName("Тест проверяет выброс исключения IncorrectIndex при добавлении элемента")
    void testAdd() {
        //index<0
        Assertions.assertThrows(IncorrectIndexException.class, () -> array.add(-1, 9));
        //index больше чем массив
        Assertions.assertThrows(IncorrectIndexException.class, () -> array.add(10, 9));    }

    @Test
    @DisplayName("Проверяет изменение элемента")
    void set() {
        Integer expected = (9);
        Integer actual = array.set(2, 9);
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(9,array.size());
    }
    @Test
    @DisplayName("Проверяет выброс исключения при изменении элемента")
    void setTest() {
        Assertions.assertThrows(IncorrectIndexException.class, ()-> array.set(-1, 9));
    }

    @Test
    @DisplayName("Тест проверяет корректность удаления элемента")
    void remove() {
        Integer expected = (8);
        Integer actual = array.remove(8);
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(8,array.size());
    }

    @Test
    @DisplayName("Тест проверяет выброс исключения при удалении несуществующего элемента")
    void testRemove() {
        Assertions.assertThrows(IntegerNotFoundException.class, ()-> array.remove((Integer)9));
    }

    @Test
    void contains() {
        Assertions.assertTrue(array.contains(8));
    }

    @Test
    void indexOf() {
        int expected = 8;
        int actual = array.indexOf(8);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void indexOfTest() {
        int expected = -1;
        int actual = array.indexOf(9);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf() {
        int expected = 0;
        int actual = array.lastIndexOf(8);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void lastIndexOfTest() {
        int expected = -1;
        int actual = array.lastIndexOf(9);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get() {
        Integer expected = 3;
        Integer actual = array.get(3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        IntegerListImpl expected = array;
        IntegerListImpl actual = new IntegerListImpl();
        for (int i=0; i<9; i++) {
            actual.add(i);
        }
        Assertions.assertTrue(expected.equals(actual));
    }
    @Test
    void testEqualsExcept() {
        IntegerListImpl expected = array;
        IntegerListImpl actual = null;
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