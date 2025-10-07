package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class LionTest {

	private static final String MALE = "Самец (с гривой)";
	private static final String FEMALE = "Самка (без гривы)";
	private static final String OTHER_SEX = "Используйте допустимые значения пола животного - самец или самка";

	@Mock
	Feline feline;


	@Test
	public void getKittensGoodPositiveScoreTest() throws Exception {
		Lion lion = new Lion("Самка", feline);
		lion.hasMane = false;
		Mockito.when(feline.getKittens()).thenReturn(1);
		int actualKittensCount = lion.getKittens();
		int expectedKittensCount = 1;
		assertEquals(expectedKittensCount, actualKittensCount, "Правильное число львят");
	}

	@Test
	public void getKittensGoodNegativeScoreTest() throws Exception {
		Lion lion = new Lion("Самка", feline);
		lion.hasMane = false;
		Mockito.when(feline.getKittens()).thenReturn(3);
		int actualKittensCount = lion.getKittens();
		int expectedKittensCount = 1;
		assertNotEquals(expectedKittensCount, actualKittensCount, "Неправильное число львят");
	}

	@Test
	void doesHaveManeGoodPositiveTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		boolean actualMale = lion.doesHaveMane();
		boolean expectedMale = true;
		assertEquals(expectedMale, actualMale, "если есть грива, то это: " + MALE);
		System.out.println("expectedMale = true, т.е. лев = " + MALE);
	}


	@Test
	void doesHaveManGoodNegativeTest() throws Exception {
		Lion lion = new Lion("Самка", feline);
		boolean actualMale = lion.doesHaveMane();
		boolean expectedMale = false;
		assertEquals(expectedMale, actualMale, "если есть грива, то это: " + FEMALE);
		System.out.println("expectedMale = false, т.е. лев = " + FEMALE);
	}


	@Test
	void getFoodGoodPositiveTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
		Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
		List<String> actualList = lion.getFood();
		assertEquals(expectedList, actualList, "питается этим");

		Lion lion5 = new Lion(lion);
		System.out.println(lion5.getFood("Хищник") + " - это едят хищники");
		System.out.println(lion5.getFood("Травоядное") + " - это не едят хищники");
	}

	@Test
	void getUnknownAnimalFoodGoodPositiveTest() throws Exception {
		try {
			Lion lion = new Lion("Самец", feline);
			lion.getFood("мягкая игрушка");
		} catch (Exception exception) {
			String expectMessageText = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
			assertEquals(expectMessageText, exception.getMessage());
		}
	}

	@Test
	void getUnknownAnimalFoodGoodNegativeTest() throws Exception {
		try {
			Lion lion = new Lion("Самец", feline);
			lion.getFood("мягкая игрушка");
		} catch (Exception exception) {
			String expectMessageText = "все львы - это мягкая игрушка";
			assertNotEquals(expectMessageText, exception.getMessage());
		}
	}

	@Test
	void getFoodGoodNegativePredatorEqualsHerbivoreTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Трава", "Различные растения"));
		List<String> actualList = lion.getFood("Травоядное");
		System.out.println("семейство Кошачьи с помощью Моск теперь едят : " + feline.getFood("Хищник"));
		System.out.println("соответственно львы помощью Моск теперь тоже едят : " + lion.getFood());
		System.out.println("теперь actualList возвращает Траву и Растения : " + actualList);
		assertEquals(feline.getFood("Хищник"), lion.getFood("Травоядное"), "хищники стали травоядными");
		System.out.println("И теперь хищники - стали травоядными");

		System.out.println("============================================================================================");
		Lion lion2 = new Lion(lion);
		System.out.println(lion2.getFood("Хищник") + " а вообще - это едят хищники");
		System.out.println(lion2.getFood("Травоядное") + " а вообще - это не едят хищники");
	}

	@Test
	void eatMeatGoodPositiveTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		List<String> expectedVoidEatMeat = List.of("Животные", "Птицы", "Рыба");
		List<String> actualVoidEatMeat = lion.eatMeat();
		assertEquals(expectedVoidEatMeat, actualVoidEatMeat);

		Lion lion1 = new Lion("Самец", feline);
		System.out.println("Рацион хищника (хотя метод eatMeat означает именно 'мясо', а в массиве указаны ещё и птица, и рыба, что 'мясом', по-моему мнению, не является... это так, к слову : " + lion1.eatMeat());

	}

	@Test
	void eatMeatGoodNegativeTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		List<String> expectedVoidEatMeat = List.of("Трава", "Различные растения");
		List<String> actualVoidEatMeat = lion.eatMeat();
		assertNotEquals(expectedVoidEatMeat, actualVoidEatMeat);

		Lion lion1 = new Lion("Самец", feline);
		System.out.println("Рацион хищника (хотя метод eatMeat означает именно 'мясо', а в массиве указаны ещё и птица, и рыба, что 'мясом', по-моему мнению, не является... это так, к слову : " + lion1.eatMeat());
	}

	@Test
	void getFamilyGoodPositiveTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		String expectedFamily = "Кошачьи";
		String actualFamily = lion.getFamily();
		assertEquals(expectedFamily, actualFamily);
		System.out.println("Ожидается, что львы относятся к семейству 'Кошачьи': " + lion.getFamily());
	}

	@Test
	void getOtherSexGoodPositiveTest() throws Exception {
		try {
			Lion lion = new Lion("амка", feline);
		} catch (Exception exception) {
			String expectMessageText = "Используйте допустимые значения пола животного - самец или самка";
			assertEquals(expectMessageText, exception.getMessage());
		}
	}

	@Test
	void getOtherSexGoodNegativeTest() throws Exception {
		try {
			Lion lion = new Lion("амка", feline);
		} catch (Exception exception) {
			String expectMessageText = "Используйте допустимые значения пола животного - амец или амка";
			assertNotEquals(expectMessageText, exception.getMessage());
		}
	}


	@Test
	void getFamilyGoodNegativeTest() throws Exception {
		Lion lion = new Lion("Самка", feline);
		String expectedFamily = "Кошачьи2";
		String actualFamily = lion.getFamily();
		assertNotEquals(expectedFamily, actualFamily);

		System.out.println("Ожидается, что львы относятся к семейству 'Кошачьи', а не 'Кошачьи2' и т.п. : " + lion.getFamily());
	}

	@Test
	void getSoundGoodPositiveTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		String expectedSound = "Р-р-р";
		String actualSound = lion.getSound();
		assertEquals(expectedSound, actualSound);

		System.out.println("Ожидается, что львы произносят звук 'Р-р-р' : " + lion.getSound());
	}

	@Test
	void getSoundGoodNegativeTest() throws Exception {
		Lion lion = new Lion("Самец", feline);
		String expectedSound = "Р-р-р";
		String actualSound = lion.getSound();
		assertEquals(expectedSound, actualSound);

		System.out.println("Ожидается, что львы произносят звук 'Р-р-р', а не 'Мяу' и т.п.  : " + lion.getSound());
	}
}