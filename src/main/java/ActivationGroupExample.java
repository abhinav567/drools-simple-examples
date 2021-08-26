import domain.Activation;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class ActivationGroupExample {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        KieSession ksession = kContainer.newKieSession();

        Agenda agenda = ksession.getAgenda();

        Activation activation = new Activation();
        ksession.insert(activation);
        ksession.fireAllRules();
    }
}