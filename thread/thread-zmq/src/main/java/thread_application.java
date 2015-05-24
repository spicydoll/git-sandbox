import org.zeromq.ZMQ;

/**
 * Created by fchan on 5/22/2015.
 */
public class thread_application
{
    public static void main ( String [] args )
    {

        ZMQ.Context ctx = ZMQ.context(1);

        ZMQ.Socket kill = ctx.socket(ZMQ.PUB);
        kill.bind("tcp://*:5557");

        Thread p = new Thread( new Producer(ctx) );
        Thread c1 = new Thread( new Consumer(ctx) );
        Thread c2 = new Thread( new Consumer(ctx) );

        // Start the threads
        p.start();
        c1.start();
        c2.start();

        // Let the threads run for a little bit.
        try
        {
            Thread.sleep( 15000 );
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // Kill threads
        System.out.println( "Send signal for termination..." );
        kill.send( "" );

        // Wait for termination
        System.out.println( "Waiting for termination..." );
        try {
            Thread.sleep( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println( "Exiting..." );
        kill.close();
        ctx.term();
    }
}
