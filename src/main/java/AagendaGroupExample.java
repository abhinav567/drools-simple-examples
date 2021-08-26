import model.Patient;
import model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class AagendaGroupExample {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        KieSession ksession = kContainer.newKieSession();

        Agenda agenda = ksession.getAgenda();
        agenda.getAgendaGroup( "report" ).setFocus();
        agenda.getAgendaGroup( "test" ).setFocus();

        Patient patient = new Patient("John Doe");
        ksession.insert(patient);
        ksession.fireAllRules();
    }
}