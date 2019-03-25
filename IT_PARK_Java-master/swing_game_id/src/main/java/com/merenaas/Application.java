package com.merenaas;

import com.merenaas.models.AbstractPlayer;
import com.merenaas.models.ComputerPlayer;
import com.merenaas.models.HumanPlayer;
import com.merenaas.services.GameService;

public class Application {
    public static void main(String[] args) {
        ComputerPlayer comp = new ComputerPlayer();
        HumanPlayer human = new HumanPlayer();
        GameService gameService = new GameService(comp, human);
        TickTack tickTack =gameService.getTickTack();
        tickTack.setPlayer(human);
        tickTack.setService(gameService);
    }
}
