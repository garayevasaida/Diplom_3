package constants;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class UserSteps {
    @Step("Создание пользователя")
    public static  Response createUser(User user) {
        return given().spec(Api.baseRequestSpec())
                .body(user)
                .when()
                .post(Api.CREATE_USER);
    }

    @Step("Логин пользователя")
    public static Response loginUser(User user) {
        return given().spec(Api.baseRequestSpec())
                .body(user)
                .when()
                .post(Api.USER_LOGIN);
    }

    @Step("Удалить пользователя")
    public static ValidatableResponse deleteUser(String accessToken) {
        return given().spec(Api.baseRequestSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(Api.DELETE_USER)
                .then()
                .assertThat()
                .statusCode(202);
    }
}
