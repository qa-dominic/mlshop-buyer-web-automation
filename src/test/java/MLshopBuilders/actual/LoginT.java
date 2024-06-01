package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    // @Test(priority = 0, description = "Validate Login as User")
    // public  void Login() throws Exception{
    //     loginSteps.login();
    // }
    @Test(priority = 1, description = "To validate the error message prompt for an empty mobile number field on the login page.")
    public  void emptyMobileNumber_field() throws Exception{
        loginSteps.emptyMobileNumber_field();
    }
    @Test(priority = 2, description = "To Validate One time pin prompt display on login page")
    public  void otpPrompt() throws Exception{
        loginSteps.otpPrompt();
    }
    @Test(priority = 3, description = "To validate the login functionality using an unregistered phone number")
    public  void loginUnRegisteredMobileNumber() throws Exception{
        loginSteps.otpPrompt();
    }
    @Test(priority = 4, description = "To Validate proceed button in the \"account not found\" modal redirects to registration page")
    public  void accountNotFound_Modal() throws Exception{
        loginSteps.accountNotFound_Modal();
    }
    @Test(priority = 5, description = "To Validate cancel button in the \"account not found \"modal redirects to login page")
    public  void cancelAccountNotFound_Modal() throws Exception{
        loginSteps.cancelAccountNotFound_Modal();
    }
}
