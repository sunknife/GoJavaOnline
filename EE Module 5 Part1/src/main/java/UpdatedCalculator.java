import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdatedCalculator {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        UpdatedCalculator bean = (UpdatedCalculator) applicationContext.getBean("bootstrap", UpdatedCalculator.class);
        bean.execute();
    }

    public void execute() {
        BaseCalculator calculator = new BaseCalculator();
        calculator.addOperation('*', new Multiply());
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your expression:");
        try {
            calculator.read(scanner.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(calculator.getResult());
    }
}
