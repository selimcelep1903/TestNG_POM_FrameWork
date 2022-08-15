package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EditAccountTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    String expected = "Success: Your account has been successfully updated.";

    @Test
    public void editAcountTest(){

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

        myAccountPageElements.editMyAccountButton.click();

        myAccountPageElements.changeIdInput.clear();
        myAccountPageElements.changeIdInput.sendKeys("selim");

        myAccountPageElements.changePasswordInput.clear();
        myAccountPageElements.changePasswordInput.sendKeys("kamil");

        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.succesMessageForEditing.getText(),expected);


    }
}
