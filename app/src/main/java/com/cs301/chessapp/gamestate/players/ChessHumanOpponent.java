package com.cs301.chessapp.gamestate.players;

import android.view.View;

import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;

public class ChessHumanOpponent extends GameHumanPlayer {
    private static final String TAG = "ChessHumanOpponent";

    /**
     * constructor
     *
     * @param name the name of the player
     */
    public ChessHumanOpponent(String name) {
        super(name);
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}