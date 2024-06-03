package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class Cart extends BaseTest {

//     @Test(priority = 0, description = "Validate Login as User")
//     public  void Login() throws Exception{
//         loginSteps.login();
//     }
    @Test(priority = 1, description = "To Validate successful add item modal pop to shopping cart from jewelry tab" +
            "To Validate Shopping Cart total number of products is incremented after adding an item to cart")
    public  void successModalPopUp() throws Exception{
        cartSteps.successModalPopUp();
    }
    @Test(priority = 2, description = "To Validate successful add item modal pop to shopping cart from amparito collections tab")
    public  void successModalPopUp_amparito() throws Exception{
        cartSteps.successModalPopUp_amparito();
    }
    @Test(priority = 3, description = "To Validate successful add item modal pop to shopping cart from watches tab")
    public  void successModalPopUp_watch() throws Exception{
        cartSteps.successModalPopUp_watch();
    }
    @Test(priority = 4, description = "To Validate \"this item is already in your cart\" modal by clicking add to cart button on product details page")
    public  void alreadyInCart_modalPopUp() throws Exception{
        cartSteps.alreadyInCart_modalPopUp();
    }

    @Test(priority = 5, description = "To Validate remove item in shopping cart page")
    public  void removeItem_cartPage() throws Exception{
        cartSteps.removeItem_cartPage();
    }
    @Test(priority = 6, description = "To Validate cancel button on 'remove item' modal will close the modal")
    public  void cancelRemoveItem() throws Exception{
        cartSteps.cancelRemoveItem();
    }
//    @Test(priority = 7, description = "To Validate uncheck functionality will  decrement the total \"item selected\" and subtotal")
//    public  void uncheckItems() throws Exception{
//        cartSteps.uncheckItems();
//    }
    @Test(priority = 8, description = "To Validate uncheck functionality will  decrement the total \"item selected\" and subtotal")
    public  void checkItems() throws Exception{
        cartSteps.checkItems();
    }
}

