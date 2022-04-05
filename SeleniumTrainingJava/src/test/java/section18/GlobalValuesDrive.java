package section18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("/Users/diemonte/Desktop/SeleniumTraining/SeleniumTrainingJava/src/test/java/section18/data.properties");
        properties.load(file);
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
        System.out.println(browser);
        System.out.println(url);
        properties.setProperty("browser","Firefox");
        System.out.println(browser = properties.getProperty("browser"));
        FileOutputStream out = new FileOutputStream("/Users/diemonte/Desktop/SeleniumTraining/SeleniumTrainingJava/src/test/java/section18/data.properties");
        properties.store(out,null);
    }
}