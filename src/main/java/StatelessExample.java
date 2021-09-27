
import domain.Fire;
import domain.Room;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class StatelessExample {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        StatelessKieSession ksession = kContainer.newStatelessKieSession();
        ksession.setGlobal("ANSI_RED", ANSI_RED);
        ksession.setGlobal("ANSI_RESET", ANSI_RESET);
        ksession.setGlobal("ANSI_GREEN", ANSI_GREEN);

        Fire kitchenFire = new Fire( new Room( "kitchen" ) );
        ksession.execute(kitchenFire);

        Fire officeFire = new Fire( new Room( "office" ) );
        ksession.execute(officeFire);
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
}
