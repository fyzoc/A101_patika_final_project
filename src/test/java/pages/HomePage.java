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
    public WebElement giris_yap;

    @FindBy(id ="login")
    public WebElement giris;

    @FindBy(id ="txtUserName")
    public WebElement txtUserName;

    @FindBy(id ="btnLogin")
    public WebElement buttonGiris;

    @FindBy(id ="txtPassword")
    public WebElement txtPassword;

    @FindBy(id ="btnEmailSelect")
    public WebElement btnEmailSelect;

    @FindBy(xpath="(//input[@type='text'])[1]")
    public WebElement searchTxt;

    @FindBy(xpath ="//div[@class='title-area']")
    public WebElement all_product;

    @FindBy(xpath ="(//div[@data-test-id='carousel-grid-item'])[1]")
    public WebElement birinciUrunAc;

    @FindBy(xpath ="(//button[@data-bind='click: function() { return true;}, clickBubble: false'])[3]")
    public WebElement sepeteEkle_1;

    @FindBy(xpath ="//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement close_add_cart;

    @FindBy(xpath ="(//button[@data-bind='click: function() { return true;}, clickBubble: false'])[8]")
    public WebElement ikinciUrunSepeteEkle;

    @FindBy(id="shoppingCart")
    public WebElement sepetim;

    @FindBy( xpath="(//input[@value='1'])[1]")
    public WebElement ürünDogrulama1;

    @FindBy( xpath="(//input[@value='1'])[2]")
    public WebElement ürünDogrulama2;

}

