
import model.Fire;
import model.Room;
import model.Sprinkler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
