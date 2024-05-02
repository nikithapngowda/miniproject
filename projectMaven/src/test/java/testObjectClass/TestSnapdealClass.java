package testObjectClass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import snapdealProject.DriverSetup;
import snapdealProject.SnapdealHomePage;
import snapdealProject.SnapdealSearchPage;

public class TestSnapdealClass {
	
	public static WebDriver driver;	
	
	public static DriverSetup driversetup;	
	SnapdealHomePage objHomePage;
	SnapdealSearchPage objSearchPage;
	
	//Configuration of the WebDriver
	public  void driverconfig(String browser)
    {
	 	//Instantiate driver 
    	driver=DriverSetup.driverInstantiate(browser);   
    }
	
	//Testing the Functionality of Snapdeal Home Page
	public void test_HomePage() {
        objHomePage=new SnapdealHomePage(driver);
		objHomePage.setSearchBox("Bluetooth headphone");
		objHomePage.clickSearchBtn();
	
	}
	//Testing the Functionality of Snapdeal Search Page
	public void test_searchPage() throws IOException, InterruptedException {
		objSearchPage=new SnapdealSearchPage(driver);
		objSearchPage.setSortBy();
		objSearchPage.setSortByListItem();
		objSearchPage.setPriceRange();
		objSearchPage.setGo();
		Thread.sleep(5000);
		objSearchPage.setPrintNameAndPrice();
		objSearchPage.closeWebsite();
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String browser="Chrome";
		driversetup=new DriverSetup();
		TestSnapdealClass testsnapdealclass=new TestSnapdealClass();
		testsnapdealclass.driverconfig(browser);
		testsnapdealclass.test_HomePage();
		testsnapdealclass.test_searchPage();
	
	}
	

}


