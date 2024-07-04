package mlshopbuilder.testSteps;


import org.openqa.selenium.WebElement;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Shipping_Steps extends Base_Steps{
    private final String purhcaseHistoryUrl = "https://mlshoppreprod.mlhuillier.com/purchasehistory";
    Home_Steps homeSteps = new Home_Steps();
    Login_Steps loginSteps = new Login_Steps();
    //MLS_TC_127
    //To Validate Successful purchase of jewelry item when logged in using mlwallet
    public void purchaseJewelry_mlWallet(){
        selectProductAndCheckOut();
        selectPickUpBranch();
        scrollToElement(shippingPageObjects.placeOrder_Btn());
        click(shippingPageObjects.mlwallet_radioButton(), "MLWALLET Option");
        assertEqual(parsePesoAndConvertToDouble(shippingPageObjects.totalPayment_text()), computeTotal(), 0.01);
        click(shippingPageObjects.placeOrder_Btn(), "Place Order");
        click(shippingPageObjects.proceed_Btn(), "Proceed");
        waitSleep(1800);
        isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()));
        loginSteps.inputOTP();
        waitSleep(5000);
        click(loginPageObjects.okay_Btn(), getText(loginPageObjects.okay_Btn()));
        assertEqual(driver.getCurrentUrl(), purhcaseHistoryUrl);
    }
    //MLS_TC_110
    //To Validate correct computation of total payment
    public double computeTotal() {
        double merchTotal = parsePesoAndConvertToDouble(shippingPageObjects.merchTotal_text());
        double serviceTotal = parsePesoAndConvertToDouble(shippingPageObjects.serviceTotal_text());
        double shippingTotal = parsePesoAndConvertToDouble(shippingPageObjects.shippingTotal_text());
        return merchTotal + serviceTotal + shippingTotal;
    }
    public void selectPickUpBranch(){
//        scrollToElement(shippingPageObjects.province_dropDown());
        selectByVisibleText(shippingPageObjects.province_dropDown(), "CEBU");
        selectByVisibleText(shippingPageObjects.city_dropDown(), "CEBU CITY");
        selectByVisibleText(shippingPageObjects.branch_dropDown(), "MLTG QA");
//        selectByIndex(shippingPageObjects.branch_dropDown(), 7);
    }
    public void selectProductAndCheckOut(){
        homeSteps.clickProduct();
        homeSteps.addToCart();
        homeSteps.goToCart();
        waitSleep(1800);
        click(cart_PageObjects.checkOut_btn(), "Checkout");
        waitSleep(2000);
    }
    public double parsePesoAndConvertToDouble(WebElement element) {
        String text = element.getText();
        return Double.parseDouble(removePeso(removeCommas(text)));
    }

    public String removePeso(String value) {
        return value.replace("₱", "");
    }
    public String removeCommas(String input) {return input.replace(",", "");}

    //MLS_TC_101
    //To Validate account information mobile number field fetches kyc information
    public void purchaseJewelry_mlWallet_withoutLogin(){
        selectProductAndCheckOut();
        type(shippingPageObjects.mobileNumber_Field(), "Mobile Number Field", reader.getRandomUser());
        waitSleep(2000);
        selectPickUpBranch();
        scrollToElement(shippingPageObjects.placeOrder_Btn());
        click(shippingPageObjects.mlwallet_radioButton(), "MLWALLET Option");
        assertEqual(parsePesoAndConvertToDouble(shippingPageObjects.totalPayment_text()), computeTotal(), 0.01);
        click(shippingPageObjects.placeOrder_Btn(), "Place Order");
        click(shippingPageObjects.proceed_Btn(), "Proceed");
        waitSleep(1800);
        isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()));
        loginSteps.inputOTP();
        waitSleep(5000);
        assertEqual(driver.getCurrentUrl(), purhcaseHistoryUrl);
    }
    //MLS_TC_99 To Validate shipping details jewelry items are present in shipping details page and is under mlshop jewelry store
    public void areItemsPresent_fromCart_toShipping(){
        homeSteps.clickProduct();
        homeSteps.addToCart();
        homeSteps.goToCart();
        List<String> cartItems = new ArrayList<>();
        List<String> shippingItems = new ArrayList<>();
        List<String> purchasedItems = new ArrayList<>();
        waitSleep(1800);
        for(WebElement itemName : cart_PageObjects.items_cart()){
            cartItems.add(itemName.getText());
        }
        click(cart_PageObjects.checkOut_btn(), "Checkout");
        waitSleep(2000);
        for(WebElement itemName_shipping : shippingPageObjects.productsOrdered()){
            shippingItems.add(itemName_shipping.getText());
        }
        //compare cartItems and shippingItems, shippingItems should contains cartItems strings
        if(new HashSet<>(shippingItems).containsAll(cartItems)){
            for(String items: shippingItems){
                ExtentReporter.logInfo("Items in Shipping Page: "+items,"");
                LoggingUtils.info("Items in Shipping Page: "+items);
            }
            for(String items: cartItems){
                ExtentReporter.logInfo("Items in Cart Page: "+items,"");
                LoggingUtils.info("Items in Cart Page: "+items);
            }
            passTest("ITEMS IN CART ARE IN SHIPPING DETAILS PAGE", "");
        }else{
            failTest("NOT ALL ITEMS FROM THE CART ARE PRESENT", "");
        }
        selectPickUpBranch();
        scrollToElement(shippingPageObjects.placeOrder_Btn());
        waitSleep(1800);
        click(shippingPageObjects.mlwallet_radioButton(), "MLWALLET Option");
        double currentTotal = parsePesoAndConvertToDouble(shippingPageObjects.totalPayment_text());
        assertEqual(currentTotal, computeTotal(), 0.01);
        click(shippingPageObjects.placeOrder_Btn(), "Place Order");
        click(shippingPageObjects.proceed_Btn(), "Proceed");
        waitSleep(1800);
        isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()));
        loginSteps.inputOTP();
        waitSleep(5000);
        click(loginPageObjects.okay_Btn(), getText(loginPageObjects.okay_Btn()));

        //Purchase History
        assertEqual(driver.getCurrentUrl(), purhcaseHistoryUrl);
        for(WebElement purchasedItems_element : home_PageObjects.productNames()){
            purchasedItems.add(purchasedItems_element.getText());
        }
        if(new HashSet<>(purchasedItems).containsAll(shippingItems)) {
            assertEqual(parsePesoAndConvertToDouble(home_PageObjects.firstOrderTotal()),currentTotal,0.01);
            //compare double data type into List Double data type
            passTest("PURCHASED ITEMS ARE PRESENT IN PURCHASE HISTORY", "");
        }
        //Order Details

    }
    //MLS_TC_102
    //To Validate branch section label "branch address:" matches the selected address dropdown value

    //MLS_TC_114
    //To Validate successful purchase using e-wallet "grab pay" as payment method
    public void eWallet_paymentMethod(String ewallet_option){
        waitSleep(500);
        click(home_PageObjects.watchesTab(), "Watches Tab");
        homeSteps.clickWatchProduct();
        homeSteps.addToCartWatch();
        homeSteps.goToCart();
        List<String> cartItems = new ArrayList<>();
        List<String> shippingItems = new ArrayList<>();
        List<String> purchasedItems = new ArrayList<>();
        List<String> inHistoryItems = new ArrayList<>();
        waitSleep(1800);
        for(WebElement itemName : cart_PageObjects.items_cart()){
            cartItems.add(itemName.getText());
        }
        click(cart_PageObjects.checkOut_btn(), "Checkout");
        waitSleep(2000);
        for(WebElement itemName_shipping : shippingPageObjects.productsOrdered()){
            shippingItems.add(itemName_shipping.getText());
        }
        //compare cartItems and shippingItems, shippingItems should contains cartItems strings
        if(new HashSet<>(shippingItems).containsAll(cartItems)){
            for(String items: shippingItems){
                ExtentReporter.logInfo("Items in Shipping Page: "+items,"");
                LoggingUtils.info("Items in Shipping Page: "+items);
            }
            for(String items: cartItems){
                ExtentReporter.logInfo("Items in Cart Page: "+items,"");
                LoggingUtils.info("Items in Cart Page: "+items);
            }
            passTest("ITEMS IN CART ARE IN SHIPPING DETAILS PAGE", "");
        }else{
            failTest("NOT ALL ITEMS FROM THE CART ARE PRESENT", "");
        }
        selectPickUpBranch();
        scrollToElement(shippingPageObjects.placeOrder_Btn());
        //eWallet option
        click(shippingPageObjects.ewallet_radioButton(), "eWallet Option");
        waitSleep(1500);
        if(ewallet_option.equals("grab")){
            click(shippingPageObjects.grabpay_radioButton(), "Grab radio button");
        }
        else if (ewallet_option.equals("gcash")) {
            click(shippingPageObjects.gcash_radioButton(), "Gcash radio button");
        }
        else if (ewallet_option.equals("paymaya")) {
            click(shippingPageObjects.paymaya_radioButton(), "Paymaya radio button");
        }else{
            failTest("Invalid Payment Option", ewallet_option);
        }
        waitSleep(800);
        double currentTotal = parsePesoAndConvertToDouble(shippingPageObjects.totalPayment_text());
        assertEqual(currentTotal, computeTotal(), 0.01);
        click(shippingPageObjects.placeOrder_Btn(), "Place Order");
        click(shippingPageObjects.proceed_Btn(), "Proceed");
        waitSleep(1800);
        isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()));
        loginSteps.inputOTP();
        //paymongo
        waitSleep(8000);
        switchToNextTab();
        waitSleep(5000);
        LoggingUtils.info(getWebDriver().getCurrentUrl());
        LoggingUtils.info(getWebDriver().getTitle());
        assertEqual(getWebDriver().getTitle(), "PayMongo Checkout");
        isVisible(shippingPageObjects.merchantName(), shippingPageObjects.merchantName().getText());
        double paymongoTotal = parsePesoAndConvertToDouble(shippingPageObjects.total_paymongo());
        assertEqual(paymongoTotal, currentTotal, 0.1);
        for(WebElement items : shippingPageObjects.itemName_paymongo()){
            purchasedItems.add(items.getText());
        }
        for (String items : purchasedItems){
            ExtentReporter.logInfo("Items in Paymongo Page: "+items,"");
            LoggingUtils.info("Items in Paymongo Page: "+items);
        }
        click(shippingPageObjects.continueButton_paymongo(), "Continue button on Paymongo portal");
        waitSleep(1800);
        click(shippingPageObjects.privacyPolicy_checkBox(), "Paymongo's Privacy Policy checkbox");
        waitSleep(1200);
        click(shippingPageObjects.completePayment_button(), "Complete payment button");
        waitSleep(1200);
        click(shippingPageObjects.authorizeTest_button(), "Authorize Test Payment button");
        waitSleep(1200);
        isVisible(shippingPageObjects.success_header(), "Success Header");
        waitSleep(1200);
        click(shippingPageObjects.returnMerchant_button(), "Return to merchant");

        //back to shop
        switchToPreviousTab();
        waitSleep(1200);
        scrollToElement(home_PageObjects.userIcon());
        click(home_PageObjects.userIcon(), home_PageObjects.userIcon().getText());
        click(home_PageObjects.purchaseHistory_option(), home_PageObjects.purchaseHistory_option().getText());
        waitSleep(1200);
        assertEqual(driver.getCurrentUrl(), purhcaseHistoryUrl);
        int ctr=0;
        waitSleep(2500);
        for(WebElement items : home_PageObjects.productNames()){
            inHistoryItems.add(items.getText());
        }
        for (String items : inHistoryItems){
            ExtentReporter.logInfo("Items in Purchase History Page: "+items,"");
            LoggingUtils.info("Items in Purchase History Page: "+items);
            ctr++;
            if(ctr >= 10){
                break;
            }
        }     
    }
    //MLS_TC_115
    //To Validate successful purchase using e-wallet "gcash" as payment method
    public void eWallet_gCash(){

    }
    //MLS_TC_116
    //To Validate successful purchase using e-wallet "paymaya" as payment method
    public void eWallet_paymaya(){

    }
    //MLS_TC_117
    //To Validate successful purhcase using visa/mastercard as payment method

    //MLS_TC_118
    //To Validate successful purhcase using direct online banking as payment method

    //MLS_TC_131
    //To Validate if total payment will correctly reflect for gcash payment method from shipping details page to paymongo portal payment page

}
