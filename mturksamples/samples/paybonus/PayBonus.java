/*
 * Copyright 2007-2008 Amazon Technologies, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */ 


package paybonus;

import com.amazonaws.mturk.service.axis.RequesterService;
import com.amazonaws.mturk.service.exception.ServiceException;
import com.amazonaws.mturk.util.PropertiesClientConfig;
import com.amazonaws.mturk.requester.HIT;

public class PayBonus {

  /**
   * Main method
   * 
   */
  public static void main(String[] args) {
	  
	RequesterService service = new RequesterService(new PropertiesClientConfig("../mturk.properties"));

	// parse the input or something
	System.out.println("Opened requester.");
	  
	  
      try {
    		String assignid = args[0];//"2C21QP6AUC26ERQ7ZEO3Y0FK0QG81X";
    		String workerid = args[1];//"A27ANNY9E0URA2";
    		Double bonusamt = Double.parseDouble(args[2]); //0.50;
    		String reason   = args[3]; //"because i'm awesome that's why";    		    		
    		
    		System.out.println("Tryign to construct a grant bonus request.");
    		service.grantBonus(workerid,bonusamt,assignid,reason);
    		System.out.println("Complete.");
    		
    		
      } catch (Exception e) {
	          System.err.println("Please call function as:\n java PayBonus _assignment id_ _worker id_ _bonus amount_ _reason_");
	          System.exit(1);
      }
   }
}
