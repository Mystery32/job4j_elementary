package ru.job4j.game.units;

import ru.job4j.game.Alliance;
import ru.job4j.game.Horde;

public class WarriorHuman extends Alliance {

    public WarriorHuman() {
        this.setHero("Warrior");
        this.setRace("Human");
        this.setWeaponDamage(18);
        this.setHealth(super.getHealth());
    }

    @Override
    public void ability(Horde enemy, Alliance hero) {
        System.out.println(getHero() + " " + getRace() + " атакует мечом по " + enemy.getHero() + " "
                + enemy.getRace() + " на " + getWeaponDamage() + " HP");
        enemy.takeDamage(getWeaponDamage());
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
        this.setWeaponDamage(getWeaponDamage() * 1.5);
    }

    @Override
    public  void getSick() {
        this.setWeaponDamage(getWeaponDamage() * 0.5);
    }

    public void getCursed() {
        this.setStatus("Normal");
        this.setWeaponDamage(getWeaponDamage() / 1.5);
    }

    @Override
    public String toString() {
        return getHero() + " " + getRace();
    }
}
