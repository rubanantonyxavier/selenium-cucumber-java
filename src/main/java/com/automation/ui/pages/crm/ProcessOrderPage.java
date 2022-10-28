package com.automation.ui.pages.crm;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProcessOrderPage extends BasePage {

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
    @ElementName("Section - DAQ Report")
    @FindBy(id = "daq")
    private WebElement lsfmReportSection;

    @ElementName("Section - DAQ Report Header")
    @FindBy(className = "header_table")
    private WebElement lsfmReportHeaderSection;

    //Information Section
    @ElementName("RI - Report Order No.")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_1']//tr[3]/td[2]")
    private WebElement riReportOrderNumber;

    @ElementName("LI - Loan Number")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']//tr[2]/td[2]")
    private WebElement liLoanNumber;

    @ElementName("BI - Pri-Borrower")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']//tr[2]/td[4]")
    private WebElement biPriBorrower;

    @ElementName("EI - Employer")
    @FindBy(xpath = "//table[@class='FM_data FM_header_info_2']//tr[2]/td[6]")
    private WebElement eiEmployer;

    //Fraud Alerts Section
    @ElementName("FA - Fraud Risk Score")
    @FindBy(xpath = "//div[@class='FM_Number_Score FM_Not_Rescorable']")
    private WebElement faFraudRiskScore;

    @Override
    public String getTitle() {
        getWait().until(ExpectedConditions.visibilityOf(usvHeaderSection));
        return getDriver().getTitle();
    }
}