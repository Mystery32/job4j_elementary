package ru.job4j.game.units;

import ru.job4j.game.Alliance;
import ru.job4j.game.Horde;

import java.util.Random;

public class CrossbowmanHuman extends Alliance {

    public CrossbowmanHuman() {
        this.setHero("Crossbowman");
        this.setRace("Human");
        this.setDamage(3);
        this.setWeaponDamage(5);
        this.setHealth(super.getHealth());
    }

    public void attackWeapon(Horde enemy) {
        System.out.println(getHero() + " " + getRace() + " стреляет из арбалета по " + enemy.getHero() + " "
                + enemy.getRace() + " на " + getWeaponDamage() + " HP");
       enemy.takeDamage(getWeaponDamage());
    }

    public void attack(Horde enemy) {
        System.out.println(getHero() + " " + getRace() + " наносит атаку по " + enemy.getHero() + " "
                + enemy.getRace() + " на " + getDamage() + " HP");
        enemy.takeDamage(getDamage());
    }

    @Override
    public void ability(Horde enemy, Alliance hero) {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(2);
        if (randomNumber == 0) {
            attack(enemy);
        } else {
            attackWeapon(enemy);
        }
    }

    @Override
    public void takeDamage(double damage) {
        if (isAlive() && getHealth() <= damage) {
            setHealth(0);
            System.out.println(getHero() + " " + getRace() + " убили");
        } else {
            setHealth(getHealth() - Math.min(getHealth(), damage));
            System.out.println(getHero() + " " + getRace() + " получил урон " + damage + ". Осталось " + getHealth() + " HP");
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public void getUpgrade() {
        this.setStatus("Improved");
        this.setDamage(getDamage() * 1.5);
        this.setWeaponDamage(getWeaponDamage() * 1.5);
    }

    @Override
    public  void getSick() {
        this.setDamage(getDamage() * 0.5);
        this.setWeaponDamage(getWeaponDamage() * 0.5);
    }

    public void getCursed() {
        this.setStatus("Normal");
        this.setDamage(getDamage() / 1.5);
        this.setWeaponDamage(getWeaponDamage() / 1.5);
    }

    @Override
    public String toString() {
        return getHero() + " " + getRace();
    }
}
