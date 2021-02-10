package personal.ship;

public class Destroyer extends AbstractShip 
{
	Destroyer()
	{ super('D',"Destroyer",2,Orientation.EAST); }
	
	Destroyer(Orientation anOrientation)
	{ super('D',"Destroyer",2,anOrientation); }
}
