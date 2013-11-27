package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import create.MyWeatherTest;

public class ConfigPropertiesUtil {
    private static Logger log = Logger.getLogger(ConfigPropertiesUtil.class); ;

    public String[] getProperty(String key) {
        Properties prop = new Properties();
        String[] arrString = null ;
        try {
            String path = MyWeatherTest.class.getResource("../").getPath() + "WEB-INF\\classes\\properties\\relate.properties";
            prop.load(new FileInputStream(new File(path)));
        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
        String all_data = prop.getProperty(key);
        if(all_data.indexOf(";") > 0) {
        	String[] each_user_one = all_data.split(";");
        	int task_num = each_user_one.length;
        	arrString = new String[task_num*2];
        	int index = 0;
        	for(int i = 0; i<task_num; i++) {
        		arrString[index++] = each_user_one[i].split(",", 2)[0];
        		arrString[index++] = each_user_one[i].split(",", 2)[1];
        	}
        } else {
        	 arrString = all_data.split(",",2);	
        }
        for(String s: arrString) {
        	System.out.println(s);
        }
        return arrString;
    }
}
