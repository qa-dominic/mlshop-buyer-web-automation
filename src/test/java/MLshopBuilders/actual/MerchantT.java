package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class MerchantT extends BaseTest {

    @Test(priority =0)
    public void SBR_TC_01_Login() throws Exception {
        merchantSteps.SBR_TC_01_Login();
    }
    @Test(priority = 1)
    public void SBR_TC_02_NavigateShopBuilder_Page() throws Exception {
        merchantSteps.SBR_TC_02_NavigateShopBuilder_Page();
    }
    @Test(priority =2)
    public void SBR_TC_03_TotalStores() throws Exception {
        merchantSteps.SBR_TC_03_TotalStores();
    }
    @Test(priority =3)
    public void SBR_TC_04_InvStoreSearch() throws Exception {
        merchantSteps.SBR_TC_04_InvStoreSearch();
    }
    @Test(priority =4)
    public void SBR_TC_05_StoreSearch() throws Exception {
        merchantSteps.SBR_TC_05_StoreSearch();
    }
    @Test(priority =5)
    public void SBR_TC_06_StoreRedirection() throws Exception {
        merchantSteps.SBR_TC_06_StoreRedirection();
    }
    @Test(priority =6)
    public void SBR_TC_07_AddProductRedirection() throws Exception {
        merchantSteps.SBR_TC_07_AddProductRedirection();
    }
    @Test(priority =7)
    public void SBR_TC_08_ProductinfoInputs_09_SalesInformationInputs() throws Exception {
        merchantSteps.SBR_TC_08_ProductinfoInputs_09_SalesInformationInputs();
    }

//    @Test(priority =8)
//    public void SBR_TC_10() throws Exception {
//        merchantSteps.SBR_TC_10();
//    }
    @Test(priority =9)
    public void SBR_TC_11_ValidateInputs() throws Exception {
        merchantSteps.SBR_TC_11_ValidateInputs();
    }
//    @Test(priority =10)
//    public void SBR_TC_12_SubmitandPublish() throws Exception {
//        merchantSteps.SBR_TC_12_SubmitandPublish();
//    }
        @Test(priority =11)
    public void SBR_TC_13_Viewproduct() throws Exception {
        merchantSteps.SBR_TC_13_Viewproduct();
    }
    @Test(priority =12)
    public void SBR_TC_14_Incorrectsearch() throws Exception {
        merchantSteps.SBR_TC_14_Incorrectsearch();
    }
    @Test(priority =13)
    public void SBR_TC_15_ShowEntries() throws Exception {
        merchantSteps.SBR_TC_15_ShowEntries();
    }
    @Test(priority =14)
    private void SBR_TC_16_Viewdetails() throws Exception {
        merchantSteps.SBR_TC_16_Viewdetails();
    }
    @Test(priority =15)
    public void SBR_TC_Searches() throws Exception {
        merchantSteps.SBR_TC_Searches();
    }
    @Test(priority =16)
    public void SBR_TC_22_NoDisplayDatefilter() throws Exception {
        merchantSteps.SBR_TC_22_NoDisplayDatefilter();
    }
    @Test(priority =17)
    public void SBR_TC_23_Datefilter() throws Exception {
        merchantSteps.SBR_TC_23_Datefilter();
    }

}
