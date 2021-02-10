package personal.ship;

public class BattleShip extends AbstractShip 
{
	BattleShip()
	{ super('B',"BattleShip",4,Orientation.EAST); }
	
	BattleShip(Orientation anOrientation)
	{ super('B',"BattleShip",4,anOrientation); }
}
