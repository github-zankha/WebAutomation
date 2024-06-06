package org.selenium.driver;

import org.selenium.enums.DriverType;

public class DriverManagerFactory {
  public static DriverManager_OC getManager(DriverType drivertype)  {
      switch (drivertype){
          case CHROME:{

          // this returns DriverManagerChrome object
              return new DriverManagerChrome();
          }

              case FIREFOX:{
                  return new DriverManagerFireFox();
              }
          case EDGE:{
              return new DriverManagerEdge();
          }
              default: throw new IllegalArgumentException("Invalid DriverType: "+ drivertype);
      }
  }
}
