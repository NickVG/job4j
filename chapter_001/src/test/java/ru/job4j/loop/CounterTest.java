package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Nikolay Gorbunov (mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {
    @Test
    public void whenFirstIsOneAndLastIsTen() {
        Counter counter = new Counter();
        int result = counter.add( 1, 11);
        assertThat(result, is(30));
    }
}