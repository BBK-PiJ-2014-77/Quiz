package Implementations;

import Interfaces.Question;
import Interfaces.Quiz;
import Interfaces.QuizServer;
import Interfaces.SetupClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by digibrose on 15/04/2015.
 */
public class SetupClientImpl implements SetupClient {






    @Override
    public void addQuiz() {

        /**
         * Create quiz and name it
         */

        System.out.println("please name the quiz");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();


        /**
         * add the questions ans answers
         */

        System.out.println("How many Questions?");
        String numberquest = in.nextLine();
        int num = Integer.parseInt(numberquest);

        System.out.println("How many Multiple choice answers per Question?");
        String numberanswer = in.nextLine();
        int numanswer = Integer.parseInt(numberquest);

        Quiz newQuiz = new QuizImpl(name, num, numanswer);

        for (int i = 0; i < num; i++) {
            System.out.println("please add a question");
            Question Quest = new QuestionImpl();
            Quest.addQuestion(in.nextLine());
            newQuiz.addQuestion(Quest);
            String[] AnswerOptions = new String[numanswer];
            for (int j = 0; j < numanswer; j++) {
                System.out.println("Please add an answer");
                AnswerOptions[j] = in.nextLine();
            }

            System.out.println("Which is correct?");
            String Correct = in.nextLine();
            int cor = Integer.parseInt(Correct);

            Quest.addAnswers(AnswerOptions, cor);
        }

        Remote service = null;

        try {
            service = Naming.lookup("//localhost:1099/Interfaces.Quiz");
        } catch (NotBoundException e) {
            e.printStackTrace();
            System.out.println("1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("2");
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("3");
        }
        QuizServer QuizService = (QuizServer) service;

        try {
            QuizService.setQuiz(newQuiz);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("4");
        }



        try {
            for (int k = 0; k < QuizService.getQuizzes().size(); k++) {

                System.out.println("Getting Quiz name");

                try {
                    Quiz returnedQuiz = QuizService.launchQuiz(k);
                    System.out.println(returnedQuiz.getName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                    System.out.println("4");
                }

                System.out.println("Getting Quiz Questions and Answers");

                try {
                    Quiz returnedQuiz = QuizService.launchQuiz(k);
                    for (int i = 0; i < returnedQuiz.returnQuestionNumber(); i++) {
                        System.out.println(returnedQuiz.getQuestion(i).getQuestion());
                        for (int j = 0; j < returnedQuiz.getQuestion(i).getAnswers().length; j++) {
                            System.out.println(returnedQuiz.getQuestion(i).getAnswers()[j]);
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                    System.out.println("4");
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

        @Override
    public void endQuiz() {

    }
}
