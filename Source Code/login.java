package m;

public class login {
	private static String email = "";
	private static String password = "";
	public static void setEmail(String e) {
		email = e;
	}
	public static void setPassword(String p) {
		password = p;
	}
	public static String getEmail() {
		return email;
	}
	public static String getPassword() {
		return password;
	}
}
