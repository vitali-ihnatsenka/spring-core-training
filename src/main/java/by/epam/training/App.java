package by.epam.training;

import by.epam.training.domain.User;
import by.epam.training.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vitali Ihnatsenka on 20.10.2015.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = appContext.getBean("userService", UserService.class);
        userService.register(new User("Vitali_Ihnatsenka@epam.com", "Vitali"));
        userService.register(new User("Vitali_sadasd@epam.com", "Vitali"));
        userService.register(new User("Viweli_sadasd@epam.com", "Viewdli"));

    }

}
