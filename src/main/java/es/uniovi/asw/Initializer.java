package es.uniovi.asw;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initializer implements ServletContextInitializer {
 
  @Override
  public void onStartup(ServletContext sc) throws ServletException {
    sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
    sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
  }
}