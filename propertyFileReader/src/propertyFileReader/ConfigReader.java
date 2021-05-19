package propertyFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;
	public ConfigReader() throws Exception
	{
		File path=new File("./properties/config.properties");
		FileInputStream fin=new FileInputStream(path);
		pro=new Properties();
		pro.load(fin);
		
	}
	public String getbrowserpath()
	{
		return pro.getProperty("chromepath");
	}
	public String geturl()
	{
		return pro.getProperty("url");
	}
	public String getusername()
	{
		return pro.getProperty("username");
	}
	public String getpassword()
	{
		return pro.getProperty("password");
	}
	public String getscreenshot()
	{
		return pro.getProperty("screenshotpath");
	}
	public String gethtmlreport()
	{
		return pro.getProperty("htmlpath");
	}
	
	

}
