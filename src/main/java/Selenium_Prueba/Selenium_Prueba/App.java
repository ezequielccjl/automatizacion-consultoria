package Selenium_Prueba.Selenium_Prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
	
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
    	
    	//Inicializa ChromeDriver y JsExecutor para realizar scroll
    	ChromeDriver driver = new ChromeDriver();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	System.out.println("Inicializa ChromeDriver y JsExecutor para realizar scroll");
    	
    	//Ingresa a la página de Consultoría
    	driver.get("https://www.consultoriaglobal.com.ar/cgweb/");
    	System.out.println("Ingresa a la página de Consultoría");
    	
    	//Maximiza ventana
    	driver.manage().window().maximize();
    	System.out.println("Maximiza ventana");
    	
    	//Nos dirigimos a la seccion Contacto
    	WebElement btnContacto = driver.findElement(By.cssSelector("#menu-item-1364 > a"));
    	btnContacto.click();
    	System.out.println("Nos dirigimos a la seccion Contacto");
    	
    	//Realiza scroll hasta el elemento determinado por el xPath
    	WebElement flag = driver.findElement(By.xpath("//*[@id=\"post-370\"]/div/div[1]/div[1]/div/h4/strong"));
    	js.executeScript("arguments[0].scrollIntoView();", flag);
    	System.out.println("Realiza scroll hasta el elemento determinado por el xPath");
    	
    	//Inicializa los inputs del formulario
    	WebElement nombre = driver.findElement(By.cssSelector("span.your-name > input"));
    	WebElement email = driver.findElement(By.cssSelector("span.your-email > input"));
    	WebElement asunto = driver.findElement(By.cssSelector("span.your-subject > input"));
    	WebElement mensaje = driver.findElement(By.cssSelector("span.your-message > textarea"));
    	
    	//Completa inputs
    	nombre.sendKeys("Ezequiel Cordova Cruz");
    	email.sendKeys("Esto es un error");
    	asunto.sendKeys("Prueba");
    	mensaje.sendKeys("Esta es una prueba para automatizar dentro de la página de Consultoría Global.");
    	System.out.println("Completa inputs");
    	
    	//Clickea en SUBMIT
    	WebElement submit = driver.findElement(By.cssSelector("p > input.wpcf7-submit"));
    	submit.click();
    	System.out.println("Clickea submit");
    }
}
