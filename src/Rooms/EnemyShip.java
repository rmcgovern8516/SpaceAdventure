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
        int myHealth = 10;
        int enemyHealth = 3;
        System.out.println("Type 'a' to attack, 'r' to run away, or 'n' to try to negotiate.");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase().trim();
        if (choice.equals("a"))
        {
            int random = (int)(Math.random()*2);
            if (random == 0 || random == 1)
            {
                System.out.println("You successfully shot their ship! They were so scared they ran away until next time you meet them.");
            }
            else
            {
                System.out.println("You missed! They instantly shot back, destroying your ship in an instant.");
                Runner.gameOff();

            }

        }
        else if (choice.equals("r"))
        {
            System.out.println("You successfully ran away!");
        }
        else if (choice.equals("n"))
        {
            System.out.println("You tried to negotiate, but they don't speak your language.");
        }
        else
        {
            System.out.println("That isn't a valid choice.");
            enemyBattle();
        }
    }


}
