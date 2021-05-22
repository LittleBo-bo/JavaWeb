import com.cb.service.VisitService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VisitService visitService = context.getBean("VS",VisitService.class);
        try{visitService.visit("agree");}
        catch (Exception e){
            System.out.println(e.toString());
        }

        System.out.println("==================================");
        try{visitService.visit("false");}
        catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
