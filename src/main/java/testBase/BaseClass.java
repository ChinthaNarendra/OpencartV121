package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return tdriver.get();
	}

	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master", "Datadriven" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");

		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		String env = p.getProperty("execution_env").trim();

		System.out.println("Execution Environment : " + env);
		System.out.println("OS : " + os);
		System.out.println("Browser : " + br);

		// REMOTE EXECUTION
		if (env.equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			switch (br.toLowerCase()) {

			case "chrome":
				capabilities.setBrowserName("chrome");
				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;

			case "firefox":
				capabilities.setBrowserName("firefox");
				break;

			default:
				throw new RuntimeException("Invalid Browser : " + br);
			}

			tdriver.set(new RemoteWebDriver(new URL(p.getProperty("gridUrl")), capabilities));
		}

		// LOCAL EXECUTION
		else if (env.equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {

			case "chrome":
				tdriver.set(new ChromeDriver());
				break;

			case "edge":
				tdriver.set(new EdgeDriver());
				break;

			case "firefox":
				tdriver.set(new FirefoxDriver());
				break;

			default:
				throw new RuntimeException("Invalid Browser : " + br);
			}
		}

		if (getDriver() == null) {
			throw new RuntimeException("Driver initialization failed");
		}

		// Maximize only for local execution
		if (env.equalsIgnoreCase("local")) {
			getDriver().manage().window().maximize();
		}

		getDriver().manage().deleteAllCookies();

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		getDriver().get(p.getProperty("appUrl1").trim());
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master", "Datadriven" })
	public void teardown() {

		if (getDriver() != null) {
			getDriver().quit();
			tdriver.remove();
		}
	}

	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String randomAlphaNumeric() {
		return RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomNumeric(10);
	}

	public static String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) getDriver();

		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		File targetFile = new File(targetFilePath);

		FileUtils.copyFile(sourceFile, targetFile);

		return targetFilePath;
	}
}