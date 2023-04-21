package com.monopolybankapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MonopolyBankAppServerApplicationTests {

	@Test
	@DisplayName("1 - Login inválido")
	void loginInvalido(){
		// Criar um objeto do tipo WebDriver
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		// Abrir a página do Google
		driver.get("http://localhost:8080/login.html");
		driver.findElement(By.id("username")).sendKeys("joao");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("btnLogin")).click();
/*		String msg = driver.findElement(By.id("success-message")).getText();
		Assertions.assertEquals("Erro ao realizar login",msg);*/
		// Fechar o navegador
		driver.quit();
	}

	@Test
	@DisplayName("2 - Cadastrar")
	void cadastrar(){

	}

}
