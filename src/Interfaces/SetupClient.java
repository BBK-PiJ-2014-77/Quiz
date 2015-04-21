package Interfaces;

/**
 * Created by digibrose on 13/04/2015.
 */
public interface SetupClient {


    /**
     * Method to send a new Quiz to the server
     */
    void addQuiz();


    /**
     * Method to end a quiz on the server
     */
    void endQuiz(int QuizId);


}
