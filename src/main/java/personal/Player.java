package personal;
import java.util.List;

import personal.ship.* ;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coordinates.
     * @throws Exception
     */
    public void putShips() {
        boolean done = false;
        int i = 0;
        board.print();
        
        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getLength());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            // TODO set ship orientation
            String string_o = res.orientation;
            switch(string_o)
            {
            case "n":
            	s.setOrientation(Orientation.NORTH);
            	break;
            case "s":
            	s.setOrientation(Orientation.SOUTH);
            	break;
            case "e":
            	s.setOrientation(Orientation.EAST);
            	break;
            case "w":
            	s.setOrientation(Orientation.WEST);
            	break;
            }
            // TODO put ship at given position
            try 
            { board.putShip(s, res.x, res.y); } 
            catch (Exception e) 
            { System.out.println("Réessayez avec des valeurs correctes !"); }

            // TODO when ship placement successful
            boolean success = false;
            success = board.hasShip(res.x, res.y);
            if (success) board.print();
            else i--;
            
            ++i;
            done = i == 5;

        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard
            
            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
