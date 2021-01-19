package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Log4j2
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        MyController myController = (MyController) ctx.getBean("myController");

        log.info("-------- Primary");
        log.info(myController.sayHello());

        log.info("-------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        log.info(propertyInjectedController.getGreeting());

        log.info("-------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        log.info(setterInjectedController.getGreeting());

        log.info("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        log.info(constructorInjectedController.getGreeting());

        log.info("-------- Profiles");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        log.info(i18nController.getGreeting());
    }

}
