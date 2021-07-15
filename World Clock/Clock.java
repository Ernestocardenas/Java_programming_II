//******************************************************************************
//Imports
//******************************************************************************

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Part I: Implement a class Clock whose getHours, getMinutes and
 * getTime methods return the current time at your location.
 * Return the time as a string.
 *
 * There are two ways to retrieve the current time as a String:
 *
 * 1) Before Java 8 use new Date().toString()
 * 2) With Java 8, you can use 3 classes in the java.time package:
 *    Instant, LocalDateTime and ZoneId. Here's how you do it:
 *    String timeString = LocalDateTime.ofInstant(Instant.now(),
 *                            ZoneId.systemDefault()).toString()
 *
 * With either method, you'll need to extract the hours and
 *   minutes as a substring.
 *
 * Add an alarm feature to the Clock class.
 * When setAlarm(hours, minutes) is called, the clock
 * stores the alarm. When you call getTime, and the alarm
 * time has been reached or exceeded, return the time followed
 * by the string "Alarm" and clear the alarm.
*/

//******************************************************************************
//Code
//******************************************************************************

public class Clock {
    
        private int alarmHours = -1;
        private int alarmMinutes = -1;
        protected LocalDateTime dateTime;  
    
        //setting current time
        String timeString = LocalDateTime.ofInstant(Instant.now(),
                             ZoneId.systemDefault()).toString();

    
   /**
    * Sets the alarm.
    * @param hours hours for alarm
    * @param minutes minutes for alarm
    */
   
    public void setAlarm(int hours, int minutes)
   {
       
       alarmHours = hours;
       alarmMinutes = minutes;

   }

   /**
    * gets current time composed of hours and minutes
    * @return time in string;
    */
   
    public String getTime()
   {
      
       //getting current time string
       String time = currentTime().split("T")[1];
       
       //extracting time portion only
       time = time.substring(0,5);
       
       //checking for alarm
       if(alarmHours !=-1){
          if(Integer.parseInt(getHours()) >= alarmHours) {
              if (Integer.parseInt(getMinutes()) >= alarmMinutes){
            
            //alarm found
            
            alarmHours = -1;
            alarmMinutes = -1;
            
            //returning time with Alarm
            
            return "Alarm" + time;
              
            }
        }
    }
    
    return time;
    
  }   
   /**
    * gets hours
    * @return hours of current time in string
   */
   
    public String getHours()
   {
      //getting time string
       String time = currentTime().split("T")[1];
       time = time.substring(0,5);
       
       //taking and returning the hours part only
       return time.substring(0,2);

   }

   /**
    * gets minutes
    * @return hours of current time in string
   */
   public String getMinutes()
   {
      
    String time = currentTime().split("T")[1];
    time = time.substring(0,5);
    
    //taking and returning the minutes 
    return time.substring(3,5);


   }

   /**
      Returns the current Date and Time as a String.
   */
   private String currentTime()
   {
      return LocalDateTime.ofInstant(Instant.now(),
         ZoneId.systemDefault()).toString();
   }
}
