package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Cart_PageObjects {

    //View item Objects
    public WebElement itemName_p(){
        return getDriver().findElement(By.cssSelector("[class=' text-2xl text-[#555555] uppercase font-bold']"));
    }
    public WebElement itemPrice_p(){
        return getDriver().findElement(By.cssSelector("[class=' text-[#333333] text-[24px] md:text-[24px] sm:text-[24px] 2sm:text-[24px] 3sm:text-[24px] font-bold md:flex-col sm:flex-col 2sm:flex-col 3sm:flex-col']"));
    }
    public List <WebElement> itemSpecs(){
        return getDriver().findElements(By.xpath("//div[@class=' flex flex-1 px-5 ']/child::p"));
    }
    public WebElement addToCart_btn(){
        return getDriver().findElement(By.cssSelector("[class=' bg-[#845f00] px-5 py-1  flex mt-2 rounded-lg hover:bg-gray-300 text-[#FFFFFF] place-items-center justify-center font-medium lg:w-[175px] md:w-[175px] sm:w-[175px] 2sm:w-full 3sm:w-full']"));
    }
    public WebElement addToCartWatch_btn(){
        return getDriver().findElement(By.cssSelector("[class=' bg-[#303030] px-5 py-1  flex mt-2 rounded-lg hover:bg-gray-300 text-[#FFFFFF] place-items-center justify-center font-medium lg:w-[130px] 2sm:w-full 3sm:w-full']"));
    }
    //
    public WebElement confirm_btn(){
        return getDriver().findElement(By.cssSelector("[class='mr-0 py-[15px] px-[30px] 2sm:px-[20px] 3sm:px-[20px] font-[900] text-[20px] 2sm:text-[16px] 3sm:text-[16px] text-white w-[150px] 2sm:w-[100px] 3sm:w-[100px]  flex justify-center rounded-md']"));
    }
    public WebElement itemAddedtoCart_msg(){
        return getDriver().findElement(By.xpath("//p[@class='text-center']"));
    }
    public List<WebElement> itemPrice(){
        return getDriver().findElements(By.cssSelector("[class=' px-5 inline-flex items-center 2sm:-mt-6']"));
    }

    public WebElement subTotal(){
        return getDriver().findElement(By.xpath("//p[contains(text(), 'subtotal')]/following-sibling::p"));
    }



    //Shopping Cart Objects
    public WebElement checkOut_btn(){
        return getDriver().findElement(By.cssSelector("[type='button']"));
    }
    public List <WebElement> delete_btn(){
        return getDriver().findElements(By.cssSelector("[class='flex justify-center focus:outline-none text-white bg-[#845f00] hover:bg-red-900 focus:ring-4 focus:ring-red-300 font-medium rounded-[20px] text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900 self-baseline w-auto 3sms:w-[100%] 2sms:w-[100%] san:rounded-[20px] sm:self-center 3sm:self-center 2sm:self-center san:self-center']"));
    }
    public WebElement yes_btn(){
        return getDriver().findElement(By.xpath("//button[contains(text(),'Yes')]"));
    }
    public WebElement cancel_btn(){
        return getDriver().findElement(By.xpath("//button[contains(text(),'Cancel')]"));
    }
    public List <WebElement> checkbox_cart(){
        return getDriver().findElements(By.cssSelector("[type='checkbox']"));
    }
    public WebElement itemSelected(){
        return getDriver().findElement(By.xpath("//p[contains(text(),'Item Selected : ')]"));
    }

}