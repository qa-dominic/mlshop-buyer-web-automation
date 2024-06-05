package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

import java.util.List;

public class Home_PageObjects {
  
    public WebElement userIcon() {
        return getDriver().findElement(By.cssSelector("[class='px-[10px] cursor-pointer 2sm:hidden 3sm:hidden relative']"));
    }
    public WebElement shoppingCartItemNumber() {
        return getDriver().findElement(By.xpath("(//a[@href='/cart'])[1]/child::p"));
    }
    public WebElement shoppingCartIcon() {
        return getDriver().findElement(By.xpath("(//a[@href='/cart'])[1]"));
    }
    public WebElement watchesTab() {
        return getDriver().findElement(By.xpath("(//p[contains(text(),'Watches')])[1]"));
    }
    public WebElement jewelryTab() {
        return getDriver().findElement(By.xpath("(//p[contains(text(),'Jewelry')])[1]"));
    }
    public WebElement amparitoCollectionsTab() {
        return getDriver().findElement(By.xpath("(//p[contains(text(),'Amparito')])[1]"));
    }

    public List<WebElement> itemNames(){
        return getDriver().findElements(By.cssSelector("[class=' text-md text-[#444444]  text-center truncate overflow-hidden font-bold 2sm:text-[12px]']"));
    }
    public List<WebElement> itemDescriptions(){
        return getDriver().findElements(By.cssSelector("[class=' text-[#444444] text-xs text-center 2sm:text-[9px] truncate overflow-hidden']"));
    }
    public List<WebElement> itemPrices(){
        return getDriver().findElements(By.cssSelector("[class=' text-[#444444] text-xs text-center 2sm:text-[9px] truncate overflow-hidden']"));
    }
   //

    public List<WebElement> watchNames(){
        return getDriver().findElements(By.cssSelector("[class='text-md text-[#444444]  text-center truncate overflow-hidden font-bold 2sm:text-[12px]']"));
    }
    public WebElement profile_option(){
        return getDriver().findElement(By.xpath("//p[contains(text(),'Profile')]"));
    }
    public WebElement purchaseHistory_option(){
        return getDriver().findElement(By.xpath("//p[contains(text(),'Purchase History')]"));
    }
    public WebElement logout_option(){
        return getDriver().findElement(By.xpath("//p[contains(text(),'Logout')]"));
    }


    //profile
    public WebElement fullName_textBox(){
        return getDriver().findElement(By.xpath("//h3[contains(text(),'Full Name')]/following-sibling::p"));
    }
    public WebElement email_textBox(){
        return getDriver().findElement(By.xpath("//h3[contains(text(),'Email')]/following-sibling::p"));
    }
    public WebElement mobileNum_textBox(){
        return getDriver().findElement(By.xpath("//h3[contains(text(),'Mobile')]/following-sibling::p"));
    }

    //purchase history
    public List <WebElement> orderId(){
        return getDriver().findElements(By.xpath("//div[contains(text(),'Order No:')]/child::span[1]"));
    }
    public List <WebElement> paymentMethod(){
        return getDriver().findElements(By.xpath("//div[contains(text(),'Order No:')]/child::span[5]"));
    }
    public List <WebElement> orderStatus(){
        return getDriver().findElements(By.cssSelector("[class='text-red-600 font-semibold']"));
    }
    public List <WebElement> orderTotal(){
        return getDriver().findElements(By.xpath("//div[contains(text(),'Order Total')]/child::span"));
    }
    public List <WebElement> shopStore(){
        return getDriver().findElements(By.cssSelector("[class='ml-2 text-base font-semibold']"));
    }
    public List <WebElement> orderDetails_btn(){
        return getDriver().findElements(By.xpath("//button[contains(text(),'Order Details')]"));
    }


    //Filter



    public WebElement allTypes(){
        return getDriver().findElement(By.cssSelector("[title='All Types']"));
    }
    public WebElement ringType(){
        return getDriver().findElement(By.cssSelector("[title='Ring']"));
    }

    public WebElement necklaceType(){
        return getDriver().findElement(By.cssSelector("[title='Necklace']"));
    }
    public WebElement braceletsType(){
        return getDriver().findElement(By.cssSelector("[title='Bracelets']"));
    }
    public WebElement earringsType(){
        return getDriver().findElement(By.cssSelector("[title='Earrings']"));
    }
    public WebElement pendantType(){
        return getDriver().findElement(By.cssSelector("[title='Pendant']"));
    }
    public WebElement setsType(){
        return getDriver().findElement(By.cssSelector("[title='Sets']"));
    }
    public WebElement brouchType(){
        return getDriver().findElement(By.cssSelector("[title='Brouch']"));
    }
    public WebElement engagementType(){
        return getDriver().findElement(By.cssSelector("[title='Engagement']"));
    }
}
