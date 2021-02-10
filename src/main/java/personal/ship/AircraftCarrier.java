package personal.ship;

public class AircraftCarrier extends AbstractShip 
{
	AircraftCarrier()
	{ super('C',"Aircraft-Carrier",5,Orientation.EAST); }
	
	AircraftCarrier(Orientation anOrientation)
	{ super('C',"Aircraft-Carrier",5,anOrientation); }
}
