package getRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.json.simple.JSONObject;



public class TestSimulacoes {
	
	
String api = "http://localhost:8080/api/v1/simulacoes";
	
@Test
public void postSimulacoes_ComSucessoSeguroTrue() {
	
	String nome = "Joao da Silva";
	String cpf = "33325694063";
	String email = "email@email.com";
	int valor = 1000;
	int parcelas = 2;
	boolean seguro = true;
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", nome);
	requestParams.put("cpf", cpf);
	requestParams.put("email", email);
	requestParams.put("valor", valor);
	requestParams.put("parcelas", parcelas);
	requestParams.put("seguro", seguro);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(201)
		.body("nome", equalTo(nome),
				"cpf", equalTo(cpf),
				"email", equalTo(email),
				"valor", equalTo(valor),
				"parcelas", equalTo(parcelas),
				"seguro", equalTo(seguro));
}

@Test
public void postSimulacoes_ComSucessoSeguroFalse() {
	
	String nome = "Joao de Lima";
	String cpf = "35393946058";
	String email = "email@email.com";
	int valor = 40000;
	int parcelas = 48;
	boolean seguro = false;
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", nome);
	requestParams.put("cpf", cpf);
	requestParams.put("email", email);
	requestParams.put("valor", valor);
	requestParams.put("parcelas", parcelas);
	requestParams.put("seguro", seguro);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(201)
		.body("nome", equalTo(nome),
				"cpf", equalTo(cpf),
				"email", equalTo(email),
				"valor", equalTo(valor),
				"parcelas", equalTo(parcelas),
				"seguro", equalTo(seguro));
}

@Test
public void postSimulacoes_CPFExistente() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("cpf", "35393946058");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1000);
	requestParams.put("parcelas", 2);
	requestParams.put("seguro", true);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(409)
		.body("mensagem", equalTo("CPF já existente"));
}

@Test
public void postSimulacoes_SemCPF() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1000);
	requestParams.put("parcelas", 2);
	requestParams.put("seguro", true);
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.cpf", equalTo("CPF não pode ser vazio"));
}

@Test
public void postSimulacoes_SemNome() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("cpf", "09857516068");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1000);
	requestParams.put("parcelas", 2);
	requestParams.put("seguro", true);
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.nome", equalTo("Nome não pode ser vazio"));
}

@Test
public void postSimulacoes_SemEmail() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("cpf", "09857516068");
	requestParams.put("valor", 1000);
	requestParams.put("parcelas", 2);
	requestParams.put("seguro", true);
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.email", equalTo("E-mail não deve ser vazio"));
}

@Test
public void postSimulacoes_SemValor() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("cpf", "09857516068");
	requestParams.put("email", "email@email.com");
	requestParams.put("parcelas", 2);
	requestParams.put("seguro", true);
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.valor", equalTo("Valor não pode ser vazio"));
}

@Test
public void postSimulacoes_SemParcela() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("cpf", "09857516068");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1000);
	requestParams.put("seguro", true);
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.parcelas", equalTo("Parcelas não pode ser vazio"));
}

@Test
public void postSimulacoes_SemSeguro() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("cpf", "09857516068");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1000);
	requestParams.put("parcelas", 2);
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.seguro", equalTo("Seguro não pode ser vazio"));
}

@Test
public void postSimulacoes_CPFInvalido1() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "1");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.log().all();
}

@Test
public void postSimulacoes_CPFInvalido2() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "123456789090");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.log().all();
}

@Test
public void postSimulacoes_CPFInvalido3() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "9999556500X");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.log().all();
}

@Test
public void postSimulacoes_EmailInvalido() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao dos Santos");
	requestParams.put("cpf", "59320084076");
	requestParams.put("email", "emailemail.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.email", equalTo("E-mail deve ser um e-mail válido"));
}

@Test
public void postSimulacoes_EmailInvalido1() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao dos Santos");
	requestParams.put("cpf", "59320084076");
	requestParams.put("email", "email@email");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.email", equalTo("E-mail deve ser um e-mail válido"));
}


@Test
public void postSimulacoes_ValorMenor() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "59320084076");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 99);
	requestParams.put("parcelas", 3);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.valor", equalTo("Valor da simulação deve ser maior ou igual que R$ 1.000"));
}

@Test
public void postSimulacoes_ValorMaior() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "59320084076");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 40.001);
	requestParams.put("parcelas", 3);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.valor", equalTo("Valor da simulação deve ser menor ou igual que R$ 40.000"));
}


@Test
public void postSimulacoes_ParcelaMenor() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "59320084076");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1200);
	requestParams.put("parcelas", 1);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.parcelas", equalTo("Parcelas deve ser igual ou maior que 2"));
}

@Test
public void postSimulacoes_ParcelaMaior() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "59320084076");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1200);
	requestParams.put("parcelas", 49);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		post(api)
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.parcelas", equalTo("Parcelas deve ser menor ou igual que 48"));
}



@Test
public void putSimulacoes_ComSucesso() {
	
	String nome = "Santos Silv";
	String cpf = "66414919004";
	String email = "emailsilv@email.com";
	int valor = 1299;
	int parcelas = 11;
	boolean seguro = true;
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", nome);
	requestParams.put("email", email);
	requestParams.put("cpf", cpf);
	requestParams.put("valor", valor);
	requestParams.put("parcelas", parcelas);
	requestParams.put("seguro", seguro);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "66414919004")
	.then()
		.assertThat()
		.statusCode(200)
		.body("nome", equalTo(nome),
				"cpf", equalTo(cpf),
				"email", equalTo(email),
				"valor", equalTo(valor),
				"parcelas", equalTo(parcelas),
				"seguro", equalTo(seguro));
}

@Test
public void putSimulacoes_CPFInexistente() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Santos Silva");
	requestParams.put("email", "emailsilva@email.com");
	requestParams.put("cpf", "18566202040");
	requestParams.put("valor", 1200);
	requestParams.put("parcelas", 10);
	requestParams.put("seguro", true);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "18566202040")
	.then()
		.assertThat()
		.statusCode(404)
		.body("mensagem", equalTo("CPF não encontrado"));
}



@Test
public void putSimulacoes_CPFComRestricao() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Santos Silva");
	requestParams.put("email", "emailsilva@email.com");
	requestParams.put("cpf", "26276298085");
	requestParams.put("valor", 1200);
	requestParams.put("parcelas", 10);
	requestParams.put("seguro", true);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "12345")
	.then()
		.assertThat()
		.statusCode(404);
		
}


@Test
public void putSimulacoes_CPFExistente() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao da Silva");
	requestParams.put("cpf", "97093236014");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1000);
	requestParams.put("parcelas", 2);
	requestParams.put("seguro", true);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(409)
		.body("mensagem", equalTo("CPF já existente"));
}

@Test
public void putSimulacoes_CPFInvalido1() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "12345");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.log().all();
}

@Test
public void putSimulacoes_CPFInvalido2() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "123456789090");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.log().all();
}

@Test
public void putSimulacoes_CPFInvalido3() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "9999556500X");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.log().all();
}

@Test
public void putSimulacoes_EmailInvalido() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao dos Santos");
	requestParams.put("cpf", "62648716050");
	requestParams.put("email", "emailemail.com");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.email", equalTo("E-mail deve ser um e-mail válido"));
}

@Test
public void putSimulacoes_EmailInvalido1() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao dos Santos");
	requestParams.put("cpf", "62648716050");
	requestParams.put("email", "email@email");
	requestParams.put("valor", 1500);
	requestParams.put("parcelas", 5);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.email", equalTo("E-mail deve ser um e-mail válido"));
}


@Test
public void putSimulacoes_ValorMenor() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "62648716050");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 99);
	requestParams.put("parcelas", 3);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.valor", equalTo("Valor da simulação deve ser maior ou igual que R$ 1.000"));
}

@Test
public void putSimulacoes_ValorMaior() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "62648716050");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 40.001);
	requestParams.put("parcelas", 3);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.valor", equalTo("Valor da simulação deve ser menor ou igual que R$ 40.000"));
}


@Test
public void putSimulacoes_ParcelaMenor() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "62648716050");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1200);
	requestParams.put("parcelas", 1);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.parcelas", equalTo("Parcelas deve ser igual ou maior que 2"));
}

@Test
public void putSimulacoes_ParcelaMaior() {
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("nome", "Joao de Lima");
	requestParams.put("cpf", "62648716050");
	requestParams.put("email", "email@email.com");
	requestParams.put("valor", 1200);
	requestParams.put("parcelas", 49);
	requestParams.put("seguro", false);
	
	given()
		.contentType("application/json")
		.body(requestParams.toJSONString())
	.when().
		put(api + "/{cpf}", "62648716050")
	.then()
		.assertThat()
		.statusCode(400)
		.body("erros.parcelas", equalTo("Parcelas deve ser menor ou igual que 48"));
}



	@Test
	public void getAllSimulacoes() {
		given()
		.when()
			.get(api)
		.then()
			.assertThat()
			.statusCode(200);
					
	}
	
	@Test
	public void getSimulacoes_ComSucesso() {
		given()
		.when()
			.get(api + "/{cpf}", "97093236014")
		.then()
			.assertThat()
			.statusCode(200)
			.body("id", equalTo(13),
					"nome", equalTo("Fulano de Tal"),
					"cpf", equalTo("97093236014"),
					"email", equalTo("email@email.com"),
					"valor", equalTo(1200.0F),
					"parcelas", equalTo(3),
					"seguro", equalTo(true));
			
		
	}
	
	@Test
	public void getSimulacoes_SemSimulacao() {
		given()
		.when()
			.get(api + "/{cpf}", "06608442068")
		.then()
			.assertThat()
			.statusCode(404)
			.body("mensagem", equalTo("CPF 06608442068 não encontrado"));
			
			
		
	}
	
	
	@Test
	public void deleteSimulacoes_ComSucesso() {
		
		given()
		.when().
			delete(api + "/{id}", "91")
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
	}
	
	@Test
	public void deleteSimulacoes_SemSimulacao() {
		
		
		given()			
		.when().
			delete(api + "/{id}", "100")
		.then()
			.assertThat()
			.statusCode(404)
			.body("mensagem", equalTo("Simulação não encontrada"));
	}
	
	
		
}
