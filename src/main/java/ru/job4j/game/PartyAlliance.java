package ru.job4j.game;

import ru.job4j.game.units.*;

import java.util.Random;

public class PartyAlliance {

    public static Alliance[] partyOfAlliance() {
        Alliance[] array = new Alliance[8];
        Alliance obj = null;
        int m = 0;
        int a = 0;
        int w = 0;
        Random randomizer = new Random();
        for (int i = 0; i < 8; i++) {
            int randomNumber = randomizer.nextInt(6);
            switch (randomNumber) {
                case 0:
                    if (m < 1) {
                        obj = new MageElf();
                        m++;
                        obj.setHero("Mage_" + m);
                        break;
                    }
                case 1:
                    if (a < 3) {
                        obj = new ArcherElf();
                        a++;
                        obj.setHero("Archer_" + a);
                        break;
                    }
                case 2:
                    if (w < 4) {
                        obj = new WarriorElf();
                        w++;
                        obj.setHero("Warrior_" + w);
                        break;
                    }
                case 3:
                    if (m < 1) {
                        obj = new MageHuman();
                        m++;
                        obj.setHero("Mage_" + m);
                        break;
                    }
                case 4:
                    if (a < 3) {
                        obj = new CrossbowmanHuman();
                        a++;
                        obj.setHero("Crossbowman_" + a);
                        break;
                    }
                case 5:
                    if (w < 4) {
                        obj = new WarriorHuman();
                        w++;
                        obj.setHero("Warrior_" + w);
                        break;
                    }
            }
            array[i] = obj;
        }
        return array;
    }
}
