package steps;

import common.UsersApiStepBase;
import enums.UsersEndpointsEnum;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.CreateUserResp;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;

import static org.junit.Assert.assertEquals;
import static utils.UsersAPIContextManager.*;

public class DeleteUserSteps extends UsersApiStepBase {

	@When("I delete the user in the platform")
	public void deleteUser() {
		Response responseContext = getResponseManager(UsersEndpointsEnum.CREATE_USER);
		String id = responseContext.jsonPath().get("id");
		Response response = usersService.deleteUser(id);
		setResponseManager(UsersEndpointsEnum.DELETE_USER, response);

		// delete user in database
		if (response.statusCode() == HttpStatus.SC_NO_CONTENT) {
			CreateUserResp userToBeDeleted = getUserRespContext();

			userToBeDeleted = repository.addUser(userToBeDeleted);

			repository.delete(userToBeDeleted);
			userToBeDeleted = repository.find(userToBeDeleted.getId());

			setUserRespContext(userToBeDeleted);
		}
	}

	@Then("the user will be deleted from the database")
	public void verifyDeletedUser() {
		SoftAssertions softAssertions = new SoftAssertions();
		CreateUserResp deletedUser = getUserRespContext();
		Response response = getResponseManager(UsersEndpointsEnum.DELETE_USER);
		softAssertions.assertThat(response.statusCode()).as("status code").isEqualTo(HttpStatus.SC_NO_CONTENT);

		// Validate user was deleted from the database
		softAssertions.assertThat(deletedUser).as("deleted user").isNull();
		softAssertions.assertAll();
	}

}
