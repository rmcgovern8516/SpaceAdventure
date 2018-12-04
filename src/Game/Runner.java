package Game;

import People.Person;
import Rooms.Room;
import Rooms.SpaceStation;
import Rooms.GaseousPlanet;
import Rooms.Star;

import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Room[][] building = new Room[5][5];

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }


        //Create a random location for the space station.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new SpaceStation(x, y);

        //Create a random location for the gaseous planet.
        int x2 = (int)(Math.random()*building.length);
        int y2 = (int)(Math.random()*building.length);
        building[x2][y2] = new GaseousPlanet(x2, y2);

        //Create a random location for the star.
        int x3 = (int)(Math.random()*building.length);
        int y3 = (int)(Math.random()*building.length);
        building[x3][y3] = new Star(x3, y3);


        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose U, D, R, L)");
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

            }
            else {
                System.out.println("You're on the edge of the solar system. Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "u":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "r":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "d":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "l":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}
