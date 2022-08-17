package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _06_ContactUsFunction extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    @Parameters("contactUs")
    public void contactUsFunctionTest(String contactUs) {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.eMailInput.sendKeys("selimcelep1903@gmail.com");
        loginPageElements.passwordInput.sendKeys("selimcelep15");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");

        homePageElements.contactUsButton.click();
        homePageElements.enquiryPlace.sendKeys(contactUs);
        homePageElements.submitButton.click();

        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("success"));
    }
}