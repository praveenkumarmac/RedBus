package in.redbus;

import java.time.Duration;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BusBooking {
	public static WebDriver driver;	
	
	@Test
	public void method1() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();		
		options.addArguments("disable-notifications");
		options.addArguments("disable-popups");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		String url = "https://www.redbus.in";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	@Test
	public void method2() {
		String fromPlace = "Chennai";
		WebElement from = driver.findElement(By.xpath("//label[text()='From']/preceding-sibling::input"));
		from.sendKeys(fromPlace);
		WebElement frompl = driver.findElement(By.xpath("//text[text()='Chennai']/parent::div[contains(@class,'grvhsy')]"));
		frompl.click();			
	}
	@Test
	public void method3() {
		String toPlace = "Trichy";
		WebElement to = driver.findElement(By.id("dest"));
		to.sendKeys(toPlace);
		WebElement topl = driver.findElement(By.xpath("//text[text()='Trichy']/parent::div[contains(@class,'grvhsy')]"));
		topl.click();		
	}
	@Test
	public void method4() {
		WebElement date = driver.findElement(By.xpath("//span[text()='4' and contains(@class,'dkWAbH')]"));
		date.click();		
	}
	@Test
	public void method5() {
		WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
		searchButton.click();
	}
	@Test
	public void method6() {
//		WebElement travelName = driver.findElement(By.xpath("//div[text()='SK Balu Bus']"));
//		WebElement departureTime = driver.findElement(By.xpath("//div[text()='06:00']"));
//		WebElement arrivalTime = driver.findElement(By.xpath("//div[text()='12:30']"));
//		WebElement price = driver.findElement(By.xpath("//span[text()='502']"));		
//		String travelnametext = travelName.getText();
//		String departureTime1Text= departureTime.getText();
//		String arrivalTimeText = arrivalTime.getText();
//		String priceText = price.getText();
//		System.out.println(travelnametext+" "+departureTime1Text+" "+arrivalTimeText+" "+priceText);		
		//driver.findElement(By.xpath("//div[contains(@class,'travels lh-24 f-bold d-color')]"));
		List<WebElement> buses = driver.findElements(By.xpath("//div[contains(@class,'travels lh-24 f-bold d-color')]"));
		List<WebElement> depTimes = driver.findElements(By.xpath("//div[contains(@class,'dp-time f-19 d-color f-bold')]"));		
		List<WebElement> arrTimes = driver.findElements(By.xpath("//div[contains(@class,'bp-time f-19 d-color disp-Inline')]"));
		List<WebElement> fare = driver.findElements(By.xpath("//span[contains(@class,'f-19')]"));
		int size = buses.size(); 
		for(int i=0; i<size;i++) {
			//System.out.println(buses.size());
			if(i==buses.size()-1) {
				//System.out.println(buses.size());
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true)", buses.get(i));
				buses = driver.findElements(By.xpath("//div[contains(@class,'travels lh-24 f-bold d-color')]"));
				depTimes = driver.findElements(By.xpath("//div[contains(@class,'dp-time f-19 d-color f-bold')]"));		
				arrTimes = driver.findElements(By.xpath("//div[contains(@class,'bp-time f-19 d-color disp-Inline')]"));
				fare = driver.findElements(By.xpath("//span[contains(@class,'f-19')]"));
				size = buses.size();
			}
			else {
				//System.out.println(size);
				String bus = buses.get(i).getText();
				//System.out.println(bus);
				String depTime = depTimes.get(i).getText();
				String arrTime = arrTimes.get(i).getText();
				String eachFare = fare.get(i).getText();
				System.out.println(bus+" "+depTime+" "+arrTime+" "+eachFare);
			}										
		}
		
//		for(WebElement x : buses) {
//			String bus = x.getText();
//			System.out.println(bus);
//		}
//		for(WebElement x : depTimes) {
//			String depTime = x.getText();
//			System.out.println(depTime);
//		}
//		for(WebElement x : arrTimes) {
//			String arrTime = x.getText();
//			System.out.println(arrTime);
//		}
//		for(WebElement x : fare) {
//			String eachFare = x.getText();
//			System.out.println(eachFare);
//		}
	}
}
