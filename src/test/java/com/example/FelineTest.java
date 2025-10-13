package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {

	@Mock
	Feline feline;

	Animal animal;

	@Test
	public void eatMeatGoodPositiveTest() throws Exception {
		Feline feline = new Feline();
		List<String> expectVoid = List.of("Животные", "Птицы", "Рыба");
		List<String> actualVoid = feline.eatMeat();
		assertEquals(expectVoid, actualVoid, "Рацион представителей семейства кошачьих : 'Животные', 'Птицы', 'Рыба'");

		System.out.println("Рацион представителей семейства кошачьих: " + feline.eatMeat());
	}

	@Test
	public void eatMeatGoodNegativeTest() throws Exception {
		Feline feline = new Feline();
		List<String> expectVoid = List.of("Трава", "Различные растения");
		List<String> actualVoid = feline.eatMeat();
		assertNotEquals(expectVoid, actualVoid, "Рацион представителей семейства кошачьих : 'Животные', 'Птицы', 'Рыба'");

		System.out.println("Рацион представителей семейства кошачьих: " + feline.eatMeat());
	}

	@Test
	public void getFamilyGoodPositiveTest() throws Exception {
		Feline feline = new Feline();
		String expectFamily = "Кошачьи";
		String actualFamily = feline.getFamily();
		assertEquals(expectFamily, actualFamily, "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
		System.out.println("Животные относятся к семейству - " + feline.getFamily());
	}

	@Test
	public void getAllFamilyGoodPositiveTest() throws Exception {
		Animal animal = new Animal();
		String expectFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
		String actualFamily = animal.getFamily();
		assertEquals(expectFamily, actualFamily, "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
		System.out.println("Метод getFamily() из класса Animal должен выводить : - " + animal.getFamily());
	}

	@Test
	public void getFamilyGoodNegativeTest() throws Exception {
		Feline feline = new Feline();
		String expectFamily = "Беличьи";
		String actualFamily = feline.getFamily();
		assertNotEquals(expectFamily, actualFamily, "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");

		System.out.println("Животные относятся к семейству - " + feline.getFamily());
	}

	@Test
	public void getKittensPositiveTest() throws Exception {
		Feline feline = new Feline();
		int expectKittensCount = 1;
		int actualKittensCount = feline.getKittens();
		assertEquals(expectKittensCount, actualKittensCount, "Животные семейства Кошачьи принесли приплод в количестве : 1");

		System.out.println("Животные семейства " + feline.getFamily() + " принесли приплод в количестве: " + feline.getKittens());
	}

	@Test
	public void getKittensNegativeTest() throws Exception {
		Feline feline = new Feline();
		int expectKittensCount = 0;
		int actualKittensCount = feline.getKittens();
		assertNotEquals(expectKittensCount, actualKittensCount, "Животные семейства Кошачьи принесли приплод в количестве : 0");

		System.out.println("Животные семейства " + feline.getFamily() + " принесли приплод в количестве: " + feline.getKittens());
	}

	@Test
	public void testGetKittensCountPositiveTest() throws Exception {
		Feline feline = new Feline();
		int expectKittensCount = 2;
		int actualKittensCount = feline.getKittens(2);
		assertEquals(expectKittensCount, actualKittensCount, "Животные семейства Кошачьи принесли приплод в количестве : 2");

		System.out.println("Общее количество животных " + feline.getFamily() + " стало: " + feline.getKittens());
	}

	@Test
	public void testGetKittensCountNegativeTest() throws Exception {
		Feline feline = new Feline();
		int expectKittensCount = 1;
		int actualKittensCount = feline.getKittens(0);
		assertNotEquals(expectKittensCount, actualKittensCount, "Животные семейства Кошачьи принесли приплод в количестве : 0");

		System.out.println("Общее количество животных " + feline.getFamily() + " стало: " + feline.getKittens());
	}
}

