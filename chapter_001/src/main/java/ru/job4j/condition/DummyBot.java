package ru.job4j.condition;
/**
 *
 * @author NikPanin .
 * @since 28.03.2018 .
 * @version 1 .
 */
public class DummyBot {

    /**
     *
     * @param question Вопрос пользователя.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if("Привет, Бот.".equals(question)){
            rsl = "Привет, умник.";
        }else if("Пока.".equals(question)){
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
