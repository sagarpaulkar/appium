package QA.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowseBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	
	public void ConfigureAppium() throws MalformedURLException {
	// Android driver
	// Appium code -> Appium Server -mobile
	service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Sagar Paulkar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
			service.start();
	
	UiAutomator2Options options= new UiAutomator2Options();
	options.setDeviceName("Sagar");
	options.setChromedriverExecutable("C:\\Users\\Sagar Paulkar\\Downloads\\chromedriver_win32 (2)");
	options.setCapability("browserName", "Chrome");
	
	  driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
	
