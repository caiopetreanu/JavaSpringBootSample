package br.com.caiopetreanu.AvenueCodeRecruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
public class AvenueCodeRecruitmentApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		SpringApplication.run(AvenueCodeRecruitmentApplication.class, args);
		populateDatabase();
	}

	private static void populateDatabase() throws ClassNotFoundException, IOException, SQLException {

		Properties props = new Properties();
		props.load(AvenueCodeRecruitmentApplication.class.getClassLoader().getResourceAsStream("application.properties"));
		String sqlDir = String.valueOf(props.get("project.sqldir"));
		String datasourceUrl = String.valueOf(props.get("spring.datasource.url"));
		String username = String.valueOf(props.get("spring.datasource.username"));
		String password = String.valueOf(props.get("spring.datasource.password"));

		Class.forName("org.h2.Driver");

		StringBuffer url = new StringBuffer();

		url.append(datasourceUrl + ";INIT=runscript from '" + sqlDir + "init.sql'");

		Connection conn = DriverManager.getConnection(url.toString(), username, password);
		conn.close();

	}

}
