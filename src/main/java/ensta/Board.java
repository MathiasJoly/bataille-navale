package ensta;
import java.util.Arrays;

/**
 * @param taille doit être inférieur ou égal à 26 
 *
 */

public class Board
{
	public String name;
	public char[] navires;
	public boolean[] frappes;
	public int size;
	
	public Board(String nom, int taille)
	{
		this.name = nom;
		this.navires = new char[taille*taille];
		this.frappes = new boolean[taille*taille];
		this.size = taille;
	};

	public Board(String nom)
	{
		this(nom,10);
	};

	public void print()
	{
		String letters = "   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		int i,j;
		int taille =this.size;
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
