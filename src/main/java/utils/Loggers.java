package utils;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.util.Date;

public class Loggers {
    public static Logger log = Logger.getLogger(Loggers.class.getName());

    static {
        Date d = new Date();
        System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
        System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
        //System.setProperty("log4j.configurationFile", "./resources/log4j2.properties");
        PropertyConfigurator.configure("./src/test/resources/properties/log4j2.properties");
    }


    //public static Logger log = LogManager.getLogger(Loggers.class.getName());


}
