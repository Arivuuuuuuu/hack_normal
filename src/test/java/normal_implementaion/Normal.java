package normal_implementaion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Normal {
	
    static WebDriver driver;
    //static JavascriptExecutor js;
 
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.practo.com");
		driver.manage().window().maximize();
				
		
		driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-locality']")).clear();
		Thread.sleep(5000);
		
	    driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-locality']")).sendKeys("Mumbai");

	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//div[@data-qa-id='omni-suggestion-main'])[1]")).click();
	    
   
		driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-keyword']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='c-omni-suggestion-item'][4]")).click();
		
		
			
//		driver.findElement(By.xpath("//div[@role='button'][1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='button'][1]//li[1]")).click();
		
		driver.findElement(By.xpath("//div[@role='button'][2]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@role='button'][2]//li[1]")).click();
		
		driver.findElement(By.xpath("//div[@role='button'][3]")).click();
		Thread.sleep(3000);
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(7000);
		WebElement click=driver.findElement(By.xpath("//div[@role='button'][3]//li[2]"));
		js.executeScript("arguments[0].click()", click);
		
		
		
		driver.findElement(By.xpath("//div[@role='button'][4]")).click();
		
		
		Thread.sleep(3000);
		WebElement click1=driver.findElement(By.xpath("//div[@class='pure-u-4-24'][1]//label[3]"));
		js.executeScript("arguments[0].click()", click1);
		
		Thread.sleep(3000);
		WebElement click2=driver.findElement(By.xpath("//div[@class='pure-u-4-24'][1]//label[4]"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", click2);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Relevance']")).click();
		Thread.sleep(3000);
		
		//WebElement click3=driver.findElement(By.xpath("//span[text()='Experience - High to Low']"));
		WebElement click3=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li[2]"));
		js.executeScript("arguments[0].click()", click3);	
		
		
		

		
		for(int i=2;i<7;i++) {
			Thread.sleep(5000);
			//WebElement info=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div["+i+"]/div[1]/div/div[1]/div[2]/a/div"));
			
			WebElement info=driver.findElement(By.xpath("(//div[@class='info-section'])["+i+"]"));
			js.executeScript("arguments[0].scrollIntoView();", info);		
			
			//info.click();
			js.executeScript("arguments[0].click();", info);
			
			Thread.sleep(5000);
			
			Set<String>window=driver.getWindowHandles();
			//System.out.println(window);
			List<String>wind=new ArrayList<String>(window);
			String parent=wind.get(0);
			String child=wind.get(1);
			driver.switchTo().window(child);
			
			String text=driver.findElement(By.xpath("//div[@class='pure-u-20-24']")).getText();
			
			//String text=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div[1]/div[2]")).getText();
			System.out.println();
			System.out.println(text);
		    System.out.println();
			
			Thread.sleep(5000);
			
			driver.close();
			
			driver.switchTo().window(parent);	
		}
		
		Thread.sleep(5000);
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//div[contains(text(),'Surgeries')]")).click();
		
		WebElement scroll=driver.findElement(By.xpath("//h1[text()='Popular Surgeries']"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		
		List<WebElement>surgery=driver.findElements(By.xpath("//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']"));	
		System.out.println("Surgery list: "+" "+surgery.size());
		
		for(WebElement k:surgery) {
			System.out.println(k.getText());
		}
		
		System.out.println();
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//span[@class='nav-interact']")).click();
		
		driver.findElement(By.xpath("//a[text()='Health & Wellness Plans']")).click();
		
        driver.findElement(By.id("name")).sendKeys("arivv");
        
        driver.findElement(By.id("organizationName")).sendKeys("CSK");
        
        driver.findElement(By.id("contactNumber")).sendKeys("8072831499");
        
        driver.findElement(By.id("officialEmailId")).sendKeys("abc");
        
        WebElement s=driver.findElement(By.id("organizationSize"));
        
        Select ss=new Select(s);
        ss.selectByIndex(2);
        
        WebElement s1=driver.findElement(By.id("interestedIn"));
        Select s2=new Select(s1);
        s2.selectByIndex(1);
        
        WebElement visible=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header[2]/div[2]/div/form/button"));
        
        if(visible.isEnabled()) {
        	System.out.println("Yes");
        }
        else {
        	System.out.println("No");
        }
        
        Thread.sleep(5000);
        
        driver.findElement(By.id("officialEmailId")).clear();
        driver.findElement(By.id("officialEmailId")).sendKeys("abc@gmail.com");
        
        js.executeScript("arguments[0].click()", visible);
        
        Thread.sleep(10000);
        WebElement thanks=driver.findElement(By.xpath("(//div[text()='THANK YOU'])"));
        
        if(thanks.isDisplayed()) {
        	System.out.println("yeah");
        }
        else {
        	System.out.println("nope");
        }
        
        Thread.sleep(7000);
        
        driver.quit();
        
        
	}

	}

