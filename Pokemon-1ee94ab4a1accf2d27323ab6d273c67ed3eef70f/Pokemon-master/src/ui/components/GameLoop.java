package ui.components;

import ui.App;
import ui.panels.ArenaPanel;
import ui.panels.StatsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop<T> implements ActionListener {

    T t;

    public GameLoop(T t){
        this.t = t;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(t instanceof ArenaPanel){
            ((ArenaPanel) t).doOneLoop();
        }
        if(t instanceof App){
            ((App) t).doOneLoop();
        }
        if(t instanceof StatsScreen){
            ((StatsScreen) t).doOneLoop();
        }
    }
}
