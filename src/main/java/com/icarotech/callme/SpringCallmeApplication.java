package com.icarotech.callme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/callme")
public class SpringCallmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCallmeApplication.class, args);
	}

	@GetMapping
	public String callme() {
		return "Thanks for calling me";
	}

	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new io.jaegertracing.Configuration("spring-tracing-rabbitmq").getTracer();
	}

}
