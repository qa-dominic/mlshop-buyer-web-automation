package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class Home extends BaseTest {

     @Test(priority = 0, description = "Validate Login as User")
     public  void Login() throws Exception{
         loginSteps.login();
     }
    @Test(priority = 1, dependsOnMethods = "Login",description = "To Validate the \"Hi, <user first name>\" drop down menu options")
    public  void userDropDown_optionsValidation() throws Exception{
        homeSteps.userDropDown_optionsValidation();
    }
    @Test(priority = 2, dependsOnMethods = "Login",description = "To Validate profile page navigation from user drop down menu")
    public  void profileNavigation() throws Exception{
        homeSteps.profileNavigation();
    }
    @Test(priority = 3, dependsOnMethods = "Login",description = "o Validate purchase history page navigation from user drop down menu")
    public  void purchaseHistoryNavigation() throws Exception{
        homeSteps.purchaseHistoryNavigation();
    }
    @Test(priority = 4, dependsOnMethods = "Login", description = "To Validate logout functionality from user drop down menu")
    public  void logoutValidation() throws Exception{
        homeSteps.logoutValidation();
    }
    @Test(priority = 5, description = "To Validate jewelry type \"Ring\" will display all types of Ring jewelry")
    public  void filterRingTypes() throws Exception{
        homeSteps.filterRingTypes();
    }
    @Test(priority = 6, description = "To Validate jewelry type \"Necklace\" will display all types of Necklace jewelry")
    public  void filterNecklaceTypes() throws Exception{
        homeSteps.filterNecklaceTypes();
    }
    @Test(priority = 7, description = "To Validate jewelry type \"Bracelets\" will display all types of Bracelets jewelry")
    public  void filterBraceletTypes() throws Exception{
        homeSteps.filterBraceletTypes();
    }
    @Test(priority = 8, description = "To Validate jewelry type \"Earrings\" will display all types of Earrings jewelry")
    public  void filterEarringsTypes() throws Exception{
        homeSteps.filterEarringsTypes();
    }
    @Test(priority = 9, description = "To Validate jewelry type \"Pendant\" will display all types of Pendant jewelry")
    public  void filterPendantTypes() throws Exception{
        homeSteps.filterPendantTypes();
    }
    @Test(priority = 10, description = "To Validate jewelry type \"Brouch\" will display all types of Brouch jewelry")
    public  void filterBrouchTypes() throws Exception{
        homeSteps.filterBrouchTypes();
    }
    @Test(priority = 11, description = "To Validate jewelry type \"Engagement\" will display all types of Engagement jewelry")
    public  void filterEngagementTypes() throws Exception{
        homeSteps.filterEngagementTypes();
    }
    @Test(priority = 12, description = "To Validate product details in Jewelry tab home page")
    public  void viewProduct_jewelryDetails() throws Exception{
        homeSteps.viewProduct_jewelryDetails();
    }
    @Test(priority = 13, description = "To Validate product details in Amparito Collections tab home page")
    public  void viewProduct_amparitoDetails() throws Exception{
        homeSteps.viewProduct_amparitoDetails();
    }
    @Test(priority = 14, description = "To Validate product details in Watches tab home page")
    public  void viewProduct_watchDetails() throws Exception{
        homeSteps.viewProduct_watchDetails();
    }

}
