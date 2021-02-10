package personal;

/**
 * 
 *
 */

public class TestBoard 
{
	public static void main( String[] args )
	{
		Board board1 = new Board("board 1",26);
		board1.print();
		Board board2 = new Board("board 2");
		personal.ship.Destroyer navire1 = new personal.ship.Destroyer(personal.ship.Orientation.NORTH);
		personal.ship.Submarine navire2 = new personal.ship.Submarine(personal.ship.Orientation.SOUTH);
		personal.ship.BattleShip navire3 = new personal.ship.BattleShip(personal.ship.Orientation.WEST);
		personal.ship.AircraftCarrier navire4 = new personal.ship.AircraftCarrier();
		board2.putShip(navire1,0,0);
		board2.putShip(navire2,1,1);
		board2.putShip(navire3,2,2);
		board2.putShip(navire4,3,3);
		boolean x,y,z;
		x = board2.hasShip(1,2);
		y = board2.hasShip(2,2);
		z = board2.hasShip(10,2);
		board2.setHit(x,1,2);
		board2.setHit(y,2,2);
		board2.print();
		System.out.println("\nil y a-t-il un navire en B3 : " + x);
		System.out.println("il y a-t-il un navire en C3 : " + y);
		System.out.println("il y a-t-il un navire en I3 : " + z);
	}
}
