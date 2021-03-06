package com.qa.testcases;

import com.qa.base.base;
import com.qa.pages.ContractorListPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContractorListPageTest extends base
{

    LoginPage loginpage;
    DashboardPage dashboardPage;
    ContractorListPage contractorListPage;


    public ContractorListPageTest()
    {
        super();
    }

    //Best Practice to Follow as Below
    //Testcase should be Separated - Independent with each other
    //Then execute the @Test
    //After each test case "Close the Browser"


    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginpage = new LoginPage();
        dashboardPage = new DashboardPage();
        contractorListPage = new ContractorListPage();

        dashboardPage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage.clickOnUserManagementLink();
        dashboardPage.clickOnContractorMenuLink();


    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }


    @Test(priority = 1)
    public void verifyPageTitleTest()
    {
        String pageTitle = contractorListPage.validatePageHeader();
        Assert.assertEquals(pageTitle,"Contractor Control");

    }






}
