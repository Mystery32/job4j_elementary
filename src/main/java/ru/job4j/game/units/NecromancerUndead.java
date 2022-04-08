package ru.job4j.game.units;

import ru.job4j.game.Alliance;
import ru.job4j.game.Horde;

import java.util.Random;

public class NecromancerUndead extends Horde {

    public NecromancerUndead() {
        this.setHero("Necromancer");
        this.setRace("Undead");
        this.setDamage(5);
        this.setHealth(super.getHealth());
    }

    public void sick(Alliance enemy) {
        System.out.println(getHero() + " " + getRace() + " насылает недуг на " + enemy.getHero() + " "
                + enemy.getRace() + " уменьшая его урон на 50%");
        enemy.getSick();
    }

    public void attack(Alliance enemy) {
        System.out.println(getHero() + " " + getRace() + " наносит атаку по " + enemy.getHero() + " "
                + enemy.getRace() + " на " + getDamage() + " HP");
        enemy.takeDamage(getDamage());
    }

    @Override
    public void ability(Alliance enemy, Horde hero) {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(2);
        if (randomNumber == 0) {
            attack(enemy);
        } else {
            sick(enemy);
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
    public String toString() {
        return getHero() + " " + getRace();
    }
}
