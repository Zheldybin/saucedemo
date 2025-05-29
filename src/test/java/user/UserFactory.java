package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withHRPermission() {
        return new User(PropertyReader.getProperty("hr-link.email.as.employeeHR"),
                PropertyReader.getProperty("hr-link.password.as.employeeHR"));
    }
}
