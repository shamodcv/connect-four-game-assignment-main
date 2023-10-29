package lk.ijse.dep.service.imple;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.Piece;
import lk.ijse.dep.service.Player;

import java.util.Random;

public class AiPlayer extends Player {
    public AiPlayer(Board newBoard) {
        this.board=newBoard;
    }
    public void movePiece(int col){
        Random rand=new Random();
        col= rand.nextInt(5);
        if (board.isLegalMove(col)){
            board.updateMove(col, Piece.GREEN);
            board.getBoarUI().update(col,false);
            Winner winner = board.findWinner();
            if (winner!=null){
                board.getBoarUI().notifyWinner(winner);
            }
        }
    }
}
