package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class Home extends BaseTest {

//     @Test(priority = 0, description = "Validate Login as User")
//     public  void Login() throws Exception{
//         loginSteps.login();
//     }
//    @Test(priority = 1, dependsOnMethods = "Login",description = "To Validate the \"Hi, <user first name>\" drop down menu options")
//    public  void userDropDown_optionsValidation() throws Exception{
//        homeSteps.userDropDown_optionsValidation();
//    }
//    @Test(priority = 2, dependsOnMethods = "Login",description = "To Validate profile page navigation from user drop down menu")
//    public  void profileNavigation() throws Exception{
//        homeSteps.profileNavigation();
//    }
//    @Test(priority = 3, dependsOnMethods = "Login",description = "o Validate purchase history page navigation from user drop down menu")
//    public  void purchaseHistoryNavigation() throws Exception{
//        homeSteps.purchaseHistoryNavigation();
//    }
//    @Test(priority = 4, dependsOnMethods = "Login", description = "To Validate logout functionality from user drop down menu")
//    public  void logoutValidation() throws Exception{
//        homeSteps.logoutValidation();
//    }
//    @Test(priority = 5, description = "To Validate jewelry type \"Ring\" will display all types of Ring jewelry")
//    public  void filterRingTypes() throws Exception{
//        homeSteps.filterRingTypes();
//    }
//    @Test(priority = 6, description = "To Validate jewelry type \"Necklace\" will display all types of Necklace jewelry")
//    public  void filterNecklaceTypes() throws Exception{
//        homeSteps.filterNecklaceTypes();
//    }
//    @Test(priority = 7, description = "To Validate jewelry type \"Bracelets\" will display all types of Bracelets jewelry")
//    public  void filterBraceletTypes() throws Exception{
//        homeSteps.filterBraceletTypes();
//    }
//    @Test(priority = 8, description = "To Validate jewelry type \"Earrings\" will display all types of Earrings jewelry")
//    public  void filterEarringsTypes() throws Exception{
//        homeSteps.filterEarringsTypes();
//    }
//    @Test(priority = 9, description = "To Validate jewelry type \"Pendant\" will display all types of Pendant jewelry")
//    public  void filterPendantTypes() throws Exception{
//        homeSteps.filterPendantTypes();
//    }
//    @Test(priority = 10, description = "To Validate jewelry type \"Brouch\" will display all types of Brouch jewelry")
//    public  void filterBrouchTypes() throws Exception{
//        homeSteps.filterBrouchTypes();
//    }
//    @Test(priority = 11, description = "To Validate jewelry type \"Engagement\" will display all types of Engagement jewelry")
//    public  void filterEngagementTypes() throws Exception{
//        homeSteps.filterEngagementTypes();
//    }
//    @Test(priority = 12, description = "To Validate product details in Jewelry tab home page")
//    public  void viewProduct_jewelryDetails() throws Exception{
//        homeSteps.viewProduct_jewelryDetails();
//    }
//    @Test(priority = 13, description = "To Validate product details in Amparito Collections tab home page")
//    public  void viewProduct_amparitoDetails() throws Exception{
//        homeSteps.viewProduct_amparitoDetails();
//    }
//    @Test(priority = 14, description = "To Validate product details in Watches tab home page")
//    public  void viewProduct_watchDetails() throws Exception{
//        homeSteps.viewProduct_watchDetails();
//    }
//    @Test(priority = 15, description = "To Validate gold karat type \"10k\" will display 10 gold karat types")
//    public  void filter10Karats() throws Exception{
//        homeSteps.filter10Karats();
//    }
//    @Test(priority = 16, description = "To Validate gold karat type \"12k\" will display 12 gold karat types")
//    public  void filter12Karats() throws Exception{
//        homeSteps.filter12Karats();
//    }
//    @Test(priority = 17, description = "To Validate gold karat type \"14k\" will display 12 gold karat types")
//    public  void filter14Karats() throws Exception{
//        homeSteps.filter14Karats();
//    }
//    @Test(priority = 18, description = "To Validate gold karat type \"18k\" will display 12 gold karat types")
//    public  void filter18Karats() throws Exception{
//        homeSteps.filter18Karats();
//    }
//    @Test(priority = 19, description = "To Validate gold karat type \"20k\" will display 12 gold karat types")
//    public  void filter20Karats() throws Exception{
//        homeSteps.filter20Karats();
//    }
//    @Test(priority = 20, description = "To Validate gold karat type \"21k\" will display 12 gold karat types")
//    public  void filter21Karats() throws Exception{
//        homeSteps.filter21Karats();
//    }
//    @Test(priority = 21, description = "To Validate gold karat type \"22k\" will display 12 gold karat types")
//    public  void filter22Karats() throws Exception{
//        homeSteps.filter22Karats();
//    }
//    @Test(priority = 22, description = "To Validate jewelry type \"All Gold Colors\" will display all gold color jewelriess")
//    public  void filterAllGoldColors() throws Exception{
//        homeSteps.filterAllGoldColors();
//    }
//    @Test(priority = 23, description = "To Validate jewelry type \"Yellow Gold\" will display yellow gold jewelries")
//    public  void filterYellowGold() throws Exception{
//        homeSteps.filterYellowGold();
//    }
//    @Test(priority = 24, description = "To Validate jewelry type \"Yellow Gold\" will display yellow gold jewelries")
//    public  void filterWhiteGold() throws Exception{
//        homeSteps.filterWhiteGold();
//    }
//    @Test(priority = 25, description = "To Validate jewelry type \"Yellow Gold\" will display yellow gold jewelries")
//    public  void filterRoseGold() throws Exception{
//        homeSteps.filterRoseGold();
//    }
//    @Test(priority = 26, description = "To Validate jewelry type \"Yellow Gold\" will display yellow gold jewelries")
//    public  void filterTwoTone() throws Exception{
//        homeSteps.filterTwoTone();
//    }
//    @Test(priority = 27, description = "To Validate jewelry type \"Yellow Gold\" will display yellow gold jewelries")
//    public  void filterTriTone() throws Exception{
//        homeSteps.filterTriTone();
//    }
    @Test(priority = 28, description = "To Validate jewelry type by \"All Genders\" filter will display all genders jewelries")
    public  void filterAllGenders() throws Exception{
        homeSteps.filterAllGenders();
    }
    @Test(priority = 29, description = "To Validate jewelry type by \"Ladies\" filter will display all genders jewelries")
    public  void filterLadies() throws Exception{
        homeSteps.filterLadies();
    }
    @Test(priority = 30, description = "To Validate jewelry type by \"Mens\" filter will display all genders jewelries")
    public  void filterMens() throws Exception{
        homeSteps.filterMens();
    }
    @Test(priority = 31, description = "To Validate jewelry type by \"Unisex\" filter will display all genders jewelries")
    public  void filterUnisex() throws Exception{
        homeSteps.filterUnisex();
    }
    @Test(priority = 32, description = "To Validate jewelry type by price \"High to Low\" will filter high to low")
    public  void filterHighToLow() throws Exception{
        homeSteps.filterHighToLow();
    }
    @Test(priority = 33, description = "To Validate jewelry type by price \"Low to High\" will filter low to high")
    public  void filterLowToHigh() throws Exception{
        homeSteps.filterLowToHigh();
    }
    @Test(priority = 33, description = "To Validate jewelry type by price \"Newest to Oldest\" will filter newest to oldest")
    public  void filterNewestToOldest() throws Exception{
        homeSteps.filterNewestToOldest();
    }
    @Test(priority = 34, description = "To Validate jewelry type by price \"Oldest to Newest\" will filter oldest to newest")
    public  void filterOldestToNewest() throws Exception{
        homeSteps.filterOldestToNewest();
    }
}
