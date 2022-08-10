package demowebshop.test;

import demowebshop.model.User;
import demowebshop.page.LoginPage;
import demowebshop.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 8/9/2022
 * #Comments:
 */
public class UserAccessTests extends CommonConditions {
    @Test
    public void oneCanLoginWebshop() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo("made.in.heaven84sep@gmail.com")));
    }
}
