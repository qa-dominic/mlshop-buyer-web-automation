package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import utilities.FileUtils.FilePathUtils;

public abstract class Base_Steps extends GeneralMethod {

    Login_PageObjects loginPageObjects = new Login_PageObjects();
    Home_PageObjects home_PageObjects = new Home_PageObjects();
    Cart_PageObjects cart_PageObjects = new Cart_PageObjects();
    Shipping_PageObjects shippingPageObjects = new Shipping_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
    
}
