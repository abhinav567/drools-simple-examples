import domain.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class HelloWorld {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        KieSession ksession = kContainer.newKieSession();

        Person person = new Person("John Doe");
        ksession.insert(person);
        ksession.fireAllRules();
    }
}