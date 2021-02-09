package ensta;

/**
 * 
 *
 */

public class TestBoard 
{
	public static void main( String[] args )
	{
		Board board1 = new Board("board 1");
		board1.print();
		Board board2 = new Board("board 2",26);
		board2.print();
	}
}
