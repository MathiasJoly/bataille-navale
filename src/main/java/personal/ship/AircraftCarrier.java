package personal.ship;

public class AircraftCarrier extends AbstractShip 
{
	public AircraftCarrier()
	{ super('C',"Aircraft-Carrier",5,Orientation.EAST); }
	
	public AircraftCarrier(Orientation anOrientation)
	{ super('C',"Aircraft-Carrier",5,anOrientation); }
}
