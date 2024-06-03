package mlshopbuilder.testSteps;

import org.openqa.selenium.WebElement;

public class Home_Steps extends Base_Steps{

    //Method for clicking random products from home page
    public void clickProduct(){ 
        for(WebElement products : home_PageObjects.itemNames()){
            click(products, products.getText());
            break;
        }
    }

    public void clickWatchProduct(){
        waitSleep(2000);
        for(WebElement products : home_PageObjects.watchNames()){
            click(products, products.getText());
            break;
        }
    }

    public void addToCart(){
        waitSleep(1800);
        click(cart_PageObjects.addToCart_btn(), "Add to Cart");
        isVisible(cart_PageObjects.itemAddedtoCart_msg(), getText(cart_PageObjects.itemAddedtoCart_msg()));
        click(cart_PageObjects.confirm_btn(), "Confirm");
    }
    public void addToCartWatch(){
        waitSleep(1800);
        click(cart_PageObjects.addToCartWatch_btn(), "Add to Cart");
        isVisible(cart_PageObjects.itemAddedtoCart_msg(), getText(cart_PageObjects.itemAddedtoCart_msg()));
        click(cart_PageObjects.confirm_btn(), "Confirm");
    }

    public void goToCart(){
        waitSleep(1800);
        click(home_PageObjects.shoppingCartIcon(), "Cart icon");

    }

    public int getCartNumbers(){
        return Integer.parseInt(getText(home_PageObjects.shoppingCartItemNumber()));
    }

    public String getItemPrice(){
        return cart_PageObjects.itemPrice_p().getText();
    }
    public String getItemName(){
        return cart_PageObjects.itemName_p().getText();
    }

    
    //MLS_TC_25
    //To Validate the "Hi, <user first name>" drop down menu options

    //MLS_TC_26
    //To Validate profile page navigation from user drop down menu

    //MLS_TC_27
    //To Validate purchase history page navigation from user drop down menu

    //MLS_TC_28
    //To Validate logout functionality from user drop down menu

    //MLS_TC_29
    //To Validate jewelry type "All Types" will display all types of jewelry

    //MLS_TC_30
    //To Validate jewelry type "Ring" will display all types of jewelry

    //MLS_TC_79
    //To Validate product details in Jewelry tab home page

    //MLS_TC_80
    //To Validate product details in Amparito Collections tab home page

    //MLS_TC_81
    //To Validate product details in Watches tab home page
}
