package ru.job4j.max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Nikolay Gorbunov (mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenFirstLargerSecond() {
        Max maxim = new Max();
        int result = maxim.max(10, 2);
        assertThat(result, is(10));
    }
    @Test
    public void whenFirstIsLessThanSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, -2, 0);
        assertThat(result, is(1));
    }

    @Test
    public void whenFirstEqualsSecond() {
        Max maxim = new Max();
        int result = maxim.max(-2, -2, -2);
        assertThat(result, is(-2));
    }
}
