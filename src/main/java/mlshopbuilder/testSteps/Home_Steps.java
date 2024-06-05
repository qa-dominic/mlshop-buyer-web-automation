package mlshopbuilder.testSteps;

import org.openqa.selenium.WebElement;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Home_Steps extends Base_Steps{

    //Method for clicking random products from home page
    private final String profile_url = "https://mlshoppreprod.mlhuillier.com/about";
    private final String purchase_url = "https://mlshoppreprod.mlhuillier.com/purchasehistory";
    private final String login_url = "https://mlshoppreprod.mlhuillier.com/authlogin";
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
    public void profileNavigation(){
        click(home_PageObjects.userIcon(), "User icon");
        click(home_PageObjects.profile_option(), "Profile");
        waitSleep(800);
        assertEqual(driver.getCurrentUrl(), profile_url);
        isVisible(home_PageObjects.fullName_textBox(), getText(home_PageObjects.fullName_textBox()));
        isVisible(home_PageObjects.email_textBox(), getText(home_PageObjects.email_textBox()));
        isVisible(home_PageObjects.mobileNum_textBox(), getText(home_PageObjects.mobileNum_textBox()));
        passTest("profileNavigation :: PASSED ", "");
    }
    //MLS_TC_27
    //To Validate purchase history page navigation from user drop down menu
    public void purchaseHistoryNavigation(){
        click(home_PageObjects.userIcon(), "User icon");
        click(home_PageObjects.purchaseHistory_option(), "purchaseHistory_option");
        waitSleep(800);
        assertEqual(driver.getCurrentUrl(), purchase_url);
        int limiter =0;
        for (WebElement orderId : home_PageObjects.orderId()){
            LoggingUtils.info("ORDER ID:" + orderId.getText());
            limiter++;
            if(limiter >= 10){
                break;
            }
        }
        passTest("purchaseHistoryNavigation", "");
    }
    //MLS_TC_28
    //To Validate logout functionality from user drop down menu
    public void logoutValidation(){
        click(home_PageObjects.userIcon(), "User icon");
        click(home_PageObjects.logout_option(), "logout_option");
        click(home_PageObjects.userIcon(), "User icon");
        assertEqual(driver.getCurrentUrl(), login_url);
        passTest("logoutValidation","");
    }
    public void userDropDown_optionsValidation(){
        isVisible(home_PageObjects.userIcon(), getText(home_PageObjects.userIcon()));
        click(home_PageObjects.userIcon(), "User icon");
        isVisible(home_PageObjects.profile_option(), getText(home_PageObjects.profile_option()));
        isVisible(home_PageObjects.purchaseHistory_option(), getText(home_PageObjects.purchaseHistory_option()));
        isVisible(home_PageObjects.logout_option(), getText(home_PageObjects.logout_option()));
        passTest("userDropDown_optionsValidation","");
    }

    //MLS_TC_29
    //To Validate jewelry type "All Types" will display all types of jewelry
    public void filterAllTypes(){
        click(home_PageObjects.allTypes(), "All types filter");

    }
    //MLS_TC_30
    //To Validate jewelry type "Ring" will display all types of jewelry
    public void filterRingTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.ringType(), "Ring types filter");
        boolean isFound = false;
        waitSleep(1000);
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("ring")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterRingTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filterNecklaceTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.necklaceType(), "Ring types filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("necklace")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterNecklaceTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filterBraceletTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.braceletsType(), "Bracelet types filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("bracelet")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterBraceletTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filterEarringsTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.earringsType(), "Earring types filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("earrings")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterEarringsTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filterPendantTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.pendantType(), "Pendant types filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("pendant")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterPendantTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filterBrouchTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.brouchType(), "Brouch types filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("brouch")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterBrouchTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filterEngagementTypes(){
        click(home_PageObjects.allTypes(), "All types filter");
        click(home_PageObjects.engagementType(), "Engagement types filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().toLowerCase().contains("engagement")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }else{
                failTest("No Items to Filter","");
            }
            if(isFound){
                passTest("filterEngagementTypes", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_37
    //To Validate gold karat type "all gold karats" will display all gold karat types

    //MLS_TC_38
    //To Validate gold karat type "14k" will display 14 gold karat types

    //MLS_TC_39
    //To Validate gold karat type "18" will display 18 gold karat types

    //MLS_TC_40
    //To Validate jewelry type "All Gold Colors" will display all gold color jewelries

    //MLS_TC_41
    //To Validate jewelry type "Yellow Gold" will display yellow gold jewelries

    //MLS_TC_42
    //To Validate jewelry type "White Gold" will display white gold jewelries

    //MLS_TC_43
    //To Validate jewelry type "Rose Gold" will display rose gold jewelries

    //MLS_TC_44
    //To Validate jewelry type "Two - Tone" will display two-tone jewelries

    //MLS_TC_45
    //To Validate jewelry type "Tri- Tone" will display tri-tone jewelries

    //MLS_TC_79
    //To Validate product details in Jewelry tab home page
    public void viewProduct_jewelryDetails(){
        click(home_PageObjects.jewelryTab(), "Jewelry");
        clickProduct();
        waitSleep(800);
        for(WebElement specs : cart_PageObjects.itemSpecs()){
            LoggingUtils.info("SPECIFICATION: "+specs.getText());
            ExtentReporter.logInfo("SPECIFICATION: "+specs.getText(), "");
        }
        isVisible(cart_PageObjects.itemName_p(), getItemName());
        isVisible(cart_PageObjects.itemPrice_p(), getItemPrice());
        isVisible(cart_PageObjects.addToCart_btn(), "Add to Cart");
        passTest("viewProduct_jewelryDetails", "");

    }
    //MLS_TC_80
    //To Validate product details in Amparito Collections tab home page
    public void viewProduct_amparitoDetails(){
        click(home_PageObjects.amparitoCollectionsTab(), "Amparito");
        clickProduct();
        waitSleep(800);
        for(WebElement specs : cart_PageObjects.itemSpecs()){
            LoggingUtils.info("SPECIFICATION: "+specs.getText());
            ExtentReporter.logInfo("SPECIFICATION: "+specs.getText(), "");
        }
        isVisible(cart_PageObjects.itemName_p(), getItemName());
        isVisible(cart_PageObjects.itemPrice_p(), getItemPrice());
        isVisible(cart_PageObjects.addToCart_btn(), "Add to Cart");
        passTest("viewProduct_amparitoDetails", "");
    }
    //MLS_TC_81
    //To Validate product details in Watches tab home page
    public void viewProduct_watchDetails(){
        click(home_PageObjects.watchesTab(), "Watches");
        clickWatchProduct();
        waitSleep(800);
        for(WebElement specs : cart_PageObjects.itemSpecs()){
            LoggingUtils.info("SPECIFICATION: "+specs.getText());
            ExtentReporter.logInfo("SPECIFICATION: "+specs.getText(), "");
        }
        isVisible(cart_PageObjects.itemName_p(), getItemName());
        isVisible(cart_PageObjects.itemPrice_p(), getItemPrice());
        isVisible(cart_PageObjects.addToCartWatch_btn(), "Add to Cart");
        passTest("viewProduct_watchDetails", "");

    }
}
