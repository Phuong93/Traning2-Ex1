package Functions;

public class stepMain {

	public static void main(String[] args) throws InterruptedException {
		Helper support = new Helper();
		support.launchBrowser("Chrome");
		//support.loginFail("https://www.saucedemo.com/");
		support.loginSuccess("https://www.saucedemo.com/");
		

	}

}
