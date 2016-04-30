import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class UpdatedCalculator {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        UpdatedCalculator bean = (UpdatedCalculator) applicationContext.getBean("bootstrap", UpdatedCalculator.class);
        bean.execute();
    }

    public void execute(){
        BaseCalculator calculator = new BaseCalculator();
        calculator.addOperation('*', new Multiply());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your expression:");
        calculator.read(scanner.nextLine());
        calculator.getResult();
    }
}
