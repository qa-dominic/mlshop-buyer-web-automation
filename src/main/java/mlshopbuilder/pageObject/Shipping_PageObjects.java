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
    public WebElement ewallet_radioButton() {
        return getDriver().findElement(By.cssSelector("[value='E-WALLET']"));
    }
    public WebElement grabpay_radioButton() {
        return getDriver().findElement(By.cssSelector("[value='GRAB PAY']"));
    }
    public WebElement gcash_radioButton() {
        return getDriver().findElement(By.cssSelector("[value='GCASH']"));
    }
    public WebElement paymaya_radioButton() {
        return getDriver().findElement(By.cssSelector("[value='PAYMAYA']"));
    }
    public WebElement card_radioButton() {
        return getDriver().findElement(By.cssSelector("[value='CARD']"));
    }
    public WebElement directOnlineBanking_radioButton() {
        return getDriver().findElement(By.cssSelector("[value='DIRECT ONLINE BANKING']"));
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
    //paymongo
    //
    public WebElement merchantName() {
        return getDriver().findElement(By.cssSelector("[for=\"merchant-name\"]"));
    }
    public WebElement continueButton_paymongo() {
        return getDriver().findElement(By.cssSelector("[class='button full-width button--primary']"));
    }
    public WebElement backButton_paymongo() {
        return getDriver().findElement(By.cssSelector("[class='button full-width button--secondary']"));
    }
    public List <WebElement> itemName_paymongo() {
        return getDriver().findElements(By.xpath("//div[@class='name-container']/h4"));
    }
    public List <WebElement> itemPrice_paymongo() {
        return getDriver().findElements(By.xpath("//div[@class='price']/h4/span"));
    }
    public WebElement total_paymongo() {
        return getDriver().findElement(By.xpath("//div[@class='total']/child::h1/child::span"));
    }
    public WebElement privacyPolicy_checkBox() {
        return getDriver().findElement(By.cssSelector("[class='check-box']"));
    }
    public WebElement name_textBox() {
        return getDriver().findElement(By.id("name"));
    }
    public WebElement email_textBox() {
        return getDriver().findElement(By.id("email"));
    }
    public WebElement mobileNumber_textBox() {
        return getDriver().findElement(By.id("phone"));
    }
    public WebElement completePayment_button() {
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }
    public WebElement authorizeTest_button(){
        return getDriver().findElement(By.xpath("//div[@class='ActionButtons']/child::button[1]"));
    }
    public WebElement failTest_button(){
        return getDriver().findElement(By.xpath("//div[@class='ActionButtons']/child::button[2]"));
    }
    public WebElement cancelTest_button(){
        return getDriver().findElement(By.xpath("//div[@class='ActionButtons']/child::button[3]"));
    }
    public WebElement success_header() {
        return getDriver().findElement(By.cssSelector("[class='payment-success-header']"));
    }
    public WebElement returnMerchant_button() {
        return getDriver().findElement(By.cssSelector("[class='button button--primary']"));
    }
}
