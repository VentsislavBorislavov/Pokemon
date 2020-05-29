package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop<T> implements ActionListener {

    T t;

    GameLoop(T t){
        this.t = t;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(t instanceof ArenaPanel){
            ((ArenaPanel) t).doOneLoop();
        }
        if(t instanceof Display){
            ((Display) t).doOneLoop();
        }
    }
}
