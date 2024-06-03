package mlshopbuilder.testSteps;


import org.openqa.selenium.WebElement;

public class Shipping_Steps extends Base_Steps{
    private final String purhcaseHistoryUrl = "https://mlshoppreprod.mlhuillier.com/purchasehistory";
    Home_Steps homeSteps = new Home_Steps();
    Login_Steps loginSteps = new Login_Steps();
    //MLS_TC_127
    //To Validate Successful purchase of jewelry item when logged in using mlwallet
    public void purchaseJewelry_mlWallet(){
        homeSteps.clickProduct();
        homeSteps.addToCart();
        homeSteps.goToCart();
        waitSleep(1800);
        click(cart_PageObjects.checkOut_btn(), "Checkout");
        waitSleep(2000);
        selectByVisibleText(shippingPageObjects.province_dropDown(), "Cebu");
        selectByVisibleText(shippingPageObjects.city_dropDown(), "CEBU CITY");
        selectByVisibleText(shippingPageObjects.branch_dropDown(), "ML NRA");
        scrollToElement(shippingPageObjects.placeOrder_Btn());
        click(shippingPageObjects.mlwallet_radioButton(), "MLWALLET Option");
        assertEqual(removePeso(getText(shippingPageObjects.totalPayment_text())), String.valueOf(computeTotal()));
        click(shippingPageObjects.placeOrder_Btn(), "Place Order");
        click(shippingPageObjects.proceed_Btn(), "Proceed");
        waitSleep(1800);
        isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()));
        loginSteps.inputOTP();
        waitSleep(5000);
        assertEqual(driver.getCurrentUrl(), purhcaseHistoryUrl);
    }
    //MLS_TC_110
    public double computeTotal() {
        double merchTotal = parsePesoAndConvertToDouble(shippingPageObjects.merchTotal_text());
        double serviceTotal = parsePesoAndConvertToDouble(shippingPageObjects.serviceTotal_text());
        double shippingTotal = parsePesoAndConvertToDouble(shippingPageObjects.shippingTotal_text());
        return merchTotal + serviceTotal + shippingTotal;
    }

    public double parsePesoAndConvertToDouble(WebElement element) {
        String text = element.getText();
        return Double.parseDouble(removePeso(text));
    }

    public String removePeso(String value) {
        return value.replace("₱", "");
    }
}
