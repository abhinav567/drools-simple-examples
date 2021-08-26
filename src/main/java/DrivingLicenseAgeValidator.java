import model.Applicant;
import model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DrivingLicenseAgeValidator {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        KieSession ksession = kContainer.newKieSession();

        Applicant applicant = new Applicant("John Doe", 16);
        ksession.insert(applicant);
        ksession.fireAllRules();
        System.out.println("Is DL applicant valid: " +  applicant.isValid());
    }
}
