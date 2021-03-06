package Rooms;

import Game.Runner;
import Ships.Ship;

public class Star extends Room
{

    public Star(int x, int y) {
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
        System.out.println("You've hyper-warped into a star! You feel the heat rise 100 degrees a second, but you instantly warp out due to your amazing reflexes.");

    }


}
