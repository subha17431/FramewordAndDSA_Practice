package cowinAPIs;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetStates extends BaseCowin {
	
	
	@Test
	public void getStates() {
		
		RestAssured.baseURI = "https://cdn-api.co-vin.in";
		
		Response response = RestAssured.given()
		.basePath("api/v2/admin/location/states")
		.log()
		.everything(true)
		.get();
		
		response.prettyPrint();
		
		List<Integer> idList = response.jsonPath().getList("states.state_id");
		List<String> stateNameList = response.jsonPath().getList("states.state_name");
		System.out.println(idList.size());
		//System.out.println(idList);
		//System.out.println(stateNameList);
		for (int i = 0; i < idList.size(); i++) {
			states.put(idList.get(i), stateNameList.get(i));
		}
		System.out.println(states);
	}

}
