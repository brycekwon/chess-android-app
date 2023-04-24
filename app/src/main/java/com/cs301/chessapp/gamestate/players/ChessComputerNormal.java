package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * ChessComputerNormal class
 *
 * This class represents a computer player in the game of chess. It contains
 * information about the player and functionality for normal intelligence. This
 * player calculates a random move from the list of possible moves. There is
 * no logic behind the move.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessComputerNormal extends GameComputerPlayer {

    // this variable contains information about the player
    private int _playerTurn;

    /**
     * ChessComputerNormal constructor
     *
     * This constructor initializes a chess computer player with a name and
     * turn order.
     *
     * @param name      the player name
     */
    public ChessComputerNormal(String name) {
        super(name);
    }

    /**
     * receiveInfo
     *
     * This method receives information from the game and handles it. It
     * calculates a random move and sends it back to the game.
     *
     * @param info      the information received from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof ChessGameState) {
            ChessGameState gamestate = (ChessGameState) info;

            // get a random piece on the board
            int row;
            int col;
            do {
                row = (int) (Math.random() * 8);
                col = (int) (Math.random() * 8);
            } while (gamestate.getPiece(row, col) == null ||
                     gamestate.getPiece(row, col).getPlayerId() != _playerTurn ||
                     gamestate.getPiece(row, col).getMoves(gamestate, this).size() < 1);

            // get a random move from the list of possible moves
            int index = (int) (Math.random() * gamestate.getPiece(row, col).getMoves(gamestate, this).size());
            ChessMove move = gamestate.getPiece(row, col).getMoves(gamestate, this).get(index);

            // sleep to allow the user to see the move
            sleep(0.5);

            // send the move to the game
            game.sendAction(move);
        }
    }

    /**
     * setPlayerTurn
     *
     * This method sets the player turn.
     *
     * @param playerTurn        the player turn
     */
    public void setPlayerTurn(int playerTurn) {
        _playerTurn = playerTurn;
    }

    /**
     * getPlayerTurn
     *
     * This method returns the player turn.
     *
     * @return      the player turn
     */
    public int getPlayerTurn() {
        return _playerTurn;
    }
}
