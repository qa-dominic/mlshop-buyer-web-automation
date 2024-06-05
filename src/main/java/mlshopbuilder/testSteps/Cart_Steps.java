package mlshopbuilder.testSteps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.List;

public class Cart_Steps extends Base_Steps{
   Shipping_Steps shippingSteps = new Shipping_Steps();
   Home_Steps homeSteps = new Home_Steps();
    public double computeTotal() {
        List<WebElement> itemPriceElements = cart_PageObjects.itemPrice();
        double[] itemPrices = new double[itemPriceElements.size()];

        for (int i = 0; i < ((List<?>) itemPriceElements).size(); i++) {
            WebElement priceElement = itemPriceElements.get(i);
            itemPrices[i] = shippingSteps.parsePesoAndConvertToDouble(priceElement);
        }
        double total = 0.0;
        for (double price : itemPrices) {
            total += price;
        }
        return total;
    }
    //MLS_TC_85, MLS_TC_92
    //To Validate successful add item modal pop to shopping cart from jewelry tab
    public void successModalPopUp(){
        homeSteps.clickProduct();
        int prevTotal = Integer.parseInt(getText(home_PageObjects.shoppingCartItemNumber()));
        homeSteps.addToCart();
        int currentTotal = Integer.parseInt(getText(home_PageObjects.shoppingCartItemNumber()));
        Assert.assertNotEquals(currentTotal, prevTotal);
        passTest("Products is incremented after adding an item to cart ", "");
    }
    //MLS_TC_86
    //To Validate successful add item modal pop to shopping cart from amparito collections tab
    public void successModalPopUp_amparito(){
        click(home_PageObjects.amparitoCollectionsTab(), "Amparito");
        homeSteps.clickProduct();
        homeSteps.addToCart();
    }
    //MLS_TC_87
    //To Validate successful add item modal pop to shopping cart from watches tab
    public void successModalPopUp_watch(){
        click(home_PageObjects.watchesTab(), "Watches");
        homeSteps.clickWatchProduct();
        homeSteps.addToCartWatch();
    }
    //MLS_TC_89
    //To Validate "this item is already in your cart" modal by clicking add to cart button on product details page
    public void alreadyInCart_modalPopUp(){
        click(home_PageObjects.jewelryTab(), "Jewelry");
        homeSteps.clickProduct();
        waitSleep(1800);
        click(cart_PageObjects.addToCart_btn(), "Add to Cart");
        isVisible(cart_PageObjects.itemAddedtoCart_msg(), getText(cart_PageObjects.itemAddedtoCart_msg()));
        if(getText(cart_PageObjects.itemAddedtoCart_msg()).contains("This item is already in your cart.")){
            passTest("This item is already in your cart.", "");
        }
    }

    //MLS_TC_93
    //To Validate remove item in shopping cart page
    public void removeItem_cartPage(){
        homeSteps.goToCart();
        int prevTotal = Integer.parseInt(getText(home_PageObjects.shoppingCartItemNumber()));
        for(WebElement deleteBtn : cart_PageObjects.delete_btn()){
            click(deleteBtn, "Delete Button");
            click(cart_PageObjects.yes_btn(), "Yes");
            waitSleep(2000);
            break;
        }
        try{
            int currentTotal = Integer.parseInt(getText(home_PageObjects.shoppingCartItemNumber()));
            Assert.assertNotEquals(currentTotal, prevTotal);
            passTest("Cart Numbers Decremented", "Previous total: " + prevTotal + "Current total: " + currentTotal);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.invisibilityOfAllElements(cart_PageObjects.delete_btn()));
//            passTest("Validate Element Not on Page", "Element not found as expected");
        }catch (NoSuchElementException e){
            passTest("Validate Element Not on Page", "Element not found as expected");
        }
    }

    //MLS_TC_95
    //To Validate cancel button on 'remove item' modal will close the modal
    public void cancelRemoveItem(){
        homeSteps.goToCart();
        for(WebElement deleteBtn : cart_PageObjects.delete_btn()){
            click(deleteBtn, "Delete Button");
            click(cart_PageObjects.cancel_btn(), "Cancel");
            isVisible(deleteBtn, "Delete Button");
            passTest("cancel button on 'remove item' modal will close the modal", "");
            break;
        }
    }
    //MLS_TC_96
    //To Validate uncheck functionality will  decrement the total "item selected" and subtotal
    public void uncheckItems(){
        homeSteps.goToCart();
        for(WebElement checkBoxes : cart_PageObjects.checkbox_cart()) {
            int prevTotal = Integer.parseInt(removeItemSelectedPrefix(getText(cart_PageObjects.itemSelected())));
            click(checkBoxes, "Check boxes");
            int currentTotal = Integer.parseInt(removeItemSelectedPrefix(getText(cart_PageObjects.itemSelected())));
            Assert.assertNotEquals(currentTotal, prevTotal);
            break;
        }
    }
    //MLS_TC_97
    //To Validate check functionality will  increment the total "item selected" and subtotal
    public void checkItems() {
        homeSteps.goToCart();
        List<WebElement> checkBoxes = cart_PageObjects.checkbox_cart();
        int prevTotal = Integer.parseInt(removeItemSelectedPrefix(getText(cart_PageObjects.itemSelected())));
        for (WebElement checkbox : checkBoxes) {
            click(checkbox, "Check boxes");
            waitSleep(1000);
            click(checkbox, "Check boxes");
        }
        int currentTotal = Integer.parseInt(removeItemSelectedPrefix(getText(cart_PageObjects.itemSelected())));
        waitSleep(2000);
        Assert.assertNotEquals(currentTotal, prevTotal);
    }

    private String removeItemSelectedPrefix(String value) {
        String prefix = "ITEM SELECTED : ";
        if (value.contains(prefix)) {
            return value.replace(prefix, "");
        }
        return value;
    }
}
