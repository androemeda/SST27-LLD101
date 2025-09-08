package com.example.game;

/**
 * Decorator that adds a damage boost to a character.
 */
public class DamageBoost extends CharacterDecorator {
    private int damageIncrease;

    public DamageBoost(Character character, int damageIncrease) {
        super(character);
        this.damageIncrease = damageIncrease;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " (damage boosted!)");
    }

    @Override
    public int getDamage() {
        return character.getDamage() + damageIncrease;
    }
}