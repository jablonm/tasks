package pl.kurs.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "pl.kurs.spring.aop")
@EnableAspectJAutoProxy
public class AopExampleApplicationConfiguration {

}
