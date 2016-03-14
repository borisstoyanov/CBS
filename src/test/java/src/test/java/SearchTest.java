package src.test.java;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	public static WebDriver driver;
	public static String baseUrl;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.200.31:7001/";
	}

	private static void ourTest() throws InterruptedException {
		driver.get(baseUrl
				+ "/LoansLoanSimulationApp-LoansLoanSimulationView-context-root/faces/homepage.jsf;jsessionid=KJRbMu42EEMFZAHEegbkGvLcyeHvgK1MSoylLLi5pSVG2kA69pPZ!-1572647200");
		// -- Homepage --
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Create New Loan".equals(driver.findElement(By.cssSelector("span.x16v")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("pt1:r2:0:simulations::disAcr")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("New Simulation".equals(driver.findElement(By.cssSelector("span.x16v")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("pt1:r2:0:sbfSim:it5::content")).clear();
		driver.findElement(By.id("pt1:r2:0:sbfSim:it5::content")).sendKeys("4053338");
		driver.findElement(By.cssSelector("span.xgi")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (!isElementPresent(By.xpath("//div[@id='pt1:r2:0:t5::db']/table/tbody/tr[2]/td[2]/span")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.cssSelector("a.x158")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Modification".equals(driver.findElement(By.xpath("//div/table/tbody/tr[2]/td[2]")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//div/table/tbody/tr[2]/td[2]")).click();
		// -- Customer Details --
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Type of Loan".equals(driver.findElement(By.cssSelector("h1.xdm.")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Loan Characteristics")).click();
		// -- Loan Characteristics --
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("General Information".equals(driver.findElement(By.cssSelector("h1.xdm.")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Releases")).click();
		// -- Releases --
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Releases Planification".equals(driver.findElement(By.cssSelector("h1.xdm.")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//div[@id='pt1:r2:3:pt1:pt_b2']/a/span")).click();
		// -- Amortization Calculation --
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Repayment Plan".equals(driver.findElement(By.cssSelector("h1.xdm.")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.cssSelector("span.xgi")).click();
		driver.findElement(By.linkText("Finish")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("New Simulation".equals(driver.findElement(By.cssSelector("span.x16v")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		assertEquals(driver.findElement(By.xpath("//div[@id='pt1:r2:0:t5::db']/table/tbody/tr/td[4]/span")).getText(),
				"DURAND MARCEL");

	}

	@Test(groups = { "Sanity" })
	public void test1() throws Exception {
		SearchTest.ourTest();
	}

	@Test(groups = { "Sanity" })
	public void test2() throws Exception {
		SearchTest.ourTest();

	}

	@Test(groups = { "Sanity" })
	public void test3() throws Exception {
		SearchTest.ourTest();

	}

	@Test(groups = { "Sanity" })
	public void test4() throws Exception {
		SearchTest.ourTest();

	}

	@Test(groups = { "Sanity" })
	public void test5() throws Exception {
		SearchTest.ourTest();

	}

	@Test(groups = { "Sanity" })
	public void test6() throws Exception {
		SearchTest.ourTest();

	}

	@Test(groups = { "Sanity" })
	public void test7() throws Exception {
		SearchTest.ourTest();

	}

	@Test(groups = { "Sanity" })
	public void test8() throws Exception {
		SearchTest.ourTest();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
