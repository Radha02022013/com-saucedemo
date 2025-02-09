import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */


public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;
    public static void main(String[] args) {
        //using Scanner Declaration
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter broswer name : ");
        String browser = scanner.nextLine();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else{
            System.out.println("Wrong Browser name");
        }
        //Open the Url
        driver.get(baseUrl);
        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Print the title of the page.
        System.out.println("The title of the page : " + driver.getTitle());
        // Print the current url.
        System.out.println("The current Url : " + driver.getCurrentUrl());
        //Print the page source.
        System.out.println("The Source : " + driver.getPageSource());
        //  Enter the email to email field.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter the password to password field.
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on Login Button.
        driver.findElement(By.id("login-button")).click();
        //Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        //Navigate to baseUrl
        driver.navigate().to(baseUrl);
        //Refresh the page.
        driver.navigate().refresh();
        //close the browser
        driver.quit();



    }
}
