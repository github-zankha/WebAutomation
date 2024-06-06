package org.selenium.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import utils.BrowserInfoUtils;
import utils.IconUtils;

import static org.selenium.constants.FramworkConstants.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle(getProjectName() + " - ALL");
            spark.config().setReportName(getProjectName() + " - ALL");

            extent.setSystemInfo("Organization", "Organisation XYZ");
            extent.setSystemInfo("Employee",
                    "<b> Zankhana Shah </b>" + " " + ICON_SOCIAL_LINKEDIN + " " + ICON_SOCIAL_GITHUB);
            extent.setSystemInfo("Domain", "Engineering (IT - Software)"+"  "+ICON_LAPTOP);
            extent.setSystemInfo("Skill", "Test Automation Engineer");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(IconUtils.getBrowserIcon() + " : " + testCaseName));
    }

    synchronized public static void addAuthors(AuthorType[] authors) {
        for (AuthorType author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author.toString());
        }
    }

    synchronized public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }

    synchronized public static void addDevices() {
        ExtentManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
    }
}