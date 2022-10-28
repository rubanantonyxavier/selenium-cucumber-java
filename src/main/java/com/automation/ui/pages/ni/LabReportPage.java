package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LabReportPage extends BasePage {

    @FindBy(id = "emailexportMenuBarTop")
    private WebElement topMenuBar;

    //USV Header Content Section
    @ElementName("Section - USV Header")
    @FindBy(id = "OMHeaderContent")
    private WebElement usvHeaderSection;

    @ElementName("USV - Report Order No.")
    @FindBy(xpath = "//div[@id='OMHeaderContent']/table[2]//tr[1]/td[2]/span")
    private WebElement usvReportOrderNumber;

    @ElementName("USV - Street Address")
    @FindBy(xpath = "//div[@id='OMHeaderContent']/table[2]//tr[2]/td[2]/span")
    private WebElement usvStreetAddress;

    @ElementName("USV - City, State, Zip")
    @FindBy(xpath = "//div[@id='OMHeaderContent']/table[2]//tr[3]/td[2]/span")
    private WebElement usvCityStateZip;

    //Report Section
    @ElementName("Section - LAB Report")
    @FindBy(id = "lab")
    private WebElement lsrmReportSection;

    @ElementName("Section - LAB Report Header")
    @FindBy(className = "header_table")
    private WebElement lsrmReportHeaderSection;

    //Information Section
    @ElementName("Section - Information1")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_1']")
    private WebElement sectionInformationTable1;

    @ElementName("Section - Information2")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']")
    private WebElement sectionInformationTable2;

    @ElementName("RI - Report Order No.")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_1']//tr[3]/td[2]")
    private WebElement riReportOrderNumber;

    @ElementName("RI - Report Date")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_1']//tr[3]/td[4]")
    private WebElement riReportDate;

    @ElementName("RI - Standardized Property Address")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_1']//tr[5]/td[2]")
    private WebElement riStandardizedPropertyAddress;

    @ElementName("LI - Loan Number")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']//tr[2]/td[2]")
    private WebElement liLoanNumber;

    @ElementName("BI - Pri-Borrower")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']//tr[2]/td[4]")
    private WebElement biPriBorrower;

    @ElementName("EI - Employer")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']//tr[2]/td[6]")
    private WebElement eiEmployer;

    //Search Summary Section
    @ElementName("Section - Search Summary")
    @FindBy(id = "Search_Summary")
    private WebElement sectionSearchSummary;

    //Fraud Alerts Section
    @ElementName("Section - Fraud Alert Header")
    @FindBy(id = "FM_fraudAlert")
    private WebElement sectionFraudAlertHeader;

    @ElementName("Section - Fraud Alert Table")
    @FindBy(id = "FM_fraudAlerts")
    private WebElement sectionFraudAlertsTable;

    @ElementName("FA - Fraud Risk Score")
    @FindBy(xpath = "//div[starts-with(@class,'FM_Number_Score FM_')]")
    private WebElement faFraudRiskScore;

    //Property Detail Section
    @ElementName("Section - Property Detail")
    @FindBy(id = "HP_PROPERTY_DETAIL")
    private WebElement sectionPropertyDetail;

    //Identity Detail Section
    @ElementName("Section - Identity Detail")
    @FindBy(id = "identityDetail")
    private WebElement sectionIdentityDetail;

    //Income Detail Section
    @ElementName("Section - Income Detail")
    @FindBy(id = "incomeDetail")
    private WebElement sectionIncomeDetail;

    //Borrower Detail Section
    @ElementName("Section - Borrower Detail")
    @FindBy(id = "borrowerDetail")
    private WebElement sectionBorrowerDetail;

    //Third Party Detail Section
    @ElementName("Section - Third Party Detail")
    @FindBy(id = "brokerDetail")
    private WebElement sectionThirdPartyDetail;

    //Market Detail Section
    @ElementName("Section - Market Detail")
    @FindBy(id = "marketDetail")
    private WebElement sectionMarketDetail;

    //Disclaimer Section
    @ElementName("Section - Disclaimer")
    @FindBy(id = "disclaimer")
    private WebElement sectionDisclaimer;

    @Override
    public String getTitle() {
        getWait().until(ExpectedConditions.visibilityOf(topMenuBar));
        return getDriver().getTitle();
    }
}