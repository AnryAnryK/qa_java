package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionAlexTest {

	Feline feline;
	@Mock
	LionAlex lionAlex;
	@Mock
	Lion lion;


	@Test
	void getFriendsPositiveTest() throws Exception {

		LionAlex lionAlex = new LionAlex(feline);
		List<String> expectFreindsList = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
		List<String> actualFreindsList = lionAlex.getFriends();
		assertEquals(expectFreindsList, actualFreindsList);
		System.out.println("В друзьях у льва Алекса : " + lionAlex.getFriends());

	}

	@Test
	void getFriendsNagativeListofAndStringMatchingTest() throws Exception {
		LionAlex lionAlex = new LionAlex(feline);
		List<String> expectFreindsList = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
		String actualFreindsList = lionAlex.getFriends().toString();
		assertNotEquals(expectFreindsList, actualFreindsList);
		System.out.println("в expectFreindsList у нас Лист, т.е. Список значений, а в actualFreindsList значения приведены к Стрингу, в итоге у нас визуально выводится одно и то же, но это не метчится друг с другом, т.к. это - разные типы переменных :" + lionAlex.getFriends());

	}

	@Test
	public void getPlaceOfLivingPositiveTest() throws Exception {
		LionAlex lion = new LionAlex(feline);
		String expectPlaceOfLiving = "Нью-Йоркский зоопарк";
		String actualPlaceOfLiving = lion.getPlaceOfLiving();
		assertEquals(expectPlaceOfLiving, actualPlaceOfLiving);
		System.out.println("Лев Алекс находится в 'Нью-Йоркский зоопарк' : " + lion.getPlaceOfLiving());
	}

	@Test
	public void getPlaceOfLivingNegativeTest() throws Exception {
		LionAlex lion = new LionAlex(feline);
		String expectPlaceOfLiving = "Катманду";
		String actualPlaceOfLiving = lion.getPlaceOfLiving();
		assertNotEquals(expectPlaceOfLiving, actualPlaceOfLiving);
		System.out.println("Ожидается, что Лев Алекс находится в зоопарке в Катманду,  а он в : " + lion.getPlaceOfLiving());
	}


	@Test
	public void getChangePlaceOfLivingPositiveTest() throws Exception {
		Lion lion = new LionAlex(feline);
		Mockito.when(lionAlex.getPlaceOfLiving()).thenReturn("Москва");
		String actualPlaceOfLiving = lionAlex.getPlaceOfLiving();
		assertEquals(lionAlex.getPlaceOfLiving(), actualPlaceOfLiving);
		System.out.println("Льва Алекса перевели из 'Нью-Йоркский зоопарк' в зоопарк 'Москва', если выводится 'Москва', значит всё ок :) : " + lionAlex.getPlaceOfLiving());
	}

	@Test
	public void getChangePlaceOfLivingNegativeTest() throws Exception {
		Lion lion = new LionAlex(feline);
		String expectPlaceOfLiving = "Нью-Йоркский зоопарк";
		Mockito.when(lionAlex.getPlaceOfLiving()).thenReturn("Москва");
		String actualPlaceOfLiving = lionAlex.getPlaceOfLiving();
		assertNotEquals(expectPlaceOfLiving, actualPlaceOfLiving);
		System.out.println("Льва Алекса перевели из 'Нью-Йоркский зоопарк' в зоопарк 'Москва', если ожидаемое место нахождения льва Алекса 'Нью-Йоркский зоопарк', значит лев Алекс оттуда сбежал  - внимание, Лев в городе на свободе !!!) : " + lionAlex.getPlaceOfLiving());
	}


	@Test
	void getKittensGoodPositiveTest() throws Exception {
		LionAlex lionAlex = new LionAlex(feline);
		int expectCountOfKitten = 0;
		int actualCountOfKitten = lionAlex.getKittens();
		assertEquals(+expectCountOfKitten, actualCountOfKitten, "Известно, что у льва Алекса нет потомства, поэтому ожидаемый ответ : 0");

		System.out.println("Известно, что у льва Алекса нет потомства, поэтому ожидаемый ответ : 0");
	}

	@Test
	void getKittensGoodNegativeTest() throws Exception {
		LionAlex lionAlex = new LionAlex(feline);
		int expectCountOfKitten = 1;
		int actualCountOfKitten = lionAlex.getKittens();
		assertNotEquals(+expectCountOfKitten, actualCountOfKitten, "Известно, что у льва Алекса нет потомства, поэтому ожидаемый ответ : 0");

		System.out.println("Известно, что у льва Алекса нет потомства, поэтому ожидаемый ответ : 0");
	}
}