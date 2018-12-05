package Rooms;

import Game.Runner;
import Ships.Ship;

public class GaseousPlanet extends Room
{

    public GaseousPlanet(int x, int y) {
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
        System.out.println("This is the one gaseous planet in this solar system. You can't land on it unfortunately.");
    }


}
