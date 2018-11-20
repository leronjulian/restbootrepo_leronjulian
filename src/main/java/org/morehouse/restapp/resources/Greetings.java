package org.morehouse.restapp.resources;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;
import java.util.Formatter;
import java.util.Locale;

@RestController
@RequestMapping("/hello")
public class Greetings {
	@RequestMapping(value = "/{param}", method = RequestMethod.GET)
	  public String printMessage(@PathVariable("param") String msg) {
	    String result = "Hello " + msg + "!";
	    return result;
	  }
	
	@RequestMapping(value = "/hello/{name}/{locale}", method = RequestMethod.GET)
	public static void getValues(ResourceBundle bundle) {
		ResourceBundle bundle1 = ResourceBundle.getBundle("messageBundle");
		displayValues(bundle1);
		
		Locale defaultLocale = Locale.getDefault();
		ResourceBundle bundle2 = ResourceBundle.getBundle("messageBundle", defaultLocale);
		displayValues(bundle2);
		
		Locale arabicLocale = new Locale("ar", "EG");
		ResourceBundle bundle3 = ResourceBundle.getBundle("messageBundle", arabicLocale);
		displayValues(bundle3);
		
		Locale germanLocale = new Locale("de", "DE");
		ResourceBundle bundle4 = ResourceBundle.getBundle("messageBundle", germanLocale);
		displayValues(bundle4);
		
		Locale frenchLocale = new Locale("fr", "FR");
		ResourceBundle bundle5 = ResourceBundle.getBundle("messageBundle", frenchLocale);
		displayValues(bundle5);
		
	}

	public static String displayValues(ResourceBundle bundle) {
		return("question message:" + bundle.getString("my.question"));
	}
}
