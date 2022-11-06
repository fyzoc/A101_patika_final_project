package tests;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.Iterator;
import java.util.Set;
import static utilities.Driver.driver;

public class UyeGiris {
    Logger logger = (Logger) LogManager.getLogger(UyeGiris.class);
    @Test
    public void HepsiBuradaKullanıcıGiris() throws InterruptedException {
        //1.Kullanıcı Hepsiburada.com sitesini ziyaret eder.sayfanın acıldıgını dogrular.
        HomePage homePage = new HomePage();
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.hepsiburada.com/");
        logger.info("Sayfanın açıldıgı dogrulandı");
        //Kullanıcı giriş işlemi yapılır.
        homePage.giris_yap.click();
        homePage.giris.click();
        homePage.txtUserName.sendKeys("testfeytest@gmail.com");
        logger.info("Kullanıcı maili girildi");
        homePage.buttonGiris.click();
        homePage.txtPassword.sendKeys("qd*QRk*@PWh3j9g");
        logger.info("Kullanıcı sifresi girildi");
        homePage.btnEmailSelect.click();
        //Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
        Thread.sleep(4000);
        Assert.assertTrue(driver.getTitle().contains("Hepsi"));
        logger.info("Kullanıcının üye girisi sayfasında oldugu dogrulandı");
        Thread.sleep(2000);
        //Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        homePage.searchTxt.sendKeys("termos bardak", Keys.ENTER);
        logger.info("Kullanıcı arama sayfasına istedigi ürünü yazar ve ürün ekrana gelir");
        //Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        Thread.sleep(2000);
        jsexecutor.executeScript("arguments[0].click()", homePage.birinciUrunAc);
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
        System.out.println(driver.getTitle());
        logger.info("Kullanıcı istedigi ürünün sayfasına yönlendirilir");
        //Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        jsexecutor.executeScript("arguments[0].click()", homePage.all_product);
        jsexecutor.executeScript("arguments[0].click()", homePage.sepeteEkle_1);
        logger.info("Kullanıcının istedigi ürün birinci satıcıdan sepete eklenir");
        Thread.sleep(3000);
        jsexecutor.executeScript("arguments[0].click()", homePage.close_add_cart);
        Thread.sleep(4000);
        jsexecutor.executeScript("arguments[0].click()", homePage.ikinciUrunSepeteEkle);
        Thread.sleep(2000);
        logger.info("Kullanıcının istedigi ürün ikinci bir satıcıdan sepete eklenir");
        //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        jsexecutor.executeScript("arguments[0].click()", homePage.sepetim);
        Assert.assertTrue(homePage.ürünDogrulama1.isDisplayed());
        logger.info("Kullanıcının, birinci satıcıdan ekledigi ürünün sepette oldugu dogrulanır");
        Assert.assertTrue(homePage.ürünDogrulama2.isDisplayed());
        logger.info("Kullanıcının, ikini satıcıdan ekledigi ürünün sepette oldugu dogrulanır");
        Driver.closeDriver();
        logger.info("Test sonlandırılır");
    }
}

