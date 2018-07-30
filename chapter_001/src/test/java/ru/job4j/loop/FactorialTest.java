package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Nikolay Gorbunov (mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {
    @Test
    public void whenNumberIsFive() {
        Factorial factorial = new Factorial();
        int result = factorial.calc( 5);
        assertThat(result, is(120));
    }
    @Test
    public void whenNumberIsZero() {
        Factorial factorial = new Factorial();
        int result = factorial.calc( 0);
        assertThat(result, is(1));
    }
    @Test
    public void whenNumberIsMinusTen() {
        Factorial factorial = new Factorial();
        int result = factorial.calc( -10);
        assertThat(result, is(0));
    }
}
