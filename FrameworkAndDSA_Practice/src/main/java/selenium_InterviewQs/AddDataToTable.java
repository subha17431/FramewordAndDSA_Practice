package selenium_InterviewQs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class AddDataToTable {
	
	
	@Test
	public void addData() throws IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Step 1 - Launching URL
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		
		//Step 2 - Clicking on Table Data button
		driver.findElement(By.xpath("//summary[text()='Table Data']")).click();
		
		//Step 3 - Clear and Insert the following data in input text box
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).clear();
		
		File file = new File("C:\\Users\\hp\\git\\FramewordAndDSA_Practice\\FrameworkAndDSA_Practice\\src\\main\\resources\\testData\\testData.json");
		JsonMapper mapper = new JsonMapper();
		JsonNode readTree = mapper.readTree(file);
		
		//Insert the test data in input text box
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).sendKeys(mapper.readTree(file).toString());
		
		//Click on the Refresh Table Button
		driver.findElement(By.xpath("//button[@id='refreshtable']")).click();
		
		//Assert
		int rowNumber = 2; //Skipping 1st Header Row
		for(JsonNode each : readTree) {
			String nameFromJson = each.get("name").toString().replaceAll("\"", "");
			String ageFromJson = each.get("age").toString().replaceAll("\"", "");
			String genderFromJson = each.get("gender").toString().replaceAll("\"", "");
			String nameFromTable = driver.findElement(By.xpath("//table[@id='dynamictable']//tr["+rowNumber+"]//td[1]")).getText();
			String ageFromTable = driver.findElement(By.xpath("//table[@id='dynamictable']//tr["+rowNumber+"]//td[2]")).getText();
			String genderFromTable = driver.findElement(By.xpath("//table[@id='dynamictable']//tr["+rowNumber+"]//td[3]")).getText();
			Assert.assertEquals(nameFromTable, nameFromJson, "There is a mismatch in the name field");
			Assert.assertEquals(ageFromTable, ageFromJson, "There is a mismatch in the name field");
			Assert.assertEquals(genderFromTable, genderFromJson, "There is a mismatch in the name field");
			rowNumber++;
		}
		driver.close();
	}

}
