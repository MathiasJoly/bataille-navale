package personal.ship;

public class Submarine extends AbstractShip 
{
	Submarine()
	{ super('S',"Submarine",3,Orientation.EAST); }
	
	Submarine(Orientation anOrientation)
	{ super('S',"Submarine",3,anOrientation); }
}
