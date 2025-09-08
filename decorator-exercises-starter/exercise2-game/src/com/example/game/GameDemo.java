package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        // === COMPOSITION EXAMPLES ===
        
        // a) Base + SpeedBoost + DamageBoost
        System.out.println("\n--- Base + SpeedBoost(3) + DamageBoost(15) ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();
        
        // b) Add GoldenAura (sprite change + buffs)
        System.out.println("\n--- Adding GoldenAura ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();
        System.out.println("Speed: " + shiny.getSpeed() + ", Damage: " + shiny.getDamage() + ", Sprite: " + shiny.getSprite());
        
        // c) Remove GoldenAura by recomposing (rebuild chain without it)
        System.out.println("\n--- Removing GoldenAura (recomposition) ---");
        Character withoutAura = buffed; // reuse the previous composition without GoldenAura
        withoutAura.move();
        withoutAura.attack();
        
        // Additional example: Different composition order
        System.out.println("\n--- Different composition: GoldenAura + SpeedBoost + DamageBoost ---");
        Character differentOrder = new DamageBoost(new SpeedBoost(new GoldenAura(base), 5), 20);
        differentOrder.move();
        differentOrder.attack();
        System.out.println("Speed: " + differentOrder.getSpeed() + ", Damage: " + differentOrder.getDamage() + ", Sprite: " + differentOrder.getSprite());
    }
}
