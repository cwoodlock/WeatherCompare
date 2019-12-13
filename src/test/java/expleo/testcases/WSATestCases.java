package testcases;

// Author: Paul Byrne

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.WSAHomePO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

    public class WSATestCases {

        private WebDriver driver;
        private String baseUrl="";
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }


        @Test
        public void testNewLogin() throws Exception {

//        Initialize html web elements and pass in the driver and home page elements class
            WSAHomePO wsaHomePO = PageFactory.initElements(
                    driver, WSAHomePO.class);
            driver.get("http://www.weathersa.co.za/");

            //Interact with web elements by calling methods within the WSAHomePageObject class
            wsaHomePO.enterSearch("Durban");
            wsaHomePO.submitSearch();

//        Creates two array lists to store all min values and max values (tempetures)
            List<Integer> minNums = new ArrayList<Integer>();
            List<Integer> maxNums = new ArrayList<Integer>();

            //Iterate through the div elements to grab all tempetures within the webpage
            for(int i = 2; i < 7; i++){

                //Grab max and min temps by getting the text within the span elements and inject the iterator
                String maxTemp = driver.findElement(By.xpath("html/body/div[4]/div[3]/div/div[1]/div[2]/div[2]/div["+i+"]/p[2]/span[1]")).getText();
                String minTemp = driver.findElement(By.xpath("html/body/div[4]/div[3]/div/div[1]/div[2]/div[2]/div["+i+"]/p[2]/span[2]")).getText();

                //stripe special characters from the string: preparing them for parsing
                maxTemp = maxTemp.toString().replaceAll("[^0-9]", "");
                minTemp = minTemp.toString().replaceAll("[^0-9]", "");

                //parses the tempetures to integers
                int maxNum = Integer.parseInt(maxTemp);
                int minNum = Integer.parseInt(minTemp);

                //add tempetures to corresponding arraylists
                minNums.add(minNum);
                maxNums.add(maxNum);

            }

            System.out.println("min"+minNums);
            System.out.println("Max"+maxNums);

        }

        @After
        public void tearDown() throws Exception {
//        driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }
}
