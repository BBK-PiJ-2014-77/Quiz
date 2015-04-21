package Implementations;

import Interfaces.Player;
import Interfaces.PlayerClient;
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
public class PlayerClientLauncher{



    public static void main(String[] args) {

        launch(args);

    }


    private static void launch(String[] args) {

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

        PlayerClient NewClient = new PlayerClientImpl();
        NewClient.GetQuizzes(QuizService);

        System.out.println("Which would you like to play?");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int innum = Integer.parseInt(input);

        try {
          Player HighScorer = NewClient.PlayQuiz(QuizService.launchQuiz(innum));

            QuizService.SetHighScorer(innum, HighScorer);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
