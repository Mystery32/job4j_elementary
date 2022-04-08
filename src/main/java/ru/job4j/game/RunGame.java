package ru.job4j.game;

import java.util.Random;

import static ru.job4j.game.PartyAlliance.partyOfAlliance;
import static ru.job4j.game.PartyHorde.partyOfHorde;

public class RunGame {
    public static void main(String[] args) {

        runBattle(partyOfAlliance(), partyOfHorde());
    }

    public static void runBattle(Alliance[] alliances, Horde[] hordes) {
        Random randomizer = new Random();
        for (Alliance a : alliances) {
            for (Horde h : hordes) {
                while (a.isAlive() && h.isAlive()) {
                    int randomNumber = randomizer.nextInt(2);
                    if (randomNumber == 0) {
                        a.ability(h, a);
                        if (h.isAlive()) {
                            h.ability(a, h);
                        }
                    }
                    if (randomNumber == 1) {
                        h.ability(a, h);
                        if (a.isAlive()) {
                            a.ability(h, a);
                        }
                    }
                }
            }
        }
        if (!hordes[hordes.length - 1].isAlive()) {
            System.out.println("Alliance WIN!!!");
        }
        if (!alliances[alliances.length - 1].isAlive()) {
            System.out.println("Horde WIN!!!");
        }
    }
}
