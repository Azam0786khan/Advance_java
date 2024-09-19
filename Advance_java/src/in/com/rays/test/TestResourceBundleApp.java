package in.com.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp {
	
	public static void main(String[] args) {
		
		//ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.app");
		//ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.app_hi");
		//ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.app_sp");
		
		//ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.app", new Locale("hi"));
		ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.app_sp", new Locale("sp"));



		
		System.out.println(rb.getString("greeting"));
	}

}
