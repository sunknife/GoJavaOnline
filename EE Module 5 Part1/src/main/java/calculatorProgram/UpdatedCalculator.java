package calculatorProgram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdatedCalculator {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        UpdatedCalculator bean = (UpdatedCalculator) applicationContext.getBean("bootstrap", UpdatedCalculator.class);
        bean.execute();
    }

    public void execute(){

    }
}
