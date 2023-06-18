import com.amazon.classified.controller.AppDriver;

public class Driver {

	//initiates the application
	public static void main(String[] args) {
		AppDriver appDriver = new AppDriver();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("            Amazon Internal classifieds             ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
		appDriver.initiate();
	}
}
