package com.sugggarCoffe;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sugggarCoffe.sub.controller.ProductoController;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
		
		Logger logger= Logger.getLogger(ProductoController.class.getName());
		
	}

}
