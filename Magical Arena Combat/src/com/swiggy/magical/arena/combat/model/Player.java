package com.swiggy.magical.arena.combat.model;

import java.util.Random;

public class Player {
	private int health;
    private int strength;
    private int attack;
    private Random random;

    public Player(int health, int strength, int attack) {
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
}
