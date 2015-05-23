import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fchan on 5/23/2015.
 */
public class Producer extends Thread
{
    Producer( Context ctx )
    {
        this.ctx = ctx;
    }

    @Override
    public void run()
    {
        while ( !ctx.die() )
        {
            // Let's push little time stamps to the consumers
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            String reportDate = df.format( today );
            ctx.push( new Message( reportDate,
                                   2 ) );

            // Let's sleep a little
            try
            {
                Thread.sleep( 1000 );
            }
            catch (InterruptedException e)
            {
            }
        }

    }

    private Context ctx;
}
