package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_SubscribeTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    String expected = "Success: Your newsletter subscription has been successfully updated!";

    @Test
    public void subscribeTest() {


        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.eMailInput.sendKeys("selimcelep1903@gmail.com");
        loginPageElements.passwordInput.sendKeys("selimcelep15");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText,"My Account");

        myAccountPageElements.newsLetterButton.click();
        myAccountPageElements.subscribeYesRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());

        Assert.assertEquals(myAccountPageElements.successMessage.getText(),expected);

    }

    @Test
    public void unsubscribeTest(){

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.eMailInput.sendKeys("selimcelep1903@gmail.com");
        loginPageElements.passwordInput.sendKeys("selimcelep15");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText,"My Account");

        myAccountPageElements.newsLetterButton.click();
        myAccountPageElements.subscribeNoRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertEquals(myAccountPageElements.successMessage.getText(),expected);
    }
}
