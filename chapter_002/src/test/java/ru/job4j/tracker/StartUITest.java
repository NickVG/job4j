package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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

    /**
     * Метод выполняющийся перед каждым тестом перехватывающий поток
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод выполняющийся после каждого тесте возвращающий поток в консоль
     */
    @After
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
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, this.tracker).init();
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
        Input input = new StubInput(new String[]{"2", item1.getId(), "test replace", "заменили заявку", "y"});
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
        Input input = new StubInput(new String[]{"1", "y"});
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        assertThat(new String(out.toByteArray()), is(
                new String(new StringBuilder()
                        .append(startUI.getMenu())
                        .append("------------ Спиcок всех имеющихся заявок:  --------------").append(System.lineSeparator())
                        .append(test3[0].toString()).append(System.lineSeparator())
                        .append(test3[1]).append(System.lineSeparator())
                        .append(test3[2]).append(System.lineSeparator())
                        )));
    }

    /**
     * Метод проверяющий поиск заявик по имени
     * создаём StubInput с последовательностью действий(производим писк заявок по имени)
     * создаём StartUI и вызываем метод init()
     * проверяем, что метод осуществляющий поиск совпадает с верным результатом
     */
    @Test
    public void whenShowAllTasksByName() {
        Input input = new StubInput(new String[]{"5", "test name1", "y"});
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        assertThat(new String(out.toByteArray()), is(
                new String(new StringBuilder()
                        .append(startUI.getMenu())
                        .append("------------ Поиск заявки по имени--------------").append(System.lineSeparator())
                        .append("------------ спиcок заявок с совпадающим именем: ").append(Arrays.toString(this.test2)).append("-----------").append(System.lineSeparator())
                        .append(System.lineSeparator())
                        )));
    }

    /**
     * Метод проверяющий удаление заявки
     * создаём StubInput с последовательностью действий(производим удаление заявки)
     * создаём StartUI и вызываем метод init()
     */
    @Test
    public void whenDeleteTask() {
        Input input = new StubInput(new String[]{"3", item3.getId(), "y"});
        new StartUI(input, this.tracker).init();
        assertThat((this.tracker.findAll()), is((this.test2)));
    }
}