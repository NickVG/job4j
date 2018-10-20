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

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
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
        assertThat(this.tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * метод проверяющий обновление заявки
     * Напрямую добавляем заявку
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = this.tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Метод проверяющий поиск всех заявок
     * добавляем две заявки
     * создаём StubInput с последовательностью действий(производим замену заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenShowAllTasks() {
        Item item1 = this.tracker.add(new Item("test name1", "desc1"));
        Item item2 = this.tracker.add(new Item("test name2", "desc2"));
        Item[] test = {item1, item2};
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findAll(), is(test));
    }

    /**
     * Метод проверяющий поиск заявик по имени
     * Напрямую добавляем три заявки
     * создаём StubInput с последовательностью действий(производим писк заявок по имени)
     * Создаём массив типа Item содержащих две нужные заявки, которые должны появиться
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
     */
    @Test
    public void whenShowAllTasksByName() {
        Item item1 = this.tracker.add(new Item("test name1", "desc1"));
        Item item2 = this.tracker.add(new Item("test name2", "desc2"));
        Item item3 = this.tracker.add(new Item("test name2", "desc3"));
        Item[] test = {item2, item3};
        Input input = new StubInput(new String[]{"5", "test name2", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findByName("test name2"), is(test));
    }

    /**
     * Метод проверяющий удаление заявки
     * добавляем две заявки
     * создаём StubInput с последовательностью действий(производим удаление заявки)
     * создаём StartUI и вызываем метод init()
     * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenDeleteTask() {
        Item item1 = this.tracker.add(new Item("test name1", "desc1"));
        Item item2 = this.tracker.add(new Item("test name2", "desc2"));
        Item[] test = {item1, item2};
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, this.tracker).init();
        assertThat((this.tracker.findAll()), is((new Item[]{test[0]})));
    }
}