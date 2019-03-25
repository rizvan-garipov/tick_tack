package com.merenaas.models;

import com.merenaas.MyButton;

public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(){
        super();
        this.setCanMakeMove(false);
    }
    @Override
    public void makeMove(MyButton button){
        super.makeMove(button);
        button.setText("O");
    }
}
