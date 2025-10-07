package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

	@Mock
	Feline feline;

	@Test
	void getSoundGoodPositiveTest() {
		Cat cat = new Cat(feline);
		String expectedSound = "Мяу";
		String actualSound = cat.getSound();
		assertEquals(expectedSound, actualSound, "Ожидается, что кошки произносят звук 'Мяу'");

		System.out.println("Ожидается, что кошки произносят звук 'Мяу' : " + cat.getSound());
	}

	@Test
	void getSoundGoodNegativeTest() {
		Cat cat = new Cat(feline);
		String expectedSound = "Гав";
		String actualSound = cat.getSound();
		assertNotEquals(expectedSound, actualSound, "Ожидается, что кошки произносят звук 'Мяу', а не 'Гав'");

		System.out.println("Ожидается, что кошки произносят звук 'Мяу', а не 'Гав' : " + cat.getSound());
	}

	@Test
	void getFoodGoodPositiveTest() throws Exception {
		Cat cat = new Cat(feline);
		List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
		Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
		List<String> actualFood = cat.getFood();
		assertEquals(expectedFood, actualFood);

		System.out.println("Ожидается, что кошки едят 'Животных, Птиц, Рыб' : " + cat.getFood());
	}

	@Test
	void getFoodGoodNegativeTest() throws Exception {
		Cat cat = new Cat(feline);
		List<String> expectedFood = List.of("Трава", "Различные растения");
		Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
		List<String> actualFood = cat.getFood();
		assertNotEquals(expectedFood, actualFood);

		System.out.println("Ожидается, что кошки едят 'Животных, Птиц, Рыб' : " + cat.getFood());
	}
}