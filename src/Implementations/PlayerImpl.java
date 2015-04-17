package Implementations;

import Interfaces.Player;

/**
 * Created by digibrose on 17/04/2015.
 */
public class PlayerImpl implements Player {

    String Name = "";

    int Score = 0;

    @Override
    public void SetName(String Name) {
        this.Name = Name;
    }

    @Override
    public String GetName() {
        return Name;
    }

    @Override
    public void SetScore(int score) {

        this.Score = score;

    }

    @Override
    public int getScore() {
        return Score;
    }
}
