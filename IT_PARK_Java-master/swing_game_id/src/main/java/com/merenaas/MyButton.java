package com.merenaas;

import com.merenaas.models.AbstractPlayer;

import javax.swing.*;

public class MyButton extends JButton {
    private int xCoordinat;
    private int yCoordinat;
    private AbstractPlayer master;

    public void setxCoordinat(int xCoordinat) {
        this.xCoordinat = xCoordinat;
    }

    public void setyCoordinat(int yCoordinat) {
        this.yCoordinat = yCoordinat;
    }

    public int getxCoordinat() {
        return xCoordinat;
    }

    public int getyCoordinat() {
        return yCoordinat;
    }

    public AbstractPlayer getMaster() {
        return master;
    }

    public void setMaster(AbstractPlayer master) {
        this.master = master;
    }

    public MyButton(int xCoordinat, int yCoordinat) {
        this.xCoordinat = xCoordinat;
        this.yCoordinat = yCoordinat;
        this.master = null;
    }


}
