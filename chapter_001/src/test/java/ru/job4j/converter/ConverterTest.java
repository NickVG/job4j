package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test
 *
 * @author Nikolay Gorbunov (krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class ConverterTest {
	@Test
	public void when60RubleToDollarThen1() {
		Converter converter = new Converter();
		int result = converter.rubleToDollar(60);
		assertThat(result, is(1));
	}

	@Test
	public void when70RubleToEuroThen1() {
		Converter converter = new Converter();
		int result = converter.rubleToEuro(70);
		assertThat(result, is(1));
	}
}