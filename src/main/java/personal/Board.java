package personal;
import personal.ship.*;

/**
 * @param taille doit être inférieur ou égal à 26 
 *
 */

public class Board implements personal.IBoard
{
	private String name;
	private char[][] navires;
	private boolean[][] frappes;
	
	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		this.name = aName;
	}

	public char[][] getNavires()
	{
		return navires;
	}
	public void setNavires(int aSize)
	{
		this.navires = new char[aSize][aSize];
	}

	public boolean[][] getFrappes()
	{
		return frappes;
	}
	public void setFrappes(int aSize)
	{
		this.frappes = new boolean[aSize][aSize];
	}

	public int getSize()
	{
		return navires.length;
	}

	public void putShip(AbstractShip aShip, int x, int y)
	{
		int size = navires[0].length;
		int ship_size = aShip.getTaille();
		int i=0;
		boolean possible;
		Orientation anOrientation = aShip.getOrientation() ;
		switch(anOrientation)
		{
			case NORTH:
				possible = x >= 0 && x < size && y - ship_size + 1 >= 0 && y < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[x][y-i] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[x][y-i] = aShip.getLabel(); i++; };
				break;
			case SOUTH:
				possible = x >= 0 && x < size && y >= 0 && y + ship_size - 1 < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[x][y+i] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[x][y+i] = aShip.getLabel(); i++; };
				break;
			case EAST:
				possible = x >= 0 && x + ship_size - 1 < size && y >= 0 && y < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[x+i][y] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[x+i][y] = aShip.getLabel(); i++; };
				break;
			case WEST:
				possible = x - ship_size + 1 >= 0 && x < size && y >= 0 && y < size ;
				while(possible && i<ship_size)
				{ possible = possible && ( navires[x-i][y] == 0 ); i++; };
				i = 0;
				while(possible && i<ship_size)
				{ navires[x-i][y] = aShip.getLabel(); i++; };
				break;
		}
	}

	public boolean hasShip(int x, int y) 
	{
		int size = navires[0].length;
		return (x >= 0 && x < size && y >= 0 && y < size && navires[x][y] != 0);
	}

	public void setHit(boolean hit, int x, int y) 
	{
		int size = frappes[0].length;
		if (hit) frappes[x][y]=true;
	}

	public boolean getHit(int x, int y) 
	{
		int size = navires[0].length;
		return (x >= 0 && x < size && y >= 0 && y < size && navires[x][y] != 0);
	}

	public Board(String aName, int aSize)
	{
		this.name = aName;
		this.navires = new char[aSize][aSize];
		this.frappes = new boolean[aSize][aSize];
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
		for (i = 0; i<taille; i++)
		{
			sb.append(i+1);
			if (i<9) sb.append(" ");
			for (j=0;j<taille;j++)
			{
				sb.append(" ");
				if (this.navires[i][j]==0) sb.append(".");
				else sb.append(this.navires[i][j]);
			};
			sb.append("         ");
			sb.append(i+1);
			if (i<9) sb.append(" ");
			for (j=0;j<taille;j++)
			{
				if (this.frappes[i][j]==false) sb.append(" .");
				else sb.append(" x");
			};
			sb.append("\n");
		};
		System.out.println(sb.toString());
	}

}
