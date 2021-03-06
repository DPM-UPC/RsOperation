package pe.edu.upc.RsOperation;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.out.println("RsOperationApplication - variable property SPRING_PROFILES_ACTIVE: " + System.getProperty("SPRING_PROFILES_ACTIVE"));
        //System.out.println("list properties: "+System.getProperties());
        return application.sources(RsOperationApplication.class);
    }

}
