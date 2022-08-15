package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_SearchFunction extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    @Parameters({"search"})
    public void searchFunction(String search) {

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

        homePageElements.yourStoreButton.click();
        homePageElements.searchButton.sendKeys(search);
        homePageElements.clickSearchButton.click();


        for (int i = 0; i < homePageElements.searchResultItems.size(); i++){
            String ElementText = homePageElements.searchResultItems.get(i).getText().toLowerCase();
            Assert.assertTrue(ElementText.contains(search.toLowerCase()));
        }
    }


}
