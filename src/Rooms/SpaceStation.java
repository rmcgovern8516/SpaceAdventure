package Rooms;

import Game.Runner;
import Ships.Ship;

public class SpaceStation extends Room
{

    public SpaceStation(int x, int y) {
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
        System.out.println("You've hyper-warped next to a space station! It is an astounding sight to see hundreds of spacecraft coming and going into the enormous station.");
    }


}
