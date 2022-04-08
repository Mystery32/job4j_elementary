package ru.job4j.game;

import ru.job4j.game.units.*;

import java.util.Random;

public class PartyHorde {

    public static Horde[] partyOfHorde() {
        Horde[] array = new Horde[8];
        Horde obj = null;
        int m = 0;
        int a = 0;
        int w = 0;
        Random randomizer = new Random();
        for (int i = 0; i < 8; i++) {
            int randomNumber = randomizer.nextInt(6);
            switch (randomNumber) {
                case 0:
                    if (m < 1) {
                        obj = new ShamanOrc();
                        m++;
                        obj.setHero("Shaman_" + m);
                        break;
                    }
                case 1:
                    if (a < 3) {
                        obj = new ArcherOrc();
                        a++;
                        obj.setHero("Archer_" + a);
                        break;
                    }
                case 2:
                    if (w < 4) {
                        obj = new GoblinOrc();
                        w++;
                        obj.setHero("Goblin_" + w);
                        break;
                    }
                case 3:
                    if (m < 1) {
                        obj = new NecromancerUndead();
                        m++;
                        obj.setHero("Necromancer_" + m);
                        break;
                    }
                case 4:
                    if (a < 3) {
                        obj = new HunterUndead();
                        a++;
                        obj.setHero("Hunter_" + a);
                        break;
                    }
                case 5:
                    if (w < 4) {
                        obj = new ZombieUndead();
                        w++;
                        obj.setHero("Zombie_" + w);
                        break;
                    }
            }
            array[i] = obj;
        }
        return array;
    }
}
