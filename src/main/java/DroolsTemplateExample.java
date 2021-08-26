import domain.Product;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.drools.template.ObjectDataCompiler;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DroolsTemplateExample {

    public static void main(String[] args) throws IOException {
        DroolsTemplateExample example = new DroolsTemplateExample();
        example.tryout();
    }

    public String CATEGORY_JEWELLERY = "jewellery";
    public String CATEGORY_GROCERY = "grocery";

    public void tryout() throws IOException {

        //Generate drl string from template
        InputStream inputStream = ClassLoader.class.getResourceAsStream("/droolsTemplate.txt");
        if(inputStream == null){
            throw new IOException("Failed to locate drl file");
        }

        List<Map<String, Double>> confs = new ArrayList<>();
        Map<String, Double> discountMap = new HashMap<>();
        discountMap.put("jewelleryDiscount", 50d);
        discountMap.put("groceryDiscount", 20d);
        confs.add(discountMap);
        String drl = new ObjectDataCompiler().compile(confs, inputStream);
        System.out.println("=============================");
        System.out.println("Generated drl from template:");
        System.out.println("=============================");
        System.out.println(drl);
        System.out.println("=============================");

        KieSession kSession = createKieSessionfromDrl(drl);
        kSession.setGlobal("CATEGORY_JEWELLERY", CATEGORY_JEWELLERY);
        kSession.setGlobal("CATEGORY_GROCERY", CATEGORY_GROCERY);

        Product ring = new Product("ring", CATEGORY_JEWELLERY, 100);
        Product groceryItem = new Product("groceryItem", CATEGORY_GROCERY, 100);

        System.out.println("Price of ring before discount = " + ring.getPrice());
        System.out.println("Price of groceryItem before discount = " + groceryItem.getPrice());
        kSession.insert(ring);
        kSession.insert(groceryItem);
        kSession.fireAllRules();

        System.out.println("Price of ring after discount = " + ring.getPrice());
        System.out.println("Price of groceryItem after discount = " + groceryItem.getPrice());

    }

    private KieSession createKieSessionfromDrl(String drl) throws IOException {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);

        Results results = kieHelper.verify();
        if(results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for(Message message : messages) {
                System.out.println("Error: " + messages);
            }
            throw new IOException("Errors while compiling rules");
        }
        return kieHelper.build().newKieSession();
    }
}
