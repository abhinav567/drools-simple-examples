import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.util.List;

public class DroolsTemplate {

    private KieSession createKieSessionfromDrl(String drl) throws Exception {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);

        Results results = kieHelper.verify();
        if(results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for(Message message : messages) {
                System.out.println("Error: " + messages);
            }
            throw new Exception("Errors while compiling rules");
        }
        return kieHelper.build().newKieSession();
    }
}
