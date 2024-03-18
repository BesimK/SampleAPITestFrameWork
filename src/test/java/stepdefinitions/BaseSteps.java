package stepdefinitions;

import io.restassured.response.Response;
import com.blackbox.utils.ConfigManager;
import static io.restassured.RestAssured.baseURI;

public abstract class BaseSteps {
	static protected Response response;

	protected String registerUserEndpoint;

	protected String loginEndpoint;

	protected String deleteUserEndpoint;

	protected String listUsersEndpoint;

	protected String updateUsersEndpoint;

	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
		loginEndpoint = ConfigManager.getProperty("api.login.endpoint");
		registerUserEndpoint = ConfigManager.getProperty("api.register.endpoint");
		deleteUserEndpoint = ConfigManager.getProperty("api.delete.endpoint");
		updateUsersEndpoint = ConfigManager.getProperty("api.update.endpoint");
		listUsersEndpoint = ConfigManager.getProperty("api.users.endpoint");

	}

}
