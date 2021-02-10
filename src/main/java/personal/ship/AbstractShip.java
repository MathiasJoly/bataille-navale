package personal.ship;

public abstract class AbstractShip
{
	// Les attributs :
	protected char label;
	protected String nom;
	protected int taille;
	protected Orientation orientation;
	
	// Les accesseurs :
	public char getLabel()
	{
		return label;
	}
	public String getNom()
	{
		return nom;
	}
	public int getTaille()
	{
		return taille;
	}
	public Orientation getOrientation()
	{
		return orientation;
	}

	// Le mutateur d'orientation
	public void setOrientation(Orientation anOrientation)
	{
		this.orientation = anOrientation;
	}

	// Le constructeur valué
	public AbstractShip (char aLabel, String aName, int aSize, Orientation anOrientation)
	{
		this.label = aLabel ;
		this.nom = aName ;
		this.taille = aSize ;
		this.orientation = anOrientation ;
	}

}
