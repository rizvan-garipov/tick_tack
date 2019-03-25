package com.merenaas.models;

import com.merenaas.MyButton;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer() {
        super();
        this.setCanMakeMove(true);
    }
    @Override
    public void makeMove(MyButton button){
       super.makeMove(button);
       button.setText("X");
    }

}
