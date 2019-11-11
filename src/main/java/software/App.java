package software;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("software.dao")
@EnableTransactionManagement

//mvn clean package -Dmaven.test.skip=true
//java -jar GPSoftware-1.0-SNAPSHOT.jar
public class App extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(App.class);
  }
}
