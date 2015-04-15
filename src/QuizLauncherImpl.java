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
            String serviceName = "Quiz";
            Naming.rebind(registryHost + serviceName, QuizServer);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex){
            ex.printStackTrace();
        }

    }
}
