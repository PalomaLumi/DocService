package br.com.exemplo.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebappApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args);
    }

    // Necessário para rodar como WAR dentro do Tomcat externo
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebappApplication.class);
    }
}
