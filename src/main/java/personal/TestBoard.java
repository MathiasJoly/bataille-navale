package personal;

import personal.ship.AbstractShip;
import personal.ship.AircraftCarrier;
import personal.ship.BattleShip;
import personal.ship.Destroyer;
import personal.ship.Orientation;
import personal.ship.Submarine;

import java.util.ArrayList;

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
		Submarine navire2 = new Submarine(Orientation.NORTH);
		Submarine navire3 = new Submarine(Orientation.SOUTH);
		BattleShip navire4 = new BattleShip(Orientation.WEST);
		AircraftCarrier navire5= new AircraftCarrier();

		try 
		{ board2.putShip(navire1,9,9); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		/*
		try 
		{ board2.putShip(navire2,1,1); } // lance une erreur
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		try 
		{ board2.putShip(navire3,2,2); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		try 
		{ board2.putShip(navire4,3,3); } // lance une erreur
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		try 
		{ board2.putShip(navire5,4,4); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		
		boolean x,y;
		x = board2.hasShip(1,2);
		y = board2.hasShip(2,2);
		
		board2.setHit(true,9,0);
		board2.setHit(false,0,9);
		board2.print();

		System.out.println("\nil y a-t-il un navire en B3 : " + x);
		System.out.println("il y a-t-il un navire en C3 : " + y);
		*/
		
		Board board3 = new Board("player",10);
		ArrayList<AbstractShip> ships = new ArrayList();
		ships.add(new Destroyer());
		ships.add(new Submarine());
		ships.add(new Submarine());
		ships.add(new BattleShip());
		ships.add(new AircraftCarrier());
		Player p1 = new Player(board3,board2,ships);
		if (p1 != null)
		{
			/*
			try 
			{ p1.putShips(); }
			catch (Exception e1) 
			{ e1.printStackTrace(); };
			*/
			
			Hit hit = null;
			int coords[] = {-1,-1};
			
			try
			{ hit = p1.sendHit(coords);} //J9
			catch (Exception e2)
			{ e2.printStackTrace();}
			
			boolean success = false;
			if (hit != null) success = hit != Hit.MISS;
			p1.board.setHit(success,coords[0],coords[1]);
			
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			
			hit = null;
			try
			{ hit = p1.sendHit(coords);} //J8
			catch (Exception e2)
			{ e2.printStackTrace();}
			
			success = false;
			if (hit != null) success = hit != Hit.MISS;
			p1.board.setHit(success,coords[0],coords[1]);
			
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			
			hit = null;
			try
			{ hit = p1.sendHit(coords);} //I9
			catch (Exception e2)
			{ e2.printStackTrace();}
			
			success = false;
			if (hit != null) success = hit != Hit.MISS;
			p1.board.setHit(success,coords[0],coords[1]);
			
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			
			hit = null;
			try
			{ hit = p1.sendHit(coords);} //J10
			catch (Exception e3)
			{ e3.printStackTrace();}
			
			success = false;
			if (hit != null) success = hit != Hit.MISS;
			p1.board.setHit(success,coords[0],coords[1]);
			
			assert(p1.opponentBoard.getNavires()[9][9].getShip().isSunk() == true);
			assert(p1.opponentBoard.hasShip(9, 9) == false);
			
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			
			
		};
	}
}
