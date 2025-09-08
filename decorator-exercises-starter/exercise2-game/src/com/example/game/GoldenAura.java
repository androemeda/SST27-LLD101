package com.example.game;

/**
 * Decorator that adds a golden aura to a character.
 * Changes sprite and provides small buffs while logging aura effects.
 */
public class GoldenAura extends CharacterDecorator {
    private int speedBonus = 2;
    private int damageBonus = 5;

    public GoldenAura(Character character) {
        super(character);
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite() + " ✨ [Golden Aura glowing]");
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " ✨ [Golden Aura empowering attack]");
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + speedBonus;
    }

    @Override
    public int getDamage() {
        return character.getDamage() + damageBonus;
    }

    @Override
    public String getSprite() {
        return "golden_" + character.getSprite();
    }
}