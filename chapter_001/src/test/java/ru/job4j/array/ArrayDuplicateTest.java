package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author NikPanin .
 * @since 11.04.2018 .
 * @version 1 .
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] arrays = new String []{"Katya","Olga","Masha","Nastya", "Sasha", "Katya","Nastya", "Yla", "Sasha","Katya"};
        String[] result = arrayDuplicate.remove(arrays);
        String[] expected = new String[]{"Katya","Olga","Masha","Nastya", "Sasha","Yla"};
        assertThat(result,is(expected));
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
    }
}

