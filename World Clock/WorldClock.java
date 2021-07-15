//******************************************************************************
//Imports
//******************************************************************************

import java.time.Instant;
import java.time.ZoneOffset;

//******************************************************************************
//Code
//******************************************************************************


public class WorldClock extends Clock
{
   public WorldClock(int offst) {

        super();

        //creating an Offset with the given offset hours

        ZoneOffset offset=ZoneOffset.ofHours(offst);

        //updating current time to match the offset time

        dateTime=Instant.now().atOffset(offset).toLocalDateTime();

    }

}
