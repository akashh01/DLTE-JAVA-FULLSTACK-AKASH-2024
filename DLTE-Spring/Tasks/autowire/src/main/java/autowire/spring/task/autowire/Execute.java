package autowire.spring.task.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Execute {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.scan("autowire.spring.task");
        applicationContext.refresh();
        //executing home loan
        MyBank myBank=applicationContext.getBean(MyBank.class);
        System.out.println(myBank.callFindAll().toString());
    }
}
