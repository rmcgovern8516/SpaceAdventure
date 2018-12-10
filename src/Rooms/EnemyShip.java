package Rooms;

import Game.Runner;
import Ships.Ship;

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
    }


}
