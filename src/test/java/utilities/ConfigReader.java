package utilities;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;
    private static File file;
    private static ConfigReader configReader;
    private static String randomNumber;
    public static HashMap<String, Object> globalTestData = new HashMap<String, Object>();//Creating HashMap

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getProperty(String propertyName) {
        file = new File("./src/test/resources/configurations/authorisation.properties");
        properties = new Properties();
        String expectedValue=null;
        System.out.println("Startedthemethod");
        try {
            FileInputStream fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
            expectedValue = properties.getProperty(propertyName);
            System.out.println(expectedValue);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedValue;
    }

}