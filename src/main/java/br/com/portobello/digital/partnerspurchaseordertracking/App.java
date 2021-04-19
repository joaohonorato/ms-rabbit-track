package br.com.portobello.digital.partnerspurchaseordertracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication(scanBasePackages = { "br.com.portobello.digital", "br.com.portobello.digital.commons" })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
