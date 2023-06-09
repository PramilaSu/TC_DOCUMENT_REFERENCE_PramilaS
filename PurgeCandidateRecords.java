package com.testng.OrangeHRM_MaintenanceModule;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

 public class PurgeCandidateRecords {
	WebDriver driver;
	Properties p;
		
		@BeforeMethod
		public void beforemethod() {
			
			driver = new ChromeDriver();
			System.out.println(">> Chrome Browser Launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		  
			try {
				FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\Tentngdemo\\src\\test\\java\\com\\utils\\TestNg\\purge_records_candidate.properties");
				Properties p = new Properties();
				p.load(fis);
				String url= p.getProperty("mainURL");
			    String username= p.getProperty("user");
				String password= p.getProperty("passwd");
                String usernameloc= p.getProperty("username_loc");
				String passwordloc= p.getProperty("password_loc");
				String loginloc= p.getProperty("login_loc");
				String maintainancetabloc= p.getProperty("maintainance_tab_loc");
				String administratorAccessCancelbuttonloc= p.getProperty("administrator_Access_Cancel_button_loc");
				String adminpasswordloc= p.getProperty("admin_password_loc");
			    String administratorconfirmbuttonloc= p.getProperty("administrator_confirm_button_loc");
			    
			    driver.get(url);
				driver.findElement(By.name(usernameloc)).sendKeys(username);	
				System.out.println(">> Username entered succesfully"); 
				driver.findElement(By.name(passwordloc)).sendKeys(password);
				System.out.println(">> Password entered succesfully"); 
				Thread.sleep(3000);
		        driver.findElement(By.xpath(loginloc)).click();
		        System.out.println(">> Login succesfully"); 
		        Thread.sleep(3000);
		        driver.findElement(By.xpath(maintainancetabloc)).click();
		        System.out.println(">> Maintenance module access succesfully");
		        driver.findElement(By.xpath(administratorAccessCancelbuttonloc)).click();  
		        System.out.println(">> Verfied Administrator Acess Cancel succesfully");
		        driver.findElement(By.xpath(maintainancetabloc)).click();
		        driver.findElement(By.name(adminpasswordloc)).sendKeys(password);	
		        Thread.sleep(3000);
		        driver.findElement(By.xpath(administratorconfirmbuttonloc)).click();
		         System.out.println(">> Administrator Access Login succesfully");
			     Thread.sleep(3000);
			    }
			
			  catch(Exception e) {
				}
		}
		
		 @AfterMethod
		
		   public void aftermethod() {
			//driver.quit();
		 }

	     @Test
		 public void purgeCandiadteRecords() {
      
           try {
            String Vacancy= p.getProperty("vacancy");
            String purgerecordsloc=p.getProperty("purge_records_loc");
            String purgerecordsdropdownloc=p.getProperty("purge_records_dropdown_loc");
            String vacancyfieldloc=p.getProperty("vacancy_field_loc");
            String searchresultsloc=p.getProperty("search_results_loc");
            
            //Purge Records
	       driver.findElement(By.xpath(purgerecordsloc)).click();

           List<WebElement> list= driver.findElements(By.xpath(purgerecordsdropdownloc));	
             
              Iterator<WebElement> iterator1 = list.iterator();
	           while(iterator1.hasNext()) {
	   	          WebElement webElement =(WebElement) iterator1.next();
	              System.out.println(webElement.getText());
	   	             if(webElement.getText().equals("Candidate Records")){
	                   webElement.click();
	   	             }
	           }  
	 		 driver.findElement(By.cssSelector(vacancyfieldloc)).sendKeys(Vacancy);
	         Thread.sleep(4000);
	         System.out.println("Vacancy is displayed succesfully");
	         driver.findElement(By.xpath(searchresultsloc)).click();
	         System.out.println("Search results: Candidate name, Date of Application and status is displayed succesfully");
	           } 
	           catch(Exception e) {
	           }
           }  
	     
	        @Test
			 public void searchWithInvalidData() {
	      
	          try {
	        	   String Invalidvacancy= p.getProperty("invalidvacancy");
	               String vacancyfieldloc=p.getProperty("vacancy_field_loc");
	               String searchresultsloc=p.getProperty("search_results_loc");
	               driver.findElement(By.cssSelector(vacancyfieldloc)).sendKeys(Invalidvacancy);
	  	            Thread.sleep(4000);
	  	            WebElement clk= driver.findElement(By.xpath(searchresultsloc));
                     clk.click();
                   System.out.println("Invalid Error message is displayed");
	          }    
	          catch(Exception e) {
	          }
	        }
	        
	        @Test
			 public void verifyPurgeAllbutton() {
	      
	          try {
	        	   String Vacancy= p.getProperty("vacancy");
	               String vacancyfieldloc=p.getProperty("vacancy_field_loc");
	               String purgeallloc=p.getProperty("purge_all_loc");
	               String searchresultsloc=p.getProperty("search_results_loc");
	               driver.findElement(By.cssSelector(vacancyfieldloc)).sendKeys(Vacancy);
	  	            Thread.sleep(4000);
	  	           driver.findElement(By.xpath(searchresultsloc)).click();
                   driver.findElement(By.xpath(purgeallloc)).click();
                   
	            }    
	          catch(Exception e) {
	          } 
	        }
		
	        @Test
			 public void noCancelAlertBox() {
	      
	          try {
	        	   String Vacancy= p.getProperty("vacancy");
	               String vacancyfieldloc=p.getProperty("vacancy_field_loc");
	               String searchresultsloc=p.getProperty("search_results_loc");
	               String purgeallloc=p.getProperty("purge_all_loc");
	               String nocancelalertboxloc=p.getProperty("no_cancel_alert_box_loc");
	               driver.findElement(By.cssSelector(vacancyfieldloc)).sendKeys(Vacancy);
	  	            Thread.sleep(4000);
	  	           driver.findElement(By.xpath(searchresultsloc)).click();
                   driver.findElement(By.xpath(purgeallloc)).click(); 
                   driver.findElement(By.xpath(nocancelalertboxloc)).click();
                   System.out.println("Purge Candidate alert box: No Cancel selected");
	            }    
	          catch(Exception e) {
	          }
	        }
	    
	        @Test
			 public void yesAcceptAlertBox() {
	      
	          try {
	        	   String Vacancy= p.getProperty("vacancy");
	               String vacancyfieldloc=p.getProperty("vacancy_field_loc");
	               String searchresultsloc=p.getProperty("search_results_loc");
	               String purgeallloc=p.getProperty("purge_all_loc");
	               String yesacceptalertboxloc=p.getProperty("yes_accept_alert_box_loc");
	               driver.findElement(By.cssSelector(vacancyfieldloc)).sendKeys(Vacancy);
	  	            Thread.sleep(4000);
	  	           driver.findElement(By.xpath(searchresultsloc)).click();
                   driver.findElement(By.xpath(purgeallloc)).click();                    
          		   driver.findElement(By.xpath(yesacceptalertboxloc)).click();           
          		    System.out.println("Purge Candidate alert box: Yes Purge selected");
	               }    
	          catch(Exception e) {
	          }
	        }
	     }
      	
     

 
  