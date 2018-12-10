package Rooms;

import Game.Runner;
import Ships.Ship;

public class Firefly extends Room
{

    public Firefly(int x, int y) {
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
        System.out.println("You pass by the Docker-77, which is a shipping vessel. As the ship passes by you, it flashes its head lights as a simple hello.");
    }


}
