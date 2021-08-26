
import model.Applicant;
import model.Fire;
import model.Room;
import model.Sprinkler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class StateFulExample {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession();
        ksession.setGlobal("ANSI_RED", ANSI_RED);
        ksession.setGlobal("ANSI_RESET", ANSI_RESET);
        ksession.setGlobal("ANSI_GREEN", ANSI_GREEN);

        Fire kitchenFire = new Fire( new Room( "kitchen" ) );
        Fire officeFire = new Fire( new Room( "office" ) );

        promptEnterKey();
        FactHandle kitchenFireHandle = ksession.insert( kitchenFire );
        ksession.fireAllRules();

        promptEnterKey();
        FactHandle officeFireHandle = ksession.insert( officeFire );
        ksession.fireAllRules();

        promptEnterKey();
        ksession.delete( kitchenFireHandle );
        ksession.fireAllRules();

        promptEnterKey();
        ksession.delete( officeFireHandle );
        ksession.fireAllRules();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
