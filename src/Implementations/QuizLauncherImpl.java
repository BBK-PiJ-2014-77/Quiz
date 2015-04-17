package Implementations;

import Interfaces.Question;
import Interfaces.Quiz;
import Interfaces.QuizLauncher;
import Interfaces.QuizServer;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by digibrose on 15/04/2015.
 */
public class QuizLauncherImpl implements QuizLauncher {




    public static void main(String[] args) {

        launch();

    }

    private static void launch() {


        try{
            LocateRegistry.createRegistry(1099);
            QuizServer QuizServer = new QuizServerImpl();
            String registryHost = "//localhost/";
            String serviceName = "Interfaces.Quiz";
            Naming.rebind(registryHost + serviceName, QuizServer);

            File QuizFile = new File("/Users/digibrose/PiJ-work/Quiz/Test.csv");

            try{
                BufferedReader in = new BufferedReader(new FileReader(QuizFile));
                String Line;
                while((Line = in.readLine()) != null){

                    String[] Split1 = Line.split(",");

                    if (Split1.length == 4){

                Quiz NewQuiz = new QuizImpl(Split1[1]);
                        int QuestionNumber = Integer.parseInt(Split1[2]);
                        int AnswerNumber = Integer.parseInt(Split1[3]);

                        for (int i = 0; i < QuestionNumber; i++){
                            Line = in.readLine();

                            String[] Split2 = Line.split(",");

                            String[] Split3 = new String[AnswerNumber];
                            for (int j = 0; j < AnswerNumber; j++) {
                                Line = in.readLine();
                                String[] AnsSplit = Line.split(",");
                                Split3[j] = AnsSplit[1];
                            }

                            Question newQuestion = new QuestionImpl();

                            newQuestion.addQuestion(Split2[1]);
                            newQuestion.addAnswers(Split3);

                            NewQuiz.addQuestion(newQuestion);

                            }

                        QuizServer.setQuiz(NewQuiz);
                        }
                    }


                in.close();
            } catch (FileNotFoundException e){
                System.out.println("file does not exist");
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex){
            ex.printStackTrace();
        }

    }
}
