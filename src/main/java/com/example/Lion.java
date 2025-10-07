package com.example;

import java.util.List;

public class Lion extends Animal implements Predator {

	private Feline feline;
	private Lion lion;
	boolean hasMane;


	public Lion(Lion lion) {
		this.lion = lion;
	}

	public Lion(String sex, Feline feline) throws Exception {
		this.feline = feline;
		if ("Самец".equals(sex)) {
			hasMane = true;
		} else if ("Самка".equals(sex)) {
			hasMane = false;
		} else {
			throw new Exception("Используйте допустимые значения пола животного - самец или самка");
		}
	}

	public Lion() {
	}


	public int getKittens() {   // новый код
		return feline.getKittens();
	}

	public boolean doesHaveMane() {
		return hasMane;
	}


	public List<String> getFood() throws Exception {
		return feline.getFood("Хищник");
	}


	@Override
	public List<String> eatMeat() throws Exception {
		return List.of("Животные", "Птицы", "Рыба");
	}

	public String getFamily() {
		return "Кошачьи";
	}


	public String getSound() {
		return "Р-р-р";
	}
}
