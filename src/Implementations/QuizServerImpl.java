package Implementations;

import Interfaces.Player;
import Interfaces.Quiz;
import Interfaces.QuizServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by digibrose on 15/04/2015.
 */
public class QuizServerImpl extends UnicastRemoteObject implements QuizServer {

    private List<Quiz> QuizList = new LinkedList<Quiz>();

    private Object Lock = new Object();

    public QuizServerImpl() throws RemoteException {
    }

    @Override
    public List getQuizzes() {

        synchronized (Lock) {

            List<String> Quiznamelist = new LinkedList<String>();

            for (int i = 0; i < QuizList.size(); i++) {
                Quiznamelist.add(QuizList.get(i).getName());
            }

            return Quiznamelist;

        }
    }

    @Override
    public Quiz launchQuiz(int QuizNumber) {
        Quiz retQuiz = QuizList.get(QuizNumber);
        return retQuiz;
    }

    @Override
    public void setQuiz(Quiz NewQuiz) {

        QuizList.add(NewQuiz);
        System.out.println("Quizadded");

    }

    @Override
    public Player endQuiz(int QuizNumber) {
        return null;
    }

    @Override
    public void setPlayer(Player newPlayer) {

    }

    @Override
    public int ReturnQuestionNumber(int Quiz) {
        return QuizList.get(Quiz).returnQuestionNumber();
    }

    @Override
    public void Flush() {

        PrintWriter out = null;
        try {

            File outfile = new File("/Users/digibrose/PiJ-work/Quiz/Testout.csv");
            out = new PrintWriter(outfile);

            for (int i = 0; i < QuizList.size(); i++) {

                int Questnum = QuizList.get(i).returnQuestionNumber();
                int Ansernum = QuizList.get(i).returnAnswerNumber();

                out.println(i + "," + QuizList.get(i).getName() + "," + Questnum + "," + Ansernum);

                for (int j = 0; j < Questnum; j++) {

                    out.println(i + "-" + j + "," + QuizList.get(i).getQuestion(j).getQuestion() + "," + QuizList.get(i).getQuestion(j).CorrectValue());

                    String[] Answerlist = QuizList.get(i).getQuestion(j).getAnswers();

                    for (int k = 0; k < Ansernum; k++) {

                        out.println(i + "-" + j + "-" + k + "," + Answerlist[k]);

                    }

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }  finally {
            out.close();


        }
    }
}
