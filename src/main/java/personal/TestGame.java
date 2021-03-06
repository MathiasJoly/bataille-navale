package personal;

import java.util.ArrayList;

import personal.ship.AbstractShip;
import personal.ship.AircraftCarrier;
import personal.ship.BattleShip;
import personal.ship.Destroyer;
import personal.ship.Submarine;

public class TestGame 
{
	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main( String[] args )
	{
		Board board = new Board("AI");
		board.print();
		AbstractShip ships[] = {new Destroyer(), new Submarine(), new Submarine(), new BattleShip(), new AircraftCarrier()};
		BattleShipsAI ai = new BattleShipsAI(board,board);
		ai.putShips(ships);
		board.print();
		
		int compteur = 0;
		Hit hit = null;
		int coords[] = new int[2];
		char x ;
		int y ;
		do
		{
			try
			{ hit = ai.sendHit(coords);} 
			catch (Exception e)
			{ e.printStackTrace();}
			if (hit != null) 
			{
				x = ((char) ('0' +  coords[0] + 17));
				y = coords[1] + 1;
				System.out.println("Hit : "+x+y+" "+hit.toString());
				if (hit != Hit.MISS && hit != Hit.STIKE) compteur ++;
			};
			board.print();
			sleep(100);
		}
		while (compteur < 5);
	}
}
