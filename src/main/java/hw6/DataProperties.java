package hw6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProperties {
    private static Properties dataProperties;

    static {
        dataProperties = new Properties();
        try{
            InputStream input = new FileInputStream("src/test/resources/hw6/config.properties");
            dataProperties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Properties getDataProperty(){
        return dataProperties;
    }
}
