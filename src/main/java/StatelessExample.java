
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

        Fire kitchenFire = new Fire( new Room( "kitchen" ) );
        ksession.execute(kitchenFire);

        Fire officeFire = new Fire( new Room( "office" ) );
        ksession.execute(officeFire);
    }
}
