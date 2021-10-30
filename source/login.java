package m;

public class login {
	private static String userName = "";
	private static String password = "";
	public static void setUsername(String u) {
		userName = u;
	}
	public static void setPassword(String p) {
		password = p;
	}
	public static String getUsername() {
		return userName;
	}
	public static String getPassword() {
		return password;
	}
}
