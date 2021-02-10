package personal;

/**
 * @param taille doit être inférieur ou égal à 26 
 *
 */

public class Board implements personal.IBoard
{
	private String name;
	private char[] navires;
	private boolean[] frappes;
	private int size;
	
	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		this.name = aName;
	}

	public char[] getNavires()
	{
		return navires;
	}
	public void setNavires(int aSize)
	{
		this.navires = new char[aSize*aSize];
	}

	public boolean[] getFrappes()
	{
		return frappes;
	}
	public void setFrappes(int aSize)
	{
		this.frappes = new boolean[aSize*aSize];
	}

	public int getSize()
	{
		return size;
	}
	public void setSize(int aSize)
	{
		this.size = aSize;
	}

	public void putShip(personal.ship.AbstractShip aShip, int x, int y)
	{
		int ship_size = aShip.getTaille();
		int i=0;
		boolean possible;
		personal.ship.Orientation anOrientation = aShip.getOrientation() ;
		switch(anOrientation)
		{
			case NORTH:
				possible = x >= 0 && x < size && y - ship_size + 1 >= 0 && y < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[x + (y-i)*size] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[x + (y-i)*size] = aShip.getLabel(); i++; };
				break;
			case SOUTH:
				possible = x >= 0 && x < size && y >= 0 && y + ship_size - 1 < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[x + (y+i)*size] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[x + (y+i)*size] = aShip.getLabel(); i++; };
				break;
			case EAST:
				possible = x >= 0 && x + ship_size - 1 < size && y >= 0 && y < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[(x+i) + y*size] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[(x+i) + y*size] = aShip.getLabel(); i++; };
				break;
			case WEST:
				possible = x - ship_size + 1 >= 0 && x < size && y >= 0 && y < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[(x-i) + y*size] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[(x-i) + y*size] = aShip.getLabel(); i++; };
				break;
		}
	}

	public boolean hasShip(int x, int y) 
	{
		return (x >= 0 && x < size && y >= 0 && y < size && navires[x + size*y] != 0);
	}

	public void setHit(boolean hit, int x, int y) 
	{
		if (hit) frappes[x+y*size]=true;
	}

	public boolean getHit(int x, int y) 
	{
		return (x >= 0 && x < size && y >= 0 && y < size && navires[x + size*y] != 0);
	}

	public Board(String aName, int aSize)
	{
		this.name = aName;
		this.navires = new char[aSize*aSize];
		this.frappes = new boolean[aSize*aSize];
		this.size = aSize;
	};

	public Board(String aName)
	{
		this(aName,10);
	};

	public void print()
	{
		String letters = "   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		int i,j;
		int taille = this.size;
		System.out.println("\nNavires :");
		System.out.println(letters.substring(0,2+2*taille));
		for (i = 0; i<taille; i++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(i+1);
			if (i<9) sb.append(" ");
			for (j=0;j<taille;j++)
			{
				sb.append(" ");
				if (this.navires[i*taille+j]==0) sb.append(".");
				else sb.append(this.navires[i*taille+j]);
			};
			System.out.println(sb.toString());
		};
		System.out.println("\nFrappes :");
		System.out.println(letters.substring(0,2+2*taille));
		for (i = 0; i<taille; i++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(i+1);
			if (i<9) sb.append(" ");
			for (j=0;j<taille;j++)
			{
				if (this.frappes[i*taille+j]==false) sb.append(" .");
				else sb.append(" x");
			};
			System.out.println(sb.toString());
		};
	}

}
