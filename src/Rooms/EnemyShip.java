package Rooms;

import Game.Runner;
import Ships.Ship;

import java.util.Scanner;

public class EnemyShip extends Room
{

    public EnemyShip(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Ship x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("An enemy ship is trying to attack! Prepare for battle!");
        enemyBattle();
    }

    public void enemyBattle()
    {
        System.out.println("Type 'a' to attack, 'w' to run away, or 'n' to try to negotiate.");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase().trim();
        if (choice.equals("a"))
        {
            int random = (int)(Math.random()*3);
            if (random == 1)
            {
                System.out.println("You successfully shot their ship! Their ship exploded into smithereens.");
            }
            else
            {
                System.out.println("You missed! They instantly shot back, destroying your ship in an instant.");
                Runner.gameOff();

            }

        }
        else if (choice.equals("w"))
        {
            System.out.println("You successfully ran away!");
        }
        else if (choice.equals("n"))
        {
            System.out.println("You tried to negotiate, but they don't speak your language.");
            enemyBattle();
        }
        else
        {
            System.out.println("That isn't a valid choice.");
            enemyBattle();
        }
    }


}
