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
		//Test grille de taille maximale
		Board board1 = new Board("board 1",26);
		board1.print();
		*/
		
		//Test grille par défaut
		Board board2 = new Board("board 2");
		
		//Test placement des navires
		Destroyer navire1 = new Destroyer(Orientation.EAST);
		Submarine navire2 = new Submarine(Orientation.NORTH);
		Submarine navire3 = new Submarine(Orientation.SOUTH);
		BattleShip navire4 = new BattleShip(Orientation.WEST);
		AircraftCarrier navire5= new AircraftCarrier();

		//Tests putShip
		//Erreur : coordonnées hors grille
		try 
		{ board2.putShip(navire1,10,10); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		//Erreur : bateau hors grille
		try 
		{ board2.putShip(navire2,1,1); } 
		catch (Exception e) 
		{ e.printStackTrace(); };
		//Réussi
		try 
		{ board2.putShip(navire3,2,2); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		//Erreur : superposition de bateaux
		try 
		{ board2.putShip(navire4,3,3); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		//Réussi
		try 
		{ board2.putShip(navire5,4,4); }
		catch (Exception e) 
		{ e.printStackTrace(); };
		board2.print();
		
		//Tests hasShip
		boolean x,y;
		x = board2.hasShip(1,1);
		assert(x == false);
		y = board2.hasShip(2,2);
		assert(y == true);
		
		//Tests setHit
		board2.setHit(true,9,0);
		board2.setHit(false,0,9);
		board2.print();
		
		//Tests Player
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
			//Test putShip
			try 
			{ p1.putShips(); }
			catch (Exception e1) 
			{ e1.printStackTrace(); };
			
			Hit hit = null;
			int coords[] = new int[2];
			
			//Tests sendHit
			try
			{ hit = p1.sendHit(coords);} //C3 : touché
			catch (Exception e2)
			{ e2.printStackTrace();}
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			hit = null;
			try
			{ hit = p1.sendHit(coords);} //C2 : raté
			catch (Exception e2)
			{ e2.printStackTrace();}
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			hit = null;
			try
			{ hit = p1.sendHit(coords);} //C4 : touché
			catch (Exception e2)
			{ e2.printStackTrace();}
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			hit = null;
			try
			{ hit = p1.sendHit(coords);} //C5 : sous-marin coulé
			catch (Exception e3)
			{ e3.printStackTrace();}
			
			//Test isSunk
			assert(p1.opponentBoard.getNavires()[9][9].getShip().isSunk() == true);
			
			//Test hasShip sur un navire coulé
			assert(p1.opponentBoard.hasShip(9, 9) == false);
			
			System.out.println("\nPlayer :\n");
			p1.board.print();
			System.out.println("\nOpponent :\n");
			p1.opponentBoard.print();
			
			
		};
	}
}
