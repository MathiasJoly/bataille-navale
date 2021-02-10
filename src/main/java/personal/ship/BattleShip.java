package personal.ship;

public class BattleShip extends AbstractShip 
{
	public BattleShip()
	{ super('B',"BattleShip",4,Orientation.EAST); }
	
	public BattleShip(Orientation anOrientation)
	{ super('B',"BattleShip",4,anOrientation); }
}
