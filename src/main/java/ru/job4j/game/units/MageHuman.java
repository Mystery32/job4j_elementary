package ru.job4j.game.units;

import ru.job4j.game.Alliance;
import ru.job4j.game.Horde;

import java.util.Random;

public class MageHuman extends Alliance {

    public MageHuman() {
        this.setHero("Mage");
        this.setRace("Human");
        this.setDamage(4);
        this.setHealth(super.getHealth());
    }

    public void improve(Alliance hero) {
        System.out.println(getHero() + " " + getRace() + " кастует наложение улучшения на " + hero.getHero() + " " + hero.getRace());
        hero.getUpgrade();
    }

    public void attackMagic(Horde enemy) {
        System.out.println(getHero() + " " + getRace() + " наносит урон магией по " + enemy.getHero() + " "
                + enemy.getRace() + " на " + getDamage() + " HP");
        enemy.takeDamage(getDamage());
    }

    @Override
    public void ability(Horde enemy, Alliance hero) {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(2);
        if (randomNumber == 0) {
            attackMagic(enemy);
        } else {
            improve(hero);
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
    }

    @Override
    public  void getSick() {
        this.setDamage(getDamage() * 0.5);
    }

    public void getCursed() {
        this.setStatus("Normal");
        this.setDamage(getDamage() / 1.5);
    }

    @Override
    public String toString()  {
        return getHero() + " " + getRace();
    }
}
