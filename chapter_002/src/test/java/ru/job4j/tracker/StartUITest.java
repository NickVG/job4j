package ru.job4j.tracker;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartUITest
 * Реализация тестов класса StartUI
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {
    /**
     * Метод проверяющий создание заявок
     * создаём Tracker
     * создаём StubInput с последовательностью действий
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * метод проверяющий обновление заявки
     * создаём Tracker
     * Напрямую добавляем заявку
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Метод проверяющий поиск всех заявок
     * создаём Tracker
     * добавляем две заявки
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenShowAllTasks() {

        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item[] test = {item1, item2};
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(test));
    }
    /**
     * Метод проверяющий поиск заявик по имени
     * создаём Tracker
     * Напрямую добавляем три заявки
     * создаём StubInput с последовательностью действий(производим писк заявок по имени)
     * Создаём массив типа Item содержащих две нужные заявки, которые должны появиться
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
     */
    @Test
    public void whenShowAllTasksByName() {
        //
        Tracker tracker = new Tracker();
        //
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name2", "desc3"));
        Item[] test = {item2, item3};
        Input input = new StubInput(new String[]{"5", "test name2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test name2"), is(test));
    }

    /**
     * Метод проверяющий удаление заявки
     * cоздаём Tracker
     * добавляем две заявки
     * создаём StubInput с последовательностью действий(производим удаление заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenDeleteTask() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item[] test = {item1, item2};
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat((tracker.findAll()), is((new Item[]{test[0]})));
    }

    /**
     * Метод поиск заявки по ID
     * cоздаём Tracker
     * добавляем две заявки
     * создаём StubInput с последовательностью действий(производим удаление заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что поиск работает верно.

    @Test
    public void whenAskToShowTaskByID() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        String id =  item2.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id), is(id));
    }
     */
}