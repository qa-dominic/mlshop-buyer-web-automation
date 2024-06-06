package mlshopbuilder.testSteps;

import org.openqa.selenium.WebElement;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Home_Steps extends Base_Steps{

    //Method for clicking random products from home page
    private final String profile_url = "https://mlshoppreprod.mlhuillier.com/about";
    private final String purchase_url = "https://mlshoppreprod.mlhuillier.com/purchasehistory";
    private final String login_url = "https://mlshoppreprod.mlhuillier.com/authlogin";
    private final String[] Karat = {"10k", "12k", "14k", "18k", "20k", "21k", "22k"};
    private final String[] goldColors = {"Yellow Gold", "White Gold", "Rose Gold", "Two - Tone", "Tri - Tone"};
    private final String[] genders = {"Ladies", "Mens", "Unisex"};
    private final String[] sortBy = {"High to Low", "Low to High", "Newest to Oldest", "Oldest to Newest"};
    private final String[] Brands = {"Rolex", "Omega", "Tag Heuer", "Seiko", "Casio", "Hamilton", "Audemar Piquet"};
    private final String[] Movements = {"Automatic", "Quartz", "Hybrid", "Others"};
    private final String[] materials = {"10k", "14k", "18k", "Silver", "Stainless Steel", "Ceramic / Polymer", "Gold"};
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
        waitSleep(1500);
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
        waitSleep(1500);
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
        waitSleep(1500);
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
        waitSleep(1500);
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
        waitSleep(1500);
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
        waitSleep(1500);
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
    public void filterAllGoldKarats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.allGoldKarats(), "All Gold filter");
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains("gold")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterAllGoldKarats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_38
    //To Validate gold karat type "10k" will display 14 gold karat types
    public void filter10Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[0]), Karat[0] + " filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[0])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter10Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_39
    //To Validate gold karat type "18" will display 18 gold karat types
    public void filter12Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[1]), Karat[1] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[1])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter12Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filter14Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[2]), Karat[2] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[2])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter14Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filter18Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[3]), Karat[3] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[3])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter18Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filter20Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[4]), Karat[4] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[4])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter20Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filter21Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[5]), Karat[5] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[5])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter21Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    public void filter22Karats(){
        click(home_PageObjects.allGoldKarats(), "All Gold Karats filter");
        click(home_PageObjects.goldKarat(Karat[6]), Karat[6] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains(Karat[6])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filter21Karats", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_40
    //To Validate jewelry type "All Gold Colors" will display all gold color jewelries
    public void filterAllGoldColors(){
        click(home_PageObjects.allGoldColors(), "All Gold Colors filter");
        click(home_PageObjects.allGoldColors(),  "All Gold Colors filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().toLowerCase().contains("gold")){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterAllGoldColors", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_41
    //To Validate jewelry type "Yellow Gold" will display yellow gold jewelries
    public void filterYellowGold(){
        click(home_PageObjects.allGoldColors(), "All Gold Karats filter");
        click(home_PageObjects.goldColors(goldColors[0]), goldColors[0] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().contains(goldColors[0])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterYellowGold", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_42
    //To Validate jewelry type "White Gold" will display white gold jewelries
    public void filterWhiteGold(){
        click(home_PageObjects.allGoldColors(), "All Gold Colors filter");
        click(home_PageObjects.goldColors(goldColors[1]), goldColors[1] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().contains(goldColors[1])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterWhiteGold", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_43
    //To Validate jewelry type "Rose Gold" will display rose gold jewelries
    public void filterRoseGold(){
        click(home_PageObjects.allGoldColors(), "All Gold Colors filter");
        click(home_PageObjects.goldColors(goldColors[2]), goldColors[2] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().contains(goldColors[2])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterRoseGold", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_44
    //To Validate jewelry type "Two - Tone" will display two-tone jewelries
    public void filterTwoTone(){
        click(home_PageObjects.allGoldColors(), "All Gold Colors filter");
        click(home_PageObjects.goldColors(goldColors[3]), goldColors[3] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().contains(goldColors[3])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterTwoTone", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_45
    //To Validate jewelry type "Tri- Tone" will display tri-tone jewelries
    public void filterTriTone(){
        click(home_PageObjects.allGoldColors(), "All Gold Colors filter");
        click(home_PageObjects.goldColors(goldColors[3]), goldColors[3] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            if(item.getText().contains(goldColors[3])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterTriTone", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_46 To Validate jewelry type by "All Genders" filter will display all genders jewelries
    public void filterAllGenders(){
        click(home_PageObjects.allGenders(), "All Gold Colors filter");
        click(home_PageObjects.allGenders(), home_PageObjects.allGenders().getText());
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
        }
    }
    //MLS_TC_47 To Validate jewelry type by "Ladies" filter will display ladies jewelries
    public void filterLadies(){
        click(home_PageObjects.allGenders(), home_PageObjects.allGenders().getText());
        click(home_PageObjects.gender(genders[0]), genders[0] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().contains(genders[0])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterLadies", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_48 To Validate jewelry type by "Mens" filter will display mens jewelries
    public void filterMens(){
        click(home_PageObjects.allGenders(), home_PageObjects.allGenders().getText());
        click(home_PageObjects.gender(genders[1]), genders[1] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().contains(genders[1])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterMens", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_49 To Validate jewelry type by "Unisex" filter will display unisex jewelries
    public void filterUnisex(){
        click(home_PageObjects.allGenders(), home_PageObjects.allGenders().getText());
        click(home_PageObjects.gender(genders[2]), genders[2] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemNames()){
            if(item.getText().contains(genders[2])){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
            if(isFound){
                passTest("filterUnisex", "");
                break;
            }else{
                failTest("No Items to Filter","");
            }
        }
    }
    //MLS_TC_50 To Validate jewelry type by price "High to Low" will filter high to low
    public void filterHighToLow(){
        click(home_PageObjects.sortBy(), home_PageObjects.sortBy().getText());
        click(home_PageObjects.sortPrice(sortBy[0]), sortBy[0] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
                LoggingUtils.info("Item Name: "+item.getText());
                isFound = true;
            }
    }
    //MLS_TC_51 To Validate jewelry type by price "Low to High" will filter low to high
    public void filterLowToHigh(){
        click(home_PageObjects.sortBy(), home_PageObjects.sortBy().getText());
        click(home_PageObjects.sortPrice(sortBy[1]), sortBy[1] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            LoggingUtils.info("Item Name: "+item.getText());
            isFound = true;
        }
    }
    //MLS_TC_52 To Validate jewelry type by price "Newest to Oldest" will filter newest to oldest
    public void filterNewestToOldest(){
        click(home_PageObjects.sortBy(), home_PageObjects.sortBy().getText());
        click(home_PageObjects.sortPrice(sortBy[2]), sortBy[2] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            LoggingUtils.info("Item Name: "+item.getText());
            isFound = true;
        }
    }
    //MLS_TC_53 To Validate jewelry type by price "Oldest to Newest" will filter oldest to newest
    public void filterOldestToNewest(){
        click(home_PageObjects.sortBy(), home_PageObjects.sortBy().getText());
        click(home_PageObjects.sortPrice(sortBy[3]), sortBy[3] +" filter");
        waitSleep(1500);
        boolean isFound = false;
        for(WebElement item : home_PageObjects.itemDescriptions()){
            LoggingUtils.info("Item Name: "+item.getText());
            isFound = true;
        }
    }

    //MLS_TC_57 To Validate Brand Filter function "All brands" will display all types of brand
    //MLS_TC_58 To Validate Brand Filter function "Rolex" will display rolex watch
    //MLS_TC_59 To Validate Brand Filter function "Omega" will display Omega watch


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
