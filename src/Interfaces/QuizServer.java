package Interfaces;

import Interfaces.Player;
import Interfaces.Quiz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by digibrose on 13/04/2015.
 */
public interface QuizServer extends Remote {

    /**
     * Method to return the list of Quizzes available
     * @return List Quizzes
     */

    List getQuizzes() throws RemoteException;

    /**
     * Method to carry out chosen quiz
     * @param QuizNumber
     * @return Interfaces.Quiz
     */

    Quiz launchQuiz(int QuizNumber) throws RemoteException;

    /**
     * Method to set a quiz
     * @param NewQuiz
     */

    void setQuiz(Quiz NewQuiz) throws RemoteException;

    /**
     * Method to end quiz and return the winner
     * @param QuizNumber
     * @return Interfaces.Player Winner
     */

    Player endQuiz(int QuizNumber) throws RemoteException;


    /**
     * Method to set up newPlayer
     * @param newPlayer
     */
    void setPlayer(Player newPlayer) throws RemoteException;



}
