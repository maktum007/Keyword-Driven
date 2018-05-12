package keyword.driven.framework;

import org.openqa.selenium.By;

public class LocatorReprository {
	public static By values(String loctype, String locvalue) 
	{
		By loc;
		switch (loctype) 
		{
		case "id":
			loc = By.id(locvalue);
			break;
		case "xpath":
			loc = By.xpath(locvalue);
			break;
		case "name":
			loc = By.name(locvalue);
			break;
		case "linkText":
			loc = By.linkText(locvalue);
			break;
		default:
			loc = null;
			break;
		}
		return loc;
	}

}
