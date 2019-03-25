package com.merenaas;

import com.merenaas.models.HumanPlayer;
import com.merenaas.services.GameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TickTack {
    private HumanPlayer player;
    private GameService service;

    public GameService getService() {
        return service;
    }

    public void setService(GameService service) {
        this.service = service;
    }

    public HumanPlayer getPlayer() {
        return player;
    }

    public void setPlayer(HumanPlayer player) {
        this.player = player;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public List<MyButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<MyButton> buttonList) {
        this.buttonList = buttonList;
    }

    private JPanel panel;
    private List<MyButton> buttonList;

    public TickTack(GameService service) {
        panel = new JPanel();
        GridLayout gridLayout = new GridLayout(3,3);
        panel.setLayout(gridLayout);
        buttonList = new ArrayList<MyButton>();
        for( int i = 0; i < 3; i ++) {
            for(int j = 0; j< 3; j++) {
                MyButton button = new MyButton(i,j);
                button.addActionListener(new PressToButton());
                buttonList.add(button);
                panel.add(button);
                button.setForeground(Color.RED);
                button.setFont(new Font("Font", Font.BOLD, 34));
            }
        }
        //каждый игрой имеет список кнопок
        service.addButtonsToPlayers(buttonList);
        JFrame jFrame = new JFrame("Крестики-нолики");
        jFrame.setContentPane(panel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeWidth = 600;
        int sizeHeight = 600;
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        jFrame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected class PressToButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MyButton button = (MyButton) e.getSource();
            if(button.getMaster() == null && player.getCanMakeMove() == true) {

                    service.move(button);

            }
//            if(button.getMaster() != null) {
//
//            }
//            button.setText("X");

        }
    }
}
