package personal.ship;

public abstract class AbstractShip
{
	protected char label;
	protected String nom;
	protected int taille;
	protected Orientation orientation;
	protected int strikeCount;
	
	public char getLabel()
	{
		return label;
	}
	public String getName()
	{
		return nom;
	}
	public int getLength()
	{
		return taille;
	}
	public Orientation getOrientation()
	{
		return orientation;
	}

	public void setOrientation(Orientation anOrientation)
	{
		this.orientation = anOrientation;
	}
	
	public int getStrikeCount()
	{
		return strikeCount;
	}
	
	public void setStrikeCount(int aStrikeCount)
	{
		this.strikeCount = aStrikeCount;
	}
	
	public void addStrike()
	{
		this.strikeCount += 1;
	}
	
	public boolean isSunk()
	{
		return strikeCount == taille;
	}
	
	public AbstractShip ()
	{
		this.label = '.';
		this.nom = "";
		this.taille = 0;
		this.orientation = Orientation.EAST;
	}
	
	public AbstractShip (char aLabel, String aName, int aSize, Orientation anOrientation)
	{
		this.label = aLabel ;
		this.nom = aName ;
		this.taille = aSize ;
		this.orientation = anOrientation ;
	}

}
