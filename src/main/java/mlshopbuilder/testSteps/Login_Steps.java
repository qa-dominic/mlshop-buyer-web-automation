package mlshopbuilder.testSteps;

import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Steps extends Base_Steps{
    String loginUrl = "https://mlshoppreprod.mlhuillier.com/authlogin";
    String registerUrl = "https://mlshoppreprod.mlhuillier.com/register";

   public void login(){
    try{
        navigateLoginPage();
        waitSleep(2000);
        assertEqual(driver.getCurrentUrl(), loginUrl);
        typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", reader.getRandomUser());
        waitSleep(5000);
        if(isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()))){
            inputOTP();
            click(loginPageObjects.okay_Btn(), "Okay Button");
            waitSleep(1000);
            assertEqual(driver.getCurrentUrl(), System.getProperty("targetUrl"));
            passTest("LOGIN SUCESS", "");
        }else{
            failTest("FAILED TO LOGIN", "");
        }
    }catch(Exception e){
        failTest("FAILED TO LOGIN", "Due to :" + e);
    }
      
   }
   public void inputOTP(){
       for(int i = 1; i <= 6 ; i++){
        typeActiveElement(String.valueOf(i));
       }
   }

   //MLS_TC_02
   //To validate the error message prompt for an empty mobile number field on the login page.
   public void emptyMobileNumber_field(){
    navigateLoginPage();
    typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", "");
    isVisible(loginPageObjects.mobileNumber_errorPrompt(), getText(loginPageObjects.mobileNumber_errorPrompt()));
    if(getText(loginPageObjects.mobileNumber_errorPrompt()).contains("Mobile Number is Required")){
        passTest("MLS_TC_02", "To validate the error message prompt for an empty mobile number field on the login page");
    }else{
        failTest("Incorrect Error Message", "");
    }
   }

   //MLS_TC_03
   //To Validate One time pin prompt display on login page
   public void otpPrompt(){
    navigateLoginPage(); 
    typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", reader.getRandomUser());
    waitSleep(5000); 
    if(isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()))){
        passTest("MLS_TC_03", "To Validate One time pin prompt display on login page");
    }else{
        failTest("OTP is not displaying?", "");
    }
   }

  //MLS_TC_07
  //To validate the login functionality using an unregistered phone number
   public void loginUnRegisteredMobileNumber(){
    navigateLoginPage();
    typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", "09696969696");
    if(isVisible(loginPageObjects.accNotFound_Element(), getText(loginPageObjects.accNotFound_Element()))){
        passTest("MLS_TC_07", "To validate the login functionality using an unregistered phone number");
    }else{
        failTest("Account not Found Modal is not visible", "");
    }
   }

  //MLS_TC_08
  //To Validate proceed button in the "account not found" modal redirects to registration page
   public void accountNotFound_Modal(){
    navigateLoginPage();
    typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", "09696969696");
    click(loginPageObjects.proceed_Btn(), "Proceed Button");
    assertEqual(driver.getCurrentUrl(), registerUrl);
    passTest("MLS_TC_08", "To Validate proceed button in the \"account not found\" modal redirects to registration page");
   }

  //MLS_TC_09
  //To Validate cancel button in the "account not found "modal redirects to login page
   public void cancelAccountNotFound_Modal(){
    navigateLoginPage();
    typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", "09696969696");
    boolean isClose=false;
    if(isVisible(loginPageObjects.accNotFound_Element(), getText(loginPageObjects.accNotFound_Element()))){
        click(loginPageObjects.cancel_Btn(), "Cancel Button");
        assertEqual(driver.getCurrentUrl(), loginUrl);
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='font-bold text-lg text-center']")));
            passTest("Validate Element Not on Page", "Element not found as expected");
        }catch (NoSuchElementException e){
            passTest("Validate Element Not on Page", "Element not found as expected");
        }
    }else{
        failTest("Account not found modal is not visible", "");
    }
   }

  //MLS_TC_10, MLS_TC_11, MLS_TC_12, MLS_TC_13, MLS_TC_14, MLS_TC_15, MLS_TC_16, MLS_TC_17
  //Error field messages
   public void errorFieldMessages_registration(){
    navigateLoginPage();
    typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", "09696969696");
    boolean isRegistrationPage = false;
    if(isVisible(loginPageObjects.accNotFound_Element(), getText(loginPageObjects.accNotFound_Element()))){
        click(loginPageObjects.proceed_Btn(), "Proceed Button");
        assertEqual(driver.getCurrentUrl(), registerUrl);
        isRegistrationPage = true;
    }else{
        failTest("Account not found modal is not visible", "");
    }
    if (isRegistrationPage) {
        type(loginPageObjects.mobileNumber_fieldRegister(), "Mobile Number Field", "09171");
        type(loginPageObjects.firstName_fieldRegister(), "First Name", "test123");
        type(loginPageObjects.lastName_fieldRegister(), "Last Name", "test123");
        type(loginPageObjects.email_fieldRegister(), "Email", "test123");
        type(loginPageObjects.streetField(), "Street", "");
        for(WebElement errMessage : loginPageObjects.errorMessage_text()){
            if(errMessage.getText().contains("Invalid")){
                passTest("errorFieldMessages_registration", "Error field messages");
                break;
            }
        }
    }
   }

  //MLS_TC_18
  //To Validate One time pin prompt display after clicking register
   public void otpPromptAfterRegister(){
       navigateLoginPage();
       typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", "09696969696");
       boolean isRegistrationPage = false;
       if(isVisible(loginPageObjects.accNotFound_Element(), getText(loginPageObjects.accNotFound_Element()))){
           click(loginPageObjects.proceed_Btn(), "Proceed Button");
           assertEqual(driver.getCurrentUrl(), registerUrl);
           isRegistrationPage = true;
       }else{
           failTest("Account not found modal is not visible", "");
       }
       if (isRegistrationPage) {
           type(loginPageObjects.mobileNumber_fieldRegister(), "Mobile Number Field", "09123456789");
           type(loginPageObjects.firstName_fieldRegister(), "First Name", "test");
           type(loginPageObjects.lastName_fieldRegister(), "Last Name", "test");
           type(loginPageObjects.email_fieldRegister(), "Email", "test@gmail.com");
           selectByVisibleText(loginPageObjects.province_dropDown(), "CEBU");
           selectByVisibleText(loginPageObjects.city_dropDown(), "CEBU CITY");
           type(loginPageObjects.streetField(), "Street", "test");
           click(loginPageObjects.register_Btn(), "Register");
           isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()));
           passTest("OTP is Visible", "");
       }
   }

   public void navigateLoginPage(){
    click(home_PageObjects.userIcon(), "User Icon"); 
   }
}
