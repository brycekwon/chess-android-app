package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;

/**
 * Bishop
 * <p>
 * This class represents a knight piece in a game of chess. The bishop can move
 * any number of squares diagonally. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It cannot place its own king in check. It is
 * worth 3 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public class Bishop extends Piece {
    private static final String TAG = "PieceBishop";

    /**
     * Bishop constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public Bishop(int player) {
        super(player);

        this._value = 3;
        this._name = "Bishop";
    }

    /**
     * getMoves
     * <p>
     * This method gets all valid moves for the bishop.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param board         The board that the piece is on.
     * @return              The list of valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        // check all moves up left
        for (int i = 1; i < 8; i++) {
            if (row - i < 0 || col - i < 0) {
                break;
            }
            if (board[row - i][col - i].getPiece() == null) {
                valid.add(new PieceMove(row, col, row - i, col - i));
            } else if (board[row - i][col - i].getPiece().getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, row - i, col - i));
                break;
            } else {
                break;
            }
        }

        // check all moves up right
        for (int i = 1; i < 8; i++) {
            if (row + i > 7 || col - i < 0) {
                break;
            }
            if (board[row + i][col - i].getPiece() == null) {
                valid.add(new PieceMove(row, col, row + i, col - i));
            } else if (board[row + i][col - i].getPiece().getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, row + i, col - i));
                break;
            } else {
                break;
            }
        }

        // check all moves down left
        for (int i = 1; i < 8; i++) {
            if (row - i < 0 || col + i > 7) {
                break;
            }
            if (board[row - i][col + i].getPiece() == null) {
                valid.add(new PieceMove(row, col, row - i, col + i));
            } else if (board[row - i][col + i].getPiece().getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, row - i, col + i));
                break;
            } else {
                break;
            }
        }

        // check all moves down right
        for (int i = 1; i < 8; i++) {
            if (row + i > 7 || col + i > 7) {
                break;
            }
            if (board[row + i][col + i].getPiece() == null) {
                valid.add(new PieceMove(row, col, row + i, col + i));
            } else if (board[row + i][col + i].getPiece().getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, row + i, col + i));
                break;
            } else {
                break;
            }
        }

        return valid;
    }
}
