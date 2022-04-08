package ru.job4j.game;

public abstract class Horde {
    private String hero;
    private String race;
    private double health = 100;
    private double damage;
    private double weaponDamage;
    private String status;

    public abstract void ability(Alliance enemy, Horde hero);

    public abstract void takeDamage(double damage);

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public abstract void getUpgrade();

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
