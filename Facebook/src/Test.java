import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test extends Parent {
	public static void main(String[] args) throws Exception {

		Scanner up = new Scanner(System.in);

		System.out.println("Enter user name: ");
		username = up.next();
		System.out.println("Enter Password: ");
		String password = up.next();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		System.setProperty("webdriver.chrome.driver", "/Users/suryateja/Desktop/Time Sheet/Facebook/chromedriver");

		WebDriver chrome = new ChromeDriver();

		System.out.println("Browswer opened");
		chrome.get("https://www.facebook.com/");
		System.out.print("Logging into facebook");
		chrome.manage().window().maximize();
		System.out.print(".");
		Thread.sleep(2000);
		System.out.print(".");

		chrome.switchTo().activeElement().sendKeys(username);
		chrome.findElement(By.id("pass")).sendKeys(password);

		chrome.findElement(By.id("u_0_b")).click();
		Thread.sleep(2000);
		System.out.print(".");
		System.out.println("");
		Thread.sleep(2000);
		System.out.println("Success");

		stopWatch.stop();
		long time = stopWatch.getNanoTime();

		long calTime = (time - 8000000 * 1000) / 1000000000;

		if (calTime > 20) {
			System.out.println("Your internet speed is slow, script paused\n"
					+ "Will resume once all elements on the Webpage gets loaded");
			s = 1;

		}
		if (s == 1) {
			System.out.println("Script Resumed");
		}

		for (int j = 0;; j++) {
			System.out.println("What to check?");

			System.out.println("\n\tNote: Press 1 --> Notifications\n\t      Press 2 --> Messages");

			int ext = up.nextInt();

			if (ext == 1) {
				System.out.print("Reading notifications");
				chrome.findElement(By.xpath("//div[@aria-label='Notifications'][@tabindex='0']")).click();

				Thread.sleep(1000);
				for (int i = 0; i < 9; i++) {
					System.out.print(".");
					Thread.sleep(1000);
				}
				Thread.sleep(1000);
				System.out.println("");
				chrome.findElement(By.xpath("//div[@aria-haspopup='menu'][@aria-label='Notification Actions']"))
						.click();
				Thread.sleep(2000);
				chrome.findElement(By.xpath(
						"//*[@id=\"mount_0_0\"]/div/div/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div"))
						.click();
				Thread.sleep(2000);
				chrome.findElement(By.xpath("//div[@aria-label='Notifications'][@tabindex='0']")).click();

				System.out.println("Done");

			} else {
				System.out.print("Reading messages");

				chrome.findElement(
						By.xpath("//*[@id=\"mount_0_0\"]/div/div/div[1]/div[2]/div[4]/div[1]/div[2]/span/div/div[1]"))
						.click();
				Thread.sleep(1000);
				for (int i = 0; i < 9; i++) {
					System.out.print(".");
					Thread.sleep(1000);
				}
				Thread.sleep(1000);
				System.out.println("");
				chrome.findElement(
						By.xpath("//*[@id=\"mount_0_0\"]/div/div/div[1]/div[2]/div[4]/div[1]/div[2]/span/div/div[1]"))
						.click();

				System.out.println("Done");
			}

			System.out.println("Do you wanna check anything else?");
			System.out.println("\tNote: Press y --> if yes\n\t      Press n --> if no");

			if (up.next().equals("n")) {

				String name = chrome
						.findElement(
								By.xpath("//*[@id=\"mount_0_0\"]/div/div/div[1]/div[2]/div[4]/div[1]/div[4]/a/span"))
						.getText();

				System.out.println("ok, " + name + " is logging off");
				break;
			}
		}

		chrome.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div/div[1]/div[2]/div[4]/div[1]/span/div/div[1]"))
				.click();
		Thread.sleep(2000);
		System.out.println("Successfully logged out");

		chrome.findElement(By.xpath(
				"//*[@id=\"mount_0_0\"]/div/div/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div[1]/div[3]/div/div[5]/div/div[1]/div[2]/div/div/div/div/span"))
				.click();
		System.out.println("Browser Closed");

		chrome.quit();

	}
}
