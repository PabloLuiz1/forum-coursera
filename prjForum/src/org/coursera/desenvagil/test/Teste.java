package org.coursera.desenvagil.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.coursera.desenvagil.controller.ComentarioController;
import org.coursera.desenvagil.model.Comentario;
import org.coursera.desenvagil.model.Topico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Teste {
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void criarconta() {
	    driver.get("http://localhost:8082/prjForum/criar-conta");
	    driver.findElement(By.id("nome")).click();
	    driver.findElement(By.id("nome")).sendKeys("Luiz Roberto");
	    driver.findElement(By.id("login")).sendKeys("luiz123");
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).sendKeys("luiz123@gmail.com");
	    driver.findElement(By.id("senha")).click();
	    driver.findElement(By.id("senha")).sendKeys("luiz123");
	    driver.findElement(By.cssSelector(".col-md-8")).click();
	    driver.findElement(By.id("confirmarSenha")).click();
	    driver.findElement(By.id("confirmarSenha")).sendKeys("luiz123");
	    driver.findElement(By.cssSelector(".container")).click();
	    driver.findElement(By.cssSelector(".btn-primary")).click();
	    driver.findElement(By.cssSelector(".alert")).click();
	    assertThat(driver.findElement(By.cssSelector("strong")).getText(), is("Conta criada com sucesso. Clique aqui para fazer login."));
	  }
	  
	  @Test
	  public void login() {
	    driver.get("http://localhost:8082/prjForum/");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.name("login")).sendKeys("qualquercoisa");
	    driver.findElement(By.name("senha")).sendKeys("qualquercoisa");
	    driver.findElement(By.cssSelector(".btn-primary")).click();
	    driver.findElement(By.cssSelector(".alert")).click();
	    assertThat(driver.findElement(By.cssSelector("strong")).getText(), is("Login e/ou senha inválidos."));
	  }
}
