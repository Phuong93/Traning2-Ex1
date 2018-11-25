package Functions;

public class stepMain {

	public static void main(String[] args) throws InterruptedException {
		Helper support = new Helper("https://www.saucedemo.com/");
		support.launchBrowser("Chrome");
		//support.loginFail();
		support.loginSuccess();
		support.addToCard();

	}

}
