package constants;

public class Constant {
	public static final String configFile=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TestData=System.getProperty("user.dir")+"\\src\\test\\resources\\groceryApp.xlsx";
	public static final String validCredentialError="User is unable to login with valid credentials";
	public static final String validUsernameInvalidPassword="User was able to login with valid password";
	public static final String InvalidusernameValidpassword="User is unable to login with invalid credentials";
	public static final String InvalidusernameInvalidPassword="User is unable to login with invalid credentials";
	public static final String homePageLogoutError="user is not able to logout";
	public static final String manageNewUserError="user is not able to add a new news";
	public static final String SearchNewUserError="news Searched by was not sucessfull";
}
