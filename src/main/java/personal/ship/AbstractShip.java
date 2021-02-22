package personal.ship;

public abstract class AbstractShip
{
	protected char label;
	protected String nom;
	protected int taille;
	protected Orientation orientation;
	
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

	public AbstractShip (char aLabel, String aName, int aSize, Orientation anOrientation)
	{
		this.label = aLabel ;
		this.nom = aName ;
		this.taille = aSize ;
		this.orientation = anOrientation ;
	}

}
