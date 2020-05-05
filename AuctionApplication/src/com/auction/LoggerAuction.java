
  package com.auction;
  
  
  import java.io.IOException; import java.util.logging.FileHandler; import
  java.util.logging.Formatter; import java.util.logging.Level; import
  java.util.logging.Logger; import java.util.logging.SimpleFormatter;
  
  
  
  public class LoggerAuction {
	  static Logger logger = Logger.getLogger("MyLoggerName"); 
	  public static void setup() throws
  SecurityException, IOException{ logger.setLevel(Level.INFO);
  
  
  // create text handler 
  boolean append = true; 
  FileHandler txtHandler = new FileHandler("G:/LoggerTxtFile.txt", append); 
  SimpleFormatter txtFormatter = new SimpleFormatter();
  txtHandler.setFormatter(txtFormatter);
  logger.addHandler(txtHandler);
  logger.info("Auction Application Logs");
  
  
  }
  
  
  
  }
 