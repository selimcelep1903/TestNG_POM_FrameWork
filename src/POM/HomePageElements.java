package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {

    public HomePageElements(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "a[title='My Account']")
    public WebElement myAccountButton ;

    @FindBy(xpath = "(//a[text()='Login'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Your Store']")
    public WebElement yourStoreButton;


    @FindBy(css = "input[name='search']")
    public WebElement searchButton ;

    @FindBy(css = "span[class='input-group-btn']")
    public WebElement clickSearchButton;

    @FindAll({@FindBy(xpath = "//h4")})
    public List<WebElement> searchResultItems;

}
