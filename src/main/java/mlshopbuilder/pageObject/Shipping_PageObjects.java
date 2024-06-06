package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Shipping_PageObjects {
    public WebElement mobileNumber_Field(){
        return getDriver().findElement(By.cssSelector("[name='mobileNo']"));
    }
    public WebElement province_dropDown(){
        return getDriver().findElement(By.xpath("(//select[@name='Province State'])[2]"));
    }
    public WebElement city_dropDown(){
        return getDriver().findElement(By.xpath("(//select[@name='City/State'])[2]"));
    }
    public WebElement branch_dropDown(){
        return getDriver().findElement(By.cssSelector("[name='Branch Name']"));
    }


    //payment options
    public WebElement mlwallet_radioButton(){
        return getDriver().findElement(By.cssSelector("[name='ML']"));
    }


    public WebElement placeOrder_Btn(){
        return getDriver().findElement(By.xpath("//button[contains(text(), 'Place Order')]"));
    }
    public WebElement proceed_Btn(){
        return getDriver().findElement(By.xpath("//button[contains(text(), 'Proceed')]"));
    }
    public WebElement close_Btn(){
        return getDriver().findElement(By.xpath("//button[contains(text(), 'Close')]"));
    }
    public List<WebElement> itemPrices(){
        return getDriver().findElements(By.xpath(" //tr[@class=\" border-b border-b-gray-500\"]/td[3]"));
    }

    //p[contains(text(), 'SubTotal Order')]/parent::div/following-sibling::div[2]/child::p
    //p[contains(text(), 'Service Fee')]/parent::div/following-sibling::div[2]/child::p
    //p[contains(text(), 'Shipping Fee')]/parent::div/following-sibling::div[2]/child::p



    public WebElement merchTotal_text(){
        return getDriver().findElement(By.xpath("//p[contains(text(), 'Merchandise Total')]/parent::div/following-sibling::div[2]/child::p"));
    }

    public WebElement serviceTotal_text(){
        return getDriver().findElement(By.xpath("//p[contains(text(), 'Service Total')]/parent::div/following-sibling::div[2]/child::p"));
    }

    public WebElement shippingTotal_text(){
        return getDriver().findElement(By.xpath("//p[contains(text(), 'Shipping Total')]/parent::div/following-sibling::div[2]/child::p"));
    }

    public WebElement totalPayment_text(){
        return getDriver().findElement(By.xpath("//p[contains(text(), 'Total Payment')]/parent::div/following-sibling::div[2]/child::p"));
    }
    public List <WebElement> productsOrdered(){
        return getDriver().findElements(By.xpath("//td[@class='flex flex-col px-2 py-4 ']/child::div/child::p"));
    }
}
