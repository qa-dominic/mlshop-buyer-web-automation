package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class Shipping extends BaseTest {

     @Test(priority = 0, description = "Validate Login as User")
     public  void Login() throws Exception{
         loginSteps.login();
     }
//    @Test(priority = 1, dependsOnMethods = "Login",description = "To Validate Successful purchase of jewelry item when logged in using mlwallet")
//    public  void completePurchaseJewelery_toHistory() throws Exception{
//        shippingSteps.areItemsPresent_fromCart_toShipping();
//    }
//    @Test(priority = 1, dependsOnMethods = "Login",description = "To Validate Successful purchase of jewelry item when logged in using mlwallet")
//    public  void purchaseJewelry_mlWallet() throws Exception{
//        shippingSteps.purchaseJewelry_mlWallet();
//    }
//    @Test(priority = 1, description = "To Validate Successful purchase of jewelry item when logged in using mlwallet")
//    public  void purchaseJewelry_mlWallet_withoutLogin() throws Exception{
//        shippingSteps.purchaseJewelry_mlWallet_withoutLogin();
//    }
    @Test(priority = 1, dependsOnMethods = "Login",description = "Complete Purchase of Items using Paymongo GrabPay")
    public  void eWallet_grabPay() throws Exception{
    shippingSteps.eWallet_grabPay();
    }

}
