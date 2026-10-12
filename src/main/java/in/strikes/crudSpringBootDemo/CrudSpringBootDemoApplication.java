package in.strikes.crudSpringBootDemo;

import org.hibernate.annotations.processing.Exclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {
	SpringApplication.run(CrudSpringBootDemoApplication.class, args);

	}

}
