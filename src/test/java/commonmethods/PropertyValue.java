package commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyValue {

	public static String getProperty(String key) throws IOException {
		Properties properties = new Properties();
		String propertiesFilePathString = System.getProperty("user.dir") + "//project.properties";
		FileInputStream file = new FileInputStream(propertiesFilePathString);
		properties.load(file);
		String valueString = properties.getProperty(key).trim();
		return valueString;

	}

}
