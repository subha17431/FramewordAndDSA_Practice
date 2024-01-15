package selenium_InterviewQs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;


public class ReadJson {
	
	@SuppressWarnings("unchecked")
	@Test
	public JSONArray readJson() throws IOException, ParseException {
	    JSONParser jsonParser = new JSONParser();
	    
	    // Create a new JSONArray to store the formatted output
        JSONArray formattedList = new JSONArray();
        
	    try {
	        FileReader reader = new FileReader("C:\\Users\\hp\\git\\FramewordAndDSA_Practice\\FrameworkAndDSA_Practice\\src\\main\\resources\\testData\\testData.json");
	        Object obj = jsonParser.parse(reader);
	        JSONArray usersList = (JSONArray) obj;


	        // Iterate through the original array and format each JSON object
	        for (Object user : usersList) {
	            JSONObject originalUser = (JSONObject) user;

	            LinkedHashMap<String, Object> formattedUser = new LinkedHashMap<>();
	            formattedUser.put("name", originalUser.get("name"));
	            formattedUser.put("age", originalUser.get("age"));
	            formattedUser.put("gender", originalUser.get("gender"));

	            formattedList.add(formattedUser);
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		return formattedList;
	}
}
