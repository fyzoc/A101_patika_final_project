package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.Iterator;
import java.util.Set;
import static utilities.Driver.driver;
public class UyeGirisSiz {
    Logger logger = (Logger) LogManager.getLogger(UyeGirisSiz.class);
    @Test
    public void HepsiBuradaGiris() throws InterruptedException {
        //Kullanıcı Hepsiburada.com sitesini ziyaret eder.
        HomePage homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));
        Assert.assertTrue(driver.getTitle().contains("Hepsi"));
        System.out.println(driver.getTitle());
        logger.info("Kullanıcının giris sayfasında oldugu dogrulanır");
        //Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        Thread.sleep(2000);
        homePage.searchTxt.sendKeys("termos bardak", Keys.ENTER);
        logger.info("Kullanıcı arama sayfasına istedigi ürünü yazar ve ürün ekrana gelir");
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
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
        Thread.sleep(3000);
        jsexecutor.executeScript("arguments[0].click()", homePage.ikinciUrunSepeteEkle);
        Thread.sleep(2000);
        logger.info("Kullanıcının istedigi ürün ikinci satıcıdan sepete eklenir");
        //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        Thread.sleep(2000);
        jsexecutor.executeScript("arguments[0].click()", homePage.sepetim);
        Assert.assertTrue(homePage.ürünDogrulama1.isDisplayed());
        logger.info("Kullanıcının, birinci satıcıdan ekledigi ürünün sepette olduğu dogrulanır");
        Assert.assertTrue(homePage.ürünDogrulama2.isDisplayed());
        logger.info("Kullanıcının, ikinci satıcıdan ekledigi ürünün sepette olduğu dogrulanır");
        Driver.closeDriver();
        logger.info("Test sonlandırılır");
    }
}
