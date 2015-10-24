package by.epam.training;

import by.epam.training.domain.User;
import by.epam.training.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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

        User vitali = userService.getUserByEmail("Viweli_sadasd@epam.com");

        List<User> users = userService.getUsersByName("Vitali");

        for (User user: users){
            System.out.println(user);
            System.out.println(userService.getUserId(user));
        }

        System.out.println(vitali);
        int id = userService.getUserId(vitali);
        System.out.println(id);
        System.out.println(userService.getByID(id));
        userService.remove(id);

        System.out.println(userService.getByID(id));

    }

}
