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
			if(this.ship != null) this.ship.addStrikeCount();
		};
	}
	
	public boolean isStruck()
	{
		return struck;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (struck) sb.append("\u001b[1;31m");
		else sb.append("\u001b[0m");
		if(this.ship != null)
		{
			sb.append(this.ship.getLabel());
		}
		else 
		{
			sb.append('.');
		}
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
