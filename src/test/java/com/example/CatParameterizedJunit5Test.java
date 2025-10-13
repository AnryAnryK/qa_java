package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CatParameterizedJunit5Test {

	Feline feline;

	@ParameterizedTest
	@CsvSource({
			"Р-р-р, false",
			"Мяу, true",
			"Гав, false"
	})
	void getSoundGoodPositiveAndNegativeCsvSourceTest(String expectVoice, boolean expectedBoolean) throws Exception {
		Cat cat = new Cat(feline);
		assertEquals(expectedBoolean, cat.getSound().equals(expectVoice));
	}
}
