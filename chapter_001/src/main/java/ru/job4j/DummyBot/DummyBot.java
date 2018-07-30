package ru.job4j.DummyBot;


/**
 * Class Calculate решение задачи 4.1
 *
 * @author Nikolay Gorbunov
 * @since 0.0.1
 */

public class DummyBot {
    /**
     * Отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            // Ответ при приветствии бота
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)){ //Ответ при прощании с ботом
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
