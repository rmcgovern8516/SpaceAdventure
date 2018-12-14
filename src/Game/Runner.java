package Game;

import Rooms.*;
import Game.Board;
import Ships.Ship;

import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        System.out.println("Welcome, captain. You can fly your ship around to the various events on the map. Any place with a '.' is a place you've already visited.");
        Room[][] building = new Room[5][5];
        String[][] face = new String[5][5];
        Game.Board face1 = new Board(face);

        face1.fill("X");

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
        face1.edit("S",x,y);

        //Create a random location for the gaseous planet.
        int x2 = (int)(Math.random()*building.length);
        int y2 = (int)(Math.random()*building.length);
        building[x2][y2] = new GaseousPlanet(x2, y2);
        face1.edit("G",x2,y2);

        //Create a random location for the star.
        int x3 = (int)(Math.random()*building.length);
        int y3 = (int)(Math.random()*building.length);
        building[x3][y3] = new Star(x3, y3);
        face1.edit("*",x3,y3);

        //Create a random location for the firefly.
        int x4 = (int)(Math.random()*building.length);
        int y4 = (int)(Math.random()*building.length);
        building[x4][y4] = new Firefly(x4, y4);
        face1.edit("F",x4,y4);

        //Create a random location for the enemy ship.
        int x5 = (int)(Math.random()*building.length);
        int y5 = (int)(Math.random()*building.length);
        building[x5][y5] = new EnemyShip(x5, y5);
        face1.edit("E",x5,y5);



        //Setup player 1 and the input scanner
        Ship myShip = new Ship("FirstName", "FamilyName", 0,-1);
        building[0][0].enterRoom(myShip);
        face1.edit(".",myShip.getyLoc(),myShip.getxLoc());
        System.out.println(face1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose U, D, R, L)");
            String move = in.nextLine();
            if(validMove(move, myShip, building))
            {
                face1.edit(".",myShip.getxLoc(),myShip.getyLoc());
                System.out.println(face1);


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
    public static boolean validMove(String move, Ships.Ship p, Room[][] map)
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
