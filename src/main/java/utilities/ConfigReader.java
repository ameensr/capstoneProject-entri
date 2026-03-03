package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public ConfigReader() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		return prop.getProperty("baseUrl");
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

}