import org.zeromq.ZMQ;

import java.io.IOException;

/**
 * Created by fchan on 5/23/2015.
 */
public class Consumer implements Runnable
{
    Consumer( ZMQ.Context ctx )
    {
        this.ctx = ctx;
        threadId = threadCnt++;
    }

    public void run()
    {
        ZMQ.Socket subscriber = ctx.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        String filter = "";
        subscriber.subscribe( filter.getBytes() );

        ZMQ.Socket kill = ctx.socket(ZMQ.SUB);
        kill.connect("tcp://localhost:5557");
        kill.subscribe( filter.getBytes() );

        ZMQ.Poller items = new ZMQ.Poller (2);
        items.register(subscriber, ZMQ.Poller.POLLIN);
        items.register(kill, ZMQ.Poller.POLLIN);

        String str;
        System.out.println("C" + threadId + ": Up.");
        while( true )
        {
            items.poll();

            // Check the subscriber
            if (items.pollin(0))
            {
                str = subscriber.recvStr(0).trim();
                System.out.println("C" + threadId + ": " + str);
            }

            // Check the kill signal
            if ( items.pollin(1) )
            {
                break;
            }
        }

        subscriber.close();
        kill.close();
        System.out.println("C" + threadId + ": Terminated.");
    }

    private ZMQ.Context ctx;

    // Let's just create a dummy thread ID so we can identify which consumer is running
    private int threadId;
    private static int threadCnt = 0;
}
