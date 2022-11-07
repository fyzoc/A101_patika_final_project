package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public  HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id ="myAccount")
    public WebElement myAccount;

    @FindBy(id ="login")
    public WebElement login;

    @FindBy(id ="txtUserName")
    public WebElement txtUserName;

    @FindBy(id ="btnLogin")
    public WebElement btnLogin;

    @FindBy(id ="txtPassword")
    public WebElement txtPassword;

    @FindBy(id ="btnEmailSelect")
    public WebElement btnEmailSelect;

    @FindBy(xpath="(//input[@type='text'])[1]")
    public WebElement searchTxt;

    @FindBy(xpath ="//div[@class='title-area']")
    public WebElement all_product;

    @FindBy(xpath ="(//*[text()='Stanley Klasik Trigger Action Seyahat Bardağı 0.47 LT'])[1]")
    public WebElement openFirstItem;

    @FindBy(xpath ="(//button[@data-bind='click: function() { return true;}, clickBubble: false'])[3]")
    public WebElement addToCartFirstItem;

    @FindBy(xpath ="//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement close_add_cart;

    @FindBy(xpath ="(//button[@data-bind='click: function() { return true;}, clickBubble: false'])[8]")
    public WebElement addToCartSecondItem;

    @FindBy(id="shoppingCart")
    public WebElement shoppingCart;

    @FindBy( xpath="(//input[@value='1'])[1]")
    public WebElement verifyFirstItem;

    @FindBy( xpath="(//input[@value='1'])[2]")
    public WebElement verifySecondItem;

}

