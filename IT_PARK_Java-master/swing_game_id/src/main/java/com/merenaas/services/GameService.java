package com.merenaas.services;

import com.merenaas.MyButton;
import com.merenaas.TickTack;
import com.merenaas.models.ComputerPlayer;
import com.merenaas.models.HumanPlayer;

import java.util.List;

public class GameService {
    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;
    private TickTack tickTack;

    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(ComputerPlayer computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public TickTack getTickTack() {
        return tickTack;
    }

    public void setTickTack(TickTack tickTack) {
        this.tickTack = tickTack;
    }

    public GameService(ComputerPlayer computerPlayer, HumanPlayer humanPlayer) {
        this.computerPlayer = computerPlayer;
        this.humanPlayer = humanPlayer;
        this.tickTack = new TickTack(this);
    }

    public void addButtonsToPlayers(List<MyButton> buttons) {
        computerPlayer.setButtons(buttons);
        humanPlayer.setButtons(buttons);
    }

    public void move(MyButton button) {
        humanPlayer.makeMove(button);
        humanPlayer.setCanMakeMove(false);
        humanPlayer.win(button);
        try {
            MyButton buttonForComp = chooseButton();
            computerPlayer.makeMove(buttonForComp);
            computerPlayer.setCanMakeMove(false);
            computerPlayer.win(button);
            humanPlayer.setCanMakeMove(true);
            computerPlayer.setCanMakeMove(false);
        } catch (NullPointerException ex) {
            System.out.println("игра закончилась!!!");
        }
    }

    public MyButton chooseButton() {
        List<MyButton> buttons = computerPlayer.getButtons();
        int countMasters = 0;
        for(MyButton myButton:buttons) {
            if(myButton.getMaster() != null) {
                countMasters++;
            }
        }
        //очень плохая идея
        if(countMasters < 9) {
            while (true) {
                int x = (int) (Math.random() * 2);
                int y = (int) (Math.random() * 2);
                for (MyButton myButton : buttons) {
                    if (myButton.getMaster() == null && myButton.getyCoordinat() == y && myButton.getxCoordinat() == x) {
                        return myButton;
                    }
                }
            }
        }
        //все клетки заняты
        return null;
    }


}
