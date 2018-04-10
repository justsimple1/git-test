package ru.job4j.array;
/**
 * Слова начинается с ...
 * @author NikPanin .
 * @since 10.04.2018 .
 * @version 1 .
 */
public class ArrayChar {

    private char[] date;
    /**
     * Слово которое надо будет проверить с вводимым префиксом.
     * @param line - Вводимое слово.
     */
    public ArrayChar(String line){
        this.date = line.toCharArray();
    }

    /**
     * Метод проверяет наличие вводимого префикса в вводимое слово.
     * @param prefix - вводимый префикс.
     * @return - есть или нет.
     */
    public boolean startWith(String prefix){
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < prefix.length(); i++){
            if(this.date[i] != value[i]){
                return false;
            }
        }
        return result;
    }
}
