package Implementations;

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




    public static void main(String[] args) {

        launch();

    }


    public static void launch() {

    System.out.println("please name the quiz");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        Quiz newQuiz = new QuizImpl(name);

     Remote service = null;

        try{
            service = Naming.lookup("//localhost:1099/Interfaces.Quiz");
        } catch (NotBoundException e){
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

        try{
             QuizService.setQuiz(newQuiz);
        } catch (RemoteException e){
            e.printStackTrace();
            System.out.println("4");
        }

        System.out.println("Getting Interfaces.Quiz name");

        try {
            Quiz returnedQuiz = QuizService.launchQuiz(0);
            System.out.println(returnedQuiz.getName());
        } catch (RemoteException e ){
            e.printStackTrace();
            System.out.println("4");
        }


    }
}
