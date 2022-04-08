package ru.job4j.game.units;

import ru.job4j.game.Alliance;
import ru.job4j.game.Horde;

import java.util.Random;

public class ShamanOrc extends Horde {

    public ShamanOrc() {
        this.setHero("Shaman");
        this.setRace("Orc");
        this.setHealth(super.getHealth());
    }

    public void improve(Horde hero) {
        System.out.println(getHero() + " " + getRace() + " кастует наложение улучшения на " + hero.getHero() + " " + hero.getRace());
        hero.getUpgrade();
    }

    public void curse(Alliance enemy) {
        System.out.println(getHero() + " " + getRace() + " кастует наложение проклятия (снятие улучшения с " + enemy.getHero()
                + " " + enemy.getRace() + " для следующего хода)");
        enemy.getCursed();
    }

    @Override
    public void ability(Alliance enemy, Horde hero) {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(2);
        if (randomNumber == 0) {
            curse(enemy);
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
        this.setWeaponDamage(getWeaponDamage() * 1.5);
    }

    @Override
    public String toString() {
        return getHero() + " " + getRace();
    }
}
