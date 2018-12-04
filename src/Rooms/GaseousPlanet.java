package Rooms;

import Game.Runner;
import People.Person;

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
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("This is the one gaseous planet in this solar system. You can't land on it unfortunately.");
    }


}
