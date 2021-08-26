import domain.LoanApplication;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ModifyActionExample {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        KieSession ksession = kContainer.newKieSession();

        LoanApplication application = new LoanApplication(200);
        ksession.insert(application);
        ksession.fireAllRules();
    }
}