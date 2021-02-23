package personal.ship;

public class ShipState 
{
	private AbstractShip ship;
	private boolean struck;
	
	public AbstractShip getShip() 
	{
		return this.ship;
	}
	
	public void setShip(AbstractShip aShip)
	{
		this.ship = aShip;
	}
	
	public void addStrike()
	{
		if (!struck)
		{
			this.struck = true;
			this.ship.addStrikeCount();
		};
	}
	
	public boolean isStruck()
	{
		return struck;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (struck) sb.append("\33[m");
		else sb.append("\30[m");
		sb.append(this.ship.getLabel());
		return sb.toString();
	}
	
	public ShipState()
	{}
	
	public ShipState(AbstractShip aShip)
	{
		this.ship = aShip;
		this.struck = false;
	}
}
