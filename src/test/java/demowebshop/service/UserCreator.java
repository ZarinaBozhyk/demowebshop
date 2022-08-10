package demowebshop.service;

import demowebshop.model.User;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 8/9/2022
 * #Comments:
 */
public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";


    public static User withCredentialsFromProperty() {
        return new User(PropertiesCache.getInstance().getProperty(TESTDATA_USER_NAME),
                PropertiesCache.getInstance().getProperty(TESTDATA_USER_PASSWORD));
    }
}