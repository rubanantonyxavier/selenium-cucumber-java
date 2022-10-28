package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PxiReportPage extends BasePage {

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
    @ElementName("Section - PXI Report")
    @FindBy(id = "pxi")
    private WebElement lscmReportSection;

    @ElementName("Section - PXI Report Header")
    @FindBy(xpath = "//table[@class='CM_header']")
    private WebElement lscmReportHeaderSection;

    //Information Section
    @ElementName("Section - Report Information")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_1']")
    private WebElement sectionReportInformation;

    @ElementName("Section - Loan Information")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_2']")
    private WebElement sectionLoanInformation;

    @ElementName("RI - Report Order No.")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_1']//tr[2]/td[2]")
    private WebElement riReportOrderNumber;

    @ElementName("RI - Report Date")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_1']//tr[2]/td[4]")
    private WebElement riReportDate;

    @ElementName("RI - Standardized Property Address")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_1']//tr[3]/td[2]")
    private WebElement riStandardizedPropertyAddress;

    @ElementName("LI - Loan Number")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_2']//tr[2]/td[2]")
    private WebElement liLoanNumber;

    @ElementName("LI - Reported Appraised Value")
    @FindBy(xpath = "//table[@class='CM_data CM_header_info_2']//tr[3]/td[2]")
    private WebElement liReportedAppraisedValue;

    //Alerts Section
    @ElementName("FA - Collateral Risk Score")
    @FindBy(xpath = "//div[@class='CM_score']/span")
    private WebElement collateralRiskScore;

    @ElementName("Section - Appraisal Review Alerts")
    @FindBy(id = "CM_collateralAlert")
    private WebElement sectionAppraisalReviewAlerts;

    @ElementName("Section - Fraud Alerts")
    @FindBy(id = "CM_fraudAlert")
    private WebElement sectionFraudAlerts;

    //Property Detail Section
    @ElementName("Section - Property Detail")
    @FindBy(id = "HP_PROPERTY_DETAIL")
    private WebElement sectionPropertyDetail;

    @ElementName("Section - Recent Subject Property Resale Summary")
    @FindBy(id = "recentPropertyResale")
    private WebElement sectionSubjectPropertyRecentResaleSummary;

    @ElementName("Section - Subject Property Report")
    @FindBy(id = "HP_SUBJECT_REPORT")
    private WebElement sectionSubjectPropertyReport;

    @ElementName("Section - Nearby Properties Review")
    @FindBy(id = "nearbyPropertyReview")
    private WebElement sectionNearbyPropertiesReview;

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