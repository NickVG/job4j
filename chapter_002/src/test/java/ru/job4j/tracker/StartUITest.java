package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

/**
 * Class StartUITest
 * Реализация тестов класса StartUI
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

    Tracker tracker = new Tracker();
    Input input;

    /**
     * @stdout содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * @out буфер для хранения вывода
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * item1, item2 item3 добавленные в ручную заявки используемые в тестах
     * test2 - массив типа Item использующий первые две заявки
     * test3 - массив типа Item использующий все заявки
     */
    Item item1 = this.tracker.add(new Item("test name1", "desc1"));
    Item item2 = this.tracker.add(new Item("test name1", "desc2"));
    Item item3 = this.tracker.add(new Item("test name2", "desc3"));
    Item[] test3 = {item1, item2, item3};
    Item[] test2 = {item1, item2};

    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    public void backOutput() {
        System.setOut(this.stdout);
    }
    /**
     * Метод проверяющий создание заявок
     * создаём StubInput с последовательностью действий
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        this.input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(this.tracker.findAll()[3].getName(), is("test name"));
    }

    /**
     * метод проверяющий обновление заявки
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", item1.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findById(item1.getId()).getName(), is("test replace"));
    }

    /**
     * Метод проверяющий поиск всех заявок
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenShowAllTasks() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findAll(), is(this.test3));
    }

    /**
     * Метод проверяющий поиск заявик по имени
     * создаём StubInput с последовательностью действий(производим писк заявок по имени)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
     */
    @Test
    public void whenShowAllTasksByName() {
        Input input = new StubInput(new String[]{"5", "test name1", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findByName("test name1"), is(this.test2));
    }

    /**
     * Метод проверяющий удаление заявки
     * создаём StubInput с последовательностью действий(производим удаление заявки)
     * создаём StartUI и вызываем метод init()
     *
     */
    @Test
    public void whenDeleteTask() {
        Input input = new StubInput(new String[]{"3", item3.getId(), "6"});
        new StartUI(input, this.tracker).init();
        assertThat((this.tracker.findAll()), is((this.test2)));
    }

    /**
     * Второй метод проверяющий поиск всех заявок
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что выводятся верные 2 заявки.
     */
    @Test
    public void whenShowAllTasks2() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        this.input = new StubInput(new String[]{"1", "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(this.tracker.findAll(), is(this.test3));
//        assertThat(new String(out.toByteArray()), is(this.tracker.findAll()));
        System.setOut(stdout);

    }
}