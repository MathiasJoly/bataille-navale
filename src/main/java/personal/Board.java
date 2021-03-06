package personal;
import personal.ship.*;


public class Board implements personal.IBoard
{
	private String name;
	private ShipState[][] navires;
	private Boolean[][] frappes;
	
	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		this.name = aName;
	}

	public ShipState[][] getNavires()
	{
		return navires;
	}
	
    /**
     * Creates the navires board/matrix
     * @param aSize must be inferior or equal to 26
     */
	public void setNavires(int aSize)
	{
		this.navires = new ShipState[aSize][aSize];
	}

	public Boolean[][] getFrappes()
	{
		return frappes;
	}
	
    /**
     * Creates the frappes board/matrix
     * @param aSize must be inferior or equal to 26
     */
	public void setFrappes(int aSize)
	{
		this.frappes = new Boolean[aSize][aSize];
	}

    /**
     * Get the size of the grids contained in the Board
     * @return the size of the grids contained in the Board
     */
	public int getSize()
	{
		return navires.length;
	}

    /**
     * Put the given ship at the given position
     * @param aShip The ship to place on the board (name, label, length, orientation)
     * @param x the absciss
     * @param y the ordinate
     * @throws Exception if x and y are not correct coordinates
     */
	public void putShip(AbstractShip aShip, int x, int y) throws Exception
	{
		int size = getSize();
		int ship_size = aShip.getLength();
		int i=0;
		boolean possible = true;
		Orientation anOrientation = aShip.getOrientation() ;
		switch(anOrientation)
		{
			case WEST:
				if (x - ship_size + 1 < 0) 
				{ System.out.println("\nLe bateau sort de la grille\n"); possible = false; }
				while(possible && i<ship_size) 
				{
					if (navires[y][x-i] != null)
					{
						if ( navires[y][x-i].getShip() != null ) 
						{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
						i ++;
					}
					else
					{
						possible = false;
						System.out.println("\nErreur pointeur nul\n");
					};
				};
				if(!possible) throw new Exception();
				else 
				{
						i = 0;
						while(possible && i<ship_size)
						{ 
							navires[y][x-i] = new ShipState(aShip); 
							i++; 
						};
				};
				break;
			case EAST:
				if (x + ship_size - 1 >= size) 
				{ System.out.println("\nLe bateau sort de la grille\n"); possible = false; }
				while(possible && i<ship_size) 
				{
					if ( navires[y][x+i] != null )
					{
						if ( navires[y][x+i].getShip() != null ) 
						{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
						i ++;
					}
					else
					{
						possible = false;
						System.out.println("\nErreur pointeur nul\n");
					};
				};
				if(!possible) throw new Exception();
				else
				{
					i = 0;
					while(possible && i<ship_size)
					{ navires[y][x+i] = new ShipState(aShip); i++; };
				};
				break;
			case SOUTH:
				if (y + ship_size - 1 >= size) 
				{ System.out.println("\nLe bateau sort de la grille\n"); possible = false; }
				while(possible && i<ship_size) 
				{
					if ( navires[y+i][x] != null )
					{
						if ( navires[y+i][x].getShip() != null ) 
						{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
						i ++;
					}
					else
					{
						possible = false;
						System.out.println("\nErreur pointeur nul\n");
					};
				};
				if(!possible) throw new Exception();
				else
				{
					i = 0;
					while(possible && i<ship_size)
					{ navires[y+i][x] = new ShipState(aShip); i++; };
				};
				break;
			case NORTH:
				if (y - ship_size + 1 < 0) 
				{ System.out.println("\nLe bateau sort de la grille\nRecommencez !\n"); possible = false; }
				while(possible && i<ship_size) 
				{
					if ( navires[y-i][x] != null ) 
					{
						if ( navires[y-i][x].getShip() != null ) 
						{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
						i ++;
					}
					else
					{
						possible = false;
						System.out.println("\nErreur pointeur nul\n");
					};
				};
				if(!possible) throw new Exception();
				else
				{
					i = 0;
					while(possible && i<ship_size)
					{ navires[y-i][x] = new ShipState(aShip); i++; };
				};
				break;
		}
	}

    /**
     * Get if a ship is placed at the given position
     * @param x the absciss
     * @param y the ordinate
     * @return true if a ship is located at the given position
     */
	public boolean hasShip(int x, int y) 
	{ 
		if (navires[y][x].getShip() == null) return false;
		else return !navires[y][x].getShip().isSunk();
	}

    /**
     * Set the state of the hit at a given position
     * @param hit true if the hit must be set to successful
     * @param x the absciss
     * @param y the ordinate
     */
	public void setHit(boolean hit, int x, int y) 
	{ 
		if (hit) frappes[y][x]= true;
		else frappes[y][x] = false;
	}

    /**
     * Get the state of a hit at the given position
     * @param x the absciss
     * @param y the ordinate
     * @return true if the hit is successful
     */
	public Boolean getHit(int x, int y) 
	{ 
		return frappes[y][x]; 
	}

	/**
	 * Sends a hit at the given position
	 * @param x
	 * @param y
	 * @return status for the hit (eg : strike or miss)
	 */
	public Hit sendHit(int x, int y)
	{
		Hit res = null;
		if (this.navires[y][x] != null)
		{
			this.navires[y][x].addStrike();
			if (this.navires[y][x].isStruck()) 
			{
				res = Hit.MISS;
				if (this.navires[y][x].getShip() != null)
				{
					res = Hit.STIKE;
					if (this.navires[y][x].getShip().isSunk())
					{
						int length = this.navires[y][x].getShip().getLength();
						res = Hit.fromInt(length);		
					}
				}
			}
		}
		return res;
	}

	public Board(String aName, int aSize)
	{
		this.name = aName;
		this.navires = new ShipState[aSize][aSize];
		for( int i = 0 ; i < aSize ; i++)
		{
			for ( int j = 0 ; j < aSize ; j++)
			{
				this.navires[j][i] = new ShipState();
			}
		}
		this.frappes = new Boolean[aSize][aSize];
	};

	public Board(String aName)
	{
		this(aName,10);
	};

	public void print()
	{
		String letters = "   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		String titles =  "                                                      ";
		int i,j;
		int taille = navires[0].length;
		StringBuilder sb = new StringBuilder();
		sb.append("\nNavires :");
		sb.append(titles.substring(0,2+2*taille));
		sb.append("Frappes :\n");
		sb.append(letters.substring(0,2+2*taille));
		sb.append("         ");
		sb.append(letters.substring(0,2+2*taille));
		sb.append("\n");;
		for (j = 0; j<taille; j++)
		{
			sb.append(j+1);
			if (j<9) sb.append(" ");
			for (i=0;i<taille;i++)
			{
				sb.append(" ");
				ShipState ship = this.navires[j][i];
				if (ship == null) sb.append(".");
				else sb.append(ship.toString());
			};
			sb.append("         ");
			sb.append(j+1);
			if (j<9) sb.append(" ");
			for (i=0;i<taille;i++)
			{
				Boolean bool = this.frappes[j][i];
				if (bool == null) sb.append(" .");
				else if (bool == false) sb.append(" X");
				else if (bool == true) sb.append("\u001b[1;31m X\u001b[0m");
			};
			sb.append("\n");
		};
		System.out.println(sb.toString());
	}

}
