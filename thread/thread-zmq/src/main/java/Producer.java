import org.zeromq.ZMQ;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fchan on 5/23/2015.
 */
public class Producer implements Runnable
{
    Producer( ZMQ.Context ctx )
    {
        this.ctx = ctx;
    }

    public void run()
    {

        ZMQ.Socket publisher = ctx.socket(ZMQ.PUB);
        publisher.bind("tcp://*:5556");

        ZMQ.Socket kill = ctx.socket(ZMQ.SUB);
        kill.connect("tcp://localhost:5557");
        String filter = "";
        kill.subscribe( filter.getBytes() );

        ZMQ.Poller items = new ZMQ.Poller (1);
        items.register(kill, ZMQ.Poller.POLLIN);

        System.out.println("Publisher: Up.");
        while ( true )
        {
            try
            {
                // Let's push little time stamps to the consumers
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date today = Calendar.getInstance().getTime();
                String reportDate = df.format(today);

                publisher.send( reportDate, 0);

                // Let's sleep a little
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                break;
            }

            items.poll(1);
            if ( items.pollin(0) )
            {
                kill.recvStr().trim();
                break;
            }

        }

        publisher.close();
        kill.close();
        System.out.println("Publisher: Terminated.");

    }

    private ZMQ.Context ctx;
}
