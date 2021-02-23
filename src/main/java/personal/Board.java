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
		int size = navires[0].length;
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
					
					if ( navires[y][x-i].getShip() == null ) 
					{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
					i ++;
				};
				if(!possible) throw new Exception("Mauvais placement du bateau");
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
					if ( navires[y][x+i].getShip() != null ) 
					{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
					i ++;
				};
				if(!possible) throw new Exception("Mauvais placement du bateau");
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
					if ( navires[y+i][x].getShip() != null ) 
					{ System.out.println("\nUn autre bateau fait obstacle\n"); possible = false; };
					i ++;
				};
				if(!possible) throw new Exception("Mauvais placement du bateau");
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
					if ( navires[y-i][x].getShip() != null ) 
					{ System.out.println("\nUn autre bateau fait obstacle\nRecommencez !\n"); possible = false; };
					i ++;
				};
				if(!possible) throw new Exception("Mauvais placement du bateau");
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
		return (navires[y][x].getShip() != null); 
	}

    /**
     * Set the state of the hit at a given position
     * @param hit true if the hit must be set to successful
     * @param x the absciss
     * @param y the ordinate
     */
	public void setHit(boolean hit, int x, int y) 
	{ if (hit) frappes[y][x]=true; }

    /**
     * Get the state of a hit at the given position
     * @param x the absciss
     * @param y the ordinate
     * @return true if the hit is successful
     */
	public boolean getHit(int x, int y) 
	{ return frappes[x][y]; }

	public Board(String aName, int aSize)
	{
		this.name = aName;
		this.navires = new ShipState[aSize][aSize];
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
				ShipState s = this.navires[j][i];
				if (s.getShip()== null) sb.append(".");
				else sb.append(s.toString());
			};
			sb.append("         ");
			sb.append(j+1);
			if (j<9) sb.append(" ");
			for (i=0;i<taille;i++)
			{
				if (this.frappes[j][i]==false) sb.append(" .");
				else sb.append(" x");
			};
			sb.append("\n");
		};
		System.out.println(sb.toString());
	}

}
