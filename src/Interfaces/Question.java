package Interfaces;

import java.io.Serializable;

/**
 * Created by digibrose on 13/04/2015.
 * A question is created by the setup client and is saved on the server as part of a quiz it will have a String
 * representing the question and a String array representing the answers
 */
public interface Question extends Serializable {
    /**
     * returns the Interfaces.Question string.
     * @return String question
     */
    String getQuestion();

    /**
     * returns the answer array
     * @return String[] answer
     */
    String[] getAnswers();

    /**
     * returns the position in the array with the correct answer
     * @return int answervalue
     */
    int CorrectValue();

    /**
     * creates the Interfaces.Question String
     */

    void addQuestion(String Question);

    /**
     * creates answer array
     */

    void addAnswers(String[] Answers);


}