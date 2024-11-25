package com.asis.util;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver_manager.DriverManager;

public class MainClass {
	
	public WebDriver driver;
	
	public static String downloadDir = System.getProperty("user.dir") + File.separator + "Downloads";

	public static String newFilePath ;

	static ClientExcel clientExcel = new ClientExcel();
	public static String filePath = "ClientData.xls"; 
	public static String name;

	public static ArrayList<String> firstColumn = ClientExcel.readFirstColumn(filePath);
	public static ArrayList<String> clientNames = new ArrayList<>();
	public static ArrayList<String> fileNames = new ArrayList<>();
	public static List<String> clientCodes = new ArrayList<>();
	public static List<String> clientEmails = new ArrayList<>();
	public static ArrayList<String> subjectColumnData = ClientExcel.readSubjectColumn(filePath);
	public static ArrayList<String> pdfFileNames = ClientExcel.readPdfFileNamesFromColumn8(filePath);
	public static ArrayList<String> fileNamesColumn7 = ClientExcel.readFileNamesFromColumn7(filePath);

	public static ArrayList<ArrayList<String>> ACTIVITY_STATEMENT_DATA = new ArrayList<>();
	public static ArrayList<ArrayList<String>> ACTIVITY_STATEMENT_DATA2 = new ArrayList<>();

	public static WebDriverWait wait;

	public  static JavascriptExecutor js;

	/*====================Set up Driver===================================*/

	public static void setUpDriver(String browser) {
		DriverManager.setDriver(browser);
	}

	/*====================Launch Site===================================*/

	public static void launchSite(String url) {
		DriverManager.getDriver().get(url);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
		js = (JavascriptExecutor) DriverManager.getDriver();
	}

	/*====================Close Browser===================================*/

	public void tearDown() {
		DriverManager.getDriver().quit();
	}	
	
}