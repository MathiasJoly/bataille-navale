package personal;

import personal.ship.AbstractShip;
import personal.ship.AircraftCarrier;
import personal.ship.BattleShip;
import personal.ship.Destroyer;
import personal.ship.Orientation;
import personal.ship.Submarine;

import java.util.ArrayList;
import java.util.List;

import personal.Player;

/**
 * 
 *
 */

public class TestBoard 
{
	public static void main( String[] args )
	{
		/*
		Board board1 = new Board("board 1",26);
		board1.print();
		*/
		
		Board board2 = new Board("board 2");
		Destroyer navire1 = new Destroyer(Orientation.NORTH);
		BattleShip navire2 = new BattleShip(Orientation.SOUTH);
		Submarine navire3 = new Submarine(Orientation.WEST);
		AircraftCarrier navire4 = new AircraftCarrier();


		try 
		{ board2.putShip(navire1,0,0); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		try 
		{ board2.putShip(navire2,1,1); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		try 
		{ board2.putShip(navire3,2,2); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		try 
		{ board2.putShip(navire4,3,3); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		boolean x,y;
		x = board2.hasShip(1,2);
		y = board2.hasShip(2,2);

		board2.setHit(x,1,2);
		board2.setHit(y,2,2);
		board2.print();

		/*
		System.out.println("\nil y a-t-il un navire en B3 : " + x);
		System.out.println("il y a-t-il un navire en C3 : " + y);
		*/
		
		Board board_player = new Board("player",10);
		ArrayList<AbstractShip> ships = new ArrayList();
		ships.add(new Destroyer());
		ships.add(new Submarine());
		ships.add(new Submarine());
		ships.add(new BattleShip());
		ships.add(new AircraftCarrier());
		Board board_opponent = new Board("opponent",10);
		Player p1 = new Player(board_player,board_opponent,ships);
		if (p1 != null)
		{
			try 
			{ p1.putShips(); }
			catch (Exception e) 
			{ e.printStackTrace(); };
		};
	}
}
