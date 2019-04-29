package Steps;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.Select;



import Util.Lib;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GUIStepsDefination extends Lib {

	WebDriver driver;
	Select select;
	Actions ac;

	@Before
	public void beforestarting() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Given("^user is home page$")
	public void homepage() throws Exception {
		driver.get(ReadProperties("url"));

	}

	@And("^user edit the values$")
	public void editing() throws Exception {

//	Actions ac=new Actions(driver);
//	WebElement loanamount=driver.findElement(By.xpath("/html/body/div/div/main/article/div[3]/div/div[1]/div[1]/div[2]/form/div/div[2]/span"));
//	ac.dragAndDropBy(loanamount, 83, 0).build().perform();

		System.out.println(driver.getTitle());

		WebElement contactus = driver.findElement(By.cssSelector("#menu1 > ul > li:nth-child(7) > a"));
		ac = new Actions(driver);
		ac.moveToElement(contactus).click().build().perform();

	}

	@And("^user select option$")
	public void compaint() {

		driver.findElement(By.xpath("//select[@name='category']")).click();

		select = new Select(driver.findElement(By.xpath("//select[@name='category']")));

		List<WebElement> list = select.getOptions();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			if (list.get(i).getText().contains("Store Complaints")) {
				list.get(i).click();
			}
		}

		// select.selectByIndex(4);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/h1")).click();

		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		System.out.println(driver.getTitle());

	}

	@And("^user enter compaint info(.*)$")
	public void compaint_info(String info) {
		select = new Select(driver.findElement(By.xpath("//select[contains(@name,'locState')]")));

		List<WebElement> list1 = select.getOptions();

		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
		}
		select.selectByVisibleText("Maryland");

//			if (list1.get(i).getText().contains("Maryland"))
//			list1.get(i).click();

//			try{
//			if (list1.get(i).getText().contains("Maryland"))
//			list1.get(i).click();
//			}
//			catch(StaleElementReferenceException e){
//				if (list1.get(i).getText().contains("Maryland"))
//				list1.get(i).click();				
//			}
//			

	}

	@And("^user select city(.*)$")
	public void city_select(String city) {

		select = new Select(driver.findElement(By.xpath("//select[contains(@name,'locCity')]")));

		List<WebElement> list2 = select.getOptions();
		for (int k = 0; k < list2.size(); k++) {

			System.out.println(list2.get(k).getText());
		}
		select.selectByVisibleText("Chase");

	}

	@And("^user select store(.*)$")
	public void store_select(String Store) {
		select = new Select(driver.findElement(By.xpath("//select[contains(@name,'locStore')]")));
		List<WebElement> list = select.getOptions();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getText());

		select.selectByIndex(1);

	}

	@And("^user select date(.*)$")
	public void date(String date) throws Exception {
		driver.findElement(By.xpath("//input[contains(@class,'input-xlarge hasDatepicker')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[8]/table/tbody/tr[2]/td[4]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/form/div/div/div[1]/input[2]")).sendKeys("10:10");

		select = new Select(driver.findElement(By.xpath("//select[@name='storeTimeAMPM']")));
		List<WebElement> list = select.getOptions();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getText());

		select.selectByIndex(2);

		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		System.out.println(driver.getTitle());

	}

	@And("^user enter the message(.*)$")
	public void message(String message) {
		driver.findElement(By.xpath("//textarea[contains(@name,'comments')]")).sendKeys(Keys.SHIFT,
				"My Name is Sulman and i visit it was really good");

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Keys.SHIFT, "Sulman");
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("4431010101");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.SHIFT, "david1@gmail.com");
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println(driver.getTitle());
		
//		
//		Set<String> allwindows=driver.getWindowHandles();
//		Iterator<String> it= allwindows.iterator();
//		
//	 
//		String parent=it.next();
//		String child=it.next();
//		
//		
//		driver.switchTo().window(parent);
		
		
	}
	
	@And("^user go to hell$")
	public void go_to_hell(String hell) {
	}
	
	@After
	public void endbrowser() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
