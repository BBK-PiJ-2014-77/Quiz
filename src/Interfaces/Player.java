package Interfaces;

import java.io.Serializable;

/**
 * Object to describe quiz players
 */
public interface Player extends Serializable {


    /**
     * Method to set name
     * @param Name
     */

    void SetName(String Name);


    /**
     * Method to get Name
     * @return String Name
     */

    String GetName();

    /**
     * Method to add score for player
     */

    void SetScore(int score);

    /**
     * Method to get score for player
     */

    int getScore();

}
