package com.swiggy.magical.arena.combat.model;

import java.util.Random;

public class Player {
	
	private String playerName;
	private int health;
	private int strength;
	private int attack;
	private Random random;

	public Player(String playerName,int health, int strength, int attack) {
		this.playerName=playerName;
		this.health = health;
		this.strength = strength;
		this.attack = attack;
		this.random = new Random();
	}

	public int rollDice() {
		return random.nextInt(6) + 1;
	}

	public int attack() {
		return rollDice() * attack;
	}

	public int defend() {
		return rollDice() * strength;
	}

	public void takeDamage(int damage) {
		health = Math.max(0, health - damage);
	}

	public int getHealth() {
		return health;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", health=" + health + "]";
	}
	
	
}
