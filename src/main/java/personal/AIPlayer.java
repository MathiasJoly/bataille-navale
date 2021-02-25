package personal;
import java.util.List;

import personal.ship.AbstractShip;

public class AIPlayer extends Player {
    /* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    // TODO AIPlayer must not inherit "keyboard behavior" from player. Call ai instead.
    public void putShips() 
    {
    	ai.putShips(ships);
    };
    
    public Hit sendHit(int[] coords) 
    {
    	return ai.sendHit(coords);
    };
}
