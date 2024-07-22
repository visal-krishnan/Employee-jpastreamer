package com.ust.Employee_jpastreamer;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.repository.Employeerepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com.ust.Employee_jpastreamer", "com.speedment.jpastreamer"})
//@EntityScan("com.ust.Employee_jpastreamer.model")
//@ComponentScan(basePackages = {"com.speedment.jpastreamer.application", "com.ust.EmployeeJpastreamer.service"})
//@ComponentScan(basePackages = {"com.ust.Employee_jpastreamer.controller", "com.ust.Employee_jpastreamer.service"})
//@EnableMongoRepositories(basePackageClasses ={ JPAStreamer.class , Employeerepo.class })
public class EmployeeJpastreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJpastreamerApplication.class, args);
	}

}
