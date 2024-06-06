package org.selenium.constants;

import utils.ReportPathUtils;

public class FramworkConstants {
    public static String URL= "https://www.amazon.com";
     public static final String YES = "yes";
    public static final String NO = "no";
    private static final int EXPLICIT_WAIT = 10;
    public static final int WAIT = 5;
    private static final String Project_Name = "Webautomation";
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String ICON_Navigate_Right = "<i class='fa fa-arrow-circle-right' ></i>";
    public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/ExtentReports/";
    public static final String EXTENT_REPORT_NAME = "AutomationReport.html";
    private static String extentReportFilePath = "";
    // ICONS - START /
    public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
    public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
    public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
    public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";
    //public static final String ICON_BROWSER_EDGE = "edge";
    public static final String ICON_BROWSER_OPERA = "<i class=\"fa fa-opera\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_EDGE = "<i class=\"fa fa-edge\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_CHROME = "<i class=\"fa fa-chrome\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_FIREFOX = "<i class=\"fa fa-firefox\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_SAFARI = "<i class=\"fa fa-safari\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
    public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
    public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
    public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
    public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";
    public static final String ICON_SOCIAL_LINKEDIN = "<i class='fa fa-linkedin-square' style='font-size:24px'></i>";
    public static final String ICON_SOCIAL_GITHUB = "<i class='fa fa-github-square' style='font-size:24px'></i>";
    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
    public static String getProjectPath() {
        return PROJECT_PATH;
    }

    public static String getProjectName() {
        return Project_Name;
    }
    public static String getExtentReportFilePath() {

        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = ReportPathUtils.createExtentReportPath();
        }
        return extentReportFilePath;
    }

}
