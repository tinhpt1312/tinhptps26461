package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestLogin {
	public WebDriver driver;
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	private Map<String, Object[]> TestNGResults;
	private Map<String,String[]>  TestData;
	
	private final String excelDir="C:\\Users\\Nguyen Dung\\e-Workplaces\\ASMKiemThu\\test-resources\\data\\";
	
	private void readDataFromExcel() {
		try {
			TestData = new HashMap<String,String[]>();
			worksheet=workbook.getSheet("TestLogin");
			if(worksheet ==null) {
				System.out.println("Khoong tim thấy worksheet TestData");
			}else {
				Iterator<Row> rowIterator=worksheet.iterator(); 
				DataFormatter dataformat= new DataFormatter();
				while(rowIterator.hasNext()) {
					Row row= rowIterator.next();
					if(row.getRowNum()>=1) {
						Iterator<Cell> cellIterator= row.cellIterator();
						String key="";
						String username="";
						String password="";
						String fullname="";
						String email="";
						String expected="";
						while(cellIterator.hasNext()) {
							Cell cell=cellIterator.next();
							if(cell.getColumnIndex()==0) {
								key=dataformat.formatCellValue(cell);
							}else if(cell.getColumnIndex()==1) {
								username=dataformat.formatCellValue(cell);
							}else if(cell.getColumnIndex()==2) {
								password=dataformat.formatCellValue(cell);
							}else if(cell.getColumnIndex()==3) {
								fullname=dataformat.formatCellValue(cell);
							}else if(cell.getColumnIndex()==4) {
								email=dataformat.formatCellValue(cell);
							}else if(cell.getColumnIndex()==5) {
								expected=dataformat.formatCellValue(cell);
							}
							String[] myArr= {username,password,fullname,email,expected};
							TestData.put(key, myArr);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("readDataFromExcel() :"+ e.getMessage());
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun=true)
	public void suiteTest() {
		try {
		TestNGResults = new LinkedHashMap<String,Object[]>();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");		driver= new ChromeDriver();
		driver.manage().window().maximize();
		workbook=new XSSFWorkbook(new FileInputStream(new File(excelDir+"TestData.xlsx")));
		worksheet= workbook.getSheet("TestData");
		readDataFromExcel();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		workbook=new XSSFWorkbook();
		worksheet= workbook.createSheet("TestNG Result Summary");
		CellStyle rowStyle=workbook.createCellStyle();
		rowStyle.setAlignment(HorizontalAlignment.CENTER);
		rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		rowStyle.setWrapText(true);
		
		TestNGResults.put("1", new Object[] {"STT","Username","Password","Fullname","Email","Action","Expected","Actual","Status","Data Check"});
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SuiteTest(): "+e.getMessage());
		}
	}
	
	@Test
	public void LoginTest() {
		try {
			Set<String> keySet = TestData.keySet();
			int index = 1;
			for (String key : keySet) {
				String[] value = TestData.get(key);
				String username = value[0];
				String password = value[1];
				String fullname = value[2];
				String email = value[3];
				String expected = value[4];
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss | dd-MM-yyyy");
				String formattedDate = myDateObj.format(myFormatObj);
				driver.get("http://localhost:8080/ASMKiemThu/account/sign-in");
				driver.findElement(By.name("username")).sendKeys(username);
				driver.findElement(By.name("password")).sendKeys(password);
				Thread.sleep(1000);
				WebElement btnLogin = driver.findElement(By.name("login"));
				Actions actions = new Actions(driver).click(btnLogin);
				actions.build().perform();
				WebElement tt = driver.findElement(By.name("tt"));
				if (tt.getAttribute("value").equalsIgnoreCase(expected)) {
					TestNGResults.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), username, password, fullname, email, "Test Login",
									expected, tt.getAttribute("value"), "Pass", formattedDate });
				} else {
					System.out.println("Test Fail!!");
					TestNGResults.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), username, password, fullname, email, "Test Login",
									expected, tt.getAttribute("value"), "Failed", formattedDate });
				}
				index++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Login Test(): " + e.getMessage());
		}
	}
	
	
	@AfterClass
	public void suiteTearDown() {
		Set<String> keySet = TestNGResults.keySet();
		int rownum=0;
		for (String key : keySet) {
			CellStyle rowStyle = workbook.createCellStyle();
			Row row = worksheet.createRow(rownum++);
			Object[] objArr= TestNGResults.get(key);
			int cellnum=0;
			for (Object obj : objArr) {
				int flag=cellnum++;
				Cell cell=row.createCell(flag);
				if(obj instanceof Date) {
					cell.setCellValue((Date) obj);
				}else if(obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				}else if(obj instanceof String) {
					cell.setCellValue((String) obj);
				}else if(obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}
				rowStyle.setAlignment(HorizontalAlignment.CENTER);
				rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
				rowStyle.setWrapText(true);
				worksheet.autoSizeColumn(cellnum);
				worksheet.setColumnWidth(9, 7000);
				row.setRowStyle(rowStyle);
			}
			try {
				FileOutputStream out = new FileOutputStream(new File(excelDir + "RESULT_TEST_Login.xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("Successfully save to Excel File!!!");
			} catch (Exception e) {
				System.out.println("SuiteTearDown() : "+e.getMessage());
				// TODO: handle exception
			}
		}
	}
	
	
	
}
