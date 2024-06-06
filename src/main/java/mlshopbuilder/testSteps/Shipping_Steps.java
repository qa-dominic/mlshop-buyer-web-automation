package mlshopbuilder.testSteps;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        selectByVisibleText(shippingPageObjects.province_dropDown(), "Cebu");
        selectByVisibleText(shippingPageObjects.city_dropDown(), "CEBU CITY");
        selectByVisibleText(shippingPageObjects.branch_dropDown(), "ML NRA");
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

    //MLS_TC_102
    //To Validate branch section label "branch address:" matches the selected address dropdown value

    //MLS_TC_114
    //To Validate successful purchase using e-wallet "grab pay" as payment method

    //MLS_TC_115
    //To Validate successful purchase using e-wallet "gcash" as payment method

    //MLS_TC_116
    //To Validate successful purchase using e-wallet "paymaya" as payment method

    //MLS_TC_117
    //To Validate successful purhcase using visa/mastercard as payment method

    //MLS_TC_118
    //To Validate successful purhcase using direct online banking as payment method

    //MLS_TC_131
    //To Validate if total payment will correctly reflect for gcash payment method from shipping details page to paymongo portal payment page

}
