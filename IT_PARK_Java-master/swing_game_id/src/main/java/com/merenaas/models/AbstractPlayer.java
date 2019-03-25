package com.merenaas.models;


import com.merenaas.MyButton;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer {
    private List<MyButton> buttons;
    private boolean canMakeMove;

    public boolean getCanMakeMove() {
        return canMakeMove;
    }

    public void setCanMakeMove(boolean canMakeMove) {
        this.canMakeMove = canMakeMove;
    }

    public List<MyButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<MyButton> buttons) {
        this.buttons = buttons;
    }

    public AbstractPlayer() {
        buttons = new ArrayList();
    }
    public boolean win(MyButton button) {
        int x = button.getxCoordinat();
        int y = button.getyCoordinat();
        int xCount = 0;
        int yCount = 0;
        int mainDiagonalCount = 0;
        int secondDiagonalCount = 0;
        for(MyButton myButton: buttons) {
            if(myButton.getMaster() != null) {
                if(myButton.getxCoordinat() == x && myButton.getMaster().equals(this)) {
                    xCount++;
                }
            }
        }
        if(xCount == 3) {
            System.out.println("три в строке");
            return true;
        }
        for (MyButton myButton:buttons) {
            if(myButton.getMaster() != null) {
                if (myButton.getyCoordinat() == y && myButton.getMaster().equals(this)) {
                    yCount++;
                }
            }

        }
        if(yCount == 3) {
            System.out.println("три в столбец");
             return true;
        }
        for (MyButton myButton: buttons) {
            if(myButton.getMaster() != null) {
                if(myButton.getxCoordinat() == myButton.getyCoordinat() && myButton.getMaster().equals(this)) {
                    mainDiagonalCount++;
                }
            }

        }
        if(mainDiagonalCount == 3) {
            System.out.println("главная диагональ");
            return true;
        }
        for (MyButton myButton: buttons) {
            if(myButton.getMaster() != null) {
                if((myButton.getxCoordinat() == 0 && myButton.getyCoordinat() == 2
                        || myButton.getxCoordinat() == 1 && myButton.getyCoordinat() == 1
                        || myButton.getxCoordinat() == 2 && myButton.getyCoordinat() == 0
                ) && myButton.getMaster().equals(this)) {
                    secondDiagonalCount++;
                }
            }

        }
        if(secondDiagonalCount == 3) {
            System.out.println("Вторая диагональ");
            return true;
        }
        return false;
    }
    public void makeMove(MyButton button){
        System.out.println(button.getxCoordinat() +" " + button.getyCoordinat());
        button.setMaster(this);

    }
}
