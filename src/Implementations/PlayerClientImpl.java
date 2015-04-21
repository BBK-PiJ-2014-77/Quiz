package Implementations;

import Interfaces.Player;
import Interfaces.PlayerClient;
import Interfaces.Quiz;
import Interfaces.QuizServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by digibrose on 15/04/2015.
 */
public class PlayerClientImpl implements PlayerClient {


    @Override
    public void GetQuizzes(QuizServer QuizService) {

        try{
            int NumberofQuizzes =  QuizService.getQuizzes().size();
            List<String> retrievedquizzes = (List<String>) QuizService.getQuizzes();
            System.out.println("Here is the List of Quizzes");
            for (int i = 0; i < NumberofQuizzes; i++) {
                System.out.println(i + ". " + retrievedquizzes.get(i));
            }
        } catch (RemoteException e){
            e.printStackTrace();
            System.out.println("1");
        }

    }

    @Override
    public Player PlayQuiz(Quiz ChosenQuiz) {

        int score = 0;

        for (int i = 0;i < ChosenQuiz.returnQuestionNumber(); i++){

            System.out.println(" Q1. " + ChosenQuiz.getQuestion(i).getQuestion());

            String[] Answers = ChosenQuiz.getQuestion(i).getAnswers();
            for (int j = 0; j < ChosenQuiz.returnAnswerNumber(); j++){

                System.out.println("A" + j + ". " + Answers[j]);

            }

            System.out.println("Which is you chosen Answer?");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            int answerinp = Integer.parseInt(input);

            if (answerinp == ChosenQuiz.getQuestion(i).CorrectValue()){
                score++;
            }

        }

        System.out.println("Your Score was " + score);

        if (score > ChosenQuiz.getHighScorer().getScore()){

            System.out.println("New High Score!!");
            System.out.println("Please put your name");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            Player newHighScorer = new PlayerImpl();
            newHighScorer.SetName(input);
            newHighScorer.SetScore(score);
             ChosenQuiz.setHighScorer(newHighScorer);
        }

        return ChosenQuiz.getHighScorer();

    }
}
