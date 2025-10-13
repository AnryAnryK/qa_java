package com.example;

import java.util.List;

public class LionAlex extends Lion {

	public LionAlex(Feline feline) throws Exception {
		super("Самец", feline);
	}

	public List<String> getFriends() {
		return List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
	}

	public String getPlaceOfLiving() {
		return "Нью-Йоркский зоопарк";
	}

	@Override
	public int getKittens() {
		return getKittens(0);
	}

	public int getKittens(int kittensCount) {
		return kittensCount;
	}
}
