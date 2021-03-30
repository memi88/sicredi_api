package getRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.*;


@RunWith(DataProviderRunner.class)
public class TestRestricoes {
	
	
String api = "http://localhost:8080/api/v1/restricoes/{cpf}";
    
	@DataProvider()
	public static String[] testDataCPFs() {
	    return new String[]{           
	    		"97093236014", "60094146012", "84809766080", "62648716050", "26276298085", 
	    		"01317496094", "55856777050", "19626829001", "24094592008", "58063164083" 
	    };
	}
	
	
		
	@Test
	@UseDataProvider("testDataCPFs")
	public void getComRestricao(String param) {
		given()
			.pathParam("cpf", param)
		.when()
			.get(api)
		.then()
			.assertThat()
			.statusCode(200)
			.body("mensagem", equalTo("O CPF " + param + " possui restrição"));
		
	}
	
	@Test
	public void getSemRestricao() {
		given()
			
		.when()
			.get(api, "78932068020")
		.then()
			.assertThat()
			.statusCode(204);
			
		
	}

}
