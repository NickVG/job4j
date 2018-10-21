package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Nikolay Gorbunov (krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {

    /**
     * @stdout содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * @out буфер для хранения вывода
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * метод для инициализации вывода в консоль
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * метод для инициализации вывода в консоль
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест проверяющий отрисковку квадрата
     * получаем ссылку на стандартный вывод в консоль.
     * Создаем буфур для хранения вывода.
     * Заменяем стандартный вывод на вывод в пямять для тестирования.
     * выполняем действия пишушиее в консоль.
     * проверяем результат вычисления
     * возвращаем обратно стандартный вывод в консоль.
     */
    @Test
    public void whenDrawSquare() {
        this.loadOutput();
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("++++")
                                .append(System.lineSeparator()).append(System.lineSeparator())
                                .toString()
                )
        );
        this.backOutput();
    }

    /**
     * Тест проверяющий отрисковку треуглника
     * получаем ссылку на стандартный вывод в консоль.
     * Создаем буфур для хранения вывода.
     * Заменяем стандартный вывод на вывод в пямять для тестирования.
     * выполняем действия пишушиее в консоль.
     * проверяем результат вычисления
     * возвращаем обратно стандартный вывод в консоль.
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+").append(System.lineSeparator())
                                .append("+++").append(System.lineSeparator())
                                .append("+++++").append(System.lineSeparator())
                                .append("+++++++")
                                .append(System.lineSeparator()).append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}
