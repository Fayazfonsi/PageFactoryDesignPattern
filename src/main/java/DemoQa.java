import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoQa {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	 
	public DemoQa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "(//li)[1]")
	WebElement textBoxField;
	
	@FindBy (css = "#userName")
	WebElement fullNameField;
	
	@FindBy (css = "#userEmail")
	WebElement emailField;
	
	@FindBy (css = "#currentAddress")
	WebElement currentAddressField;
	
	@FindBy (css = "#permanentAddress")
	WebElement permenentAdressField;
	
	@FindBy (css = "#submit")
	WebElement submitField;
	
	@FindBy (css = "#output")
	WebElement outputField;
	
	@Test(priority=0)
	public void textBox() {
		
		String name [] = new String []{"ponuswami", "periyaswami", "kanuswami"};
		String email [] = new String [] {"pswami@gmai.com","perswami@gmail.com", "kanuswami@gmail.com"};
		String cAddress [] = new String [] {"koyamedu","kotamedu","puliyamedu"};
		String pAddress [] = new String [] {"papampati","puliyambatti","kollambati"};
		
		
		
		textBoxField.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1)[1]")));
		
		int j=0;
		for (int i = 0; i<=2; i++) {
			
			
			
		
		fullNameField.sendKeys(name[j]);
		emailField.sendKeys(email[j]);
		currentAddressField.sendKeys(cAddress[j]);
		permenentAdressField.sendKeys(pAddress[j]);
		
		js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(240,340)");
		
		submitField.click();
		driver.navigate().refresh();
		j++;
		}
		
			
		
		System.out.println(outputField.getText());
		
		
		
		
	
		
	}
	
}

