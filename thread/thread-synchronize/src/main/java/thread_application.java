/**
 * Created by fchan on 5/22/2015.
 */
public class thread_application
{
    public static void main ( String [] args )
    {
        Context ctx = new Context();
        Producer p = new Producer(ctx);
        Consumer c1 = new Consumer(ctx);
        Consumer c2 = new Consumer(ctx);

        // Attach the thread object to the context
        ctx.attach( p );
        ctx.attach( c1 );
        ctx.attach( c2 );

        // Start the threads
        c1.start();
        c2.start();
        p.start();

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
        ctx.terminate();

        // Wait for termination
        System.out.println( "Waiting for termination..." );
        while ( !ctx.dead() );

        System.out.println( "Exiting..." );
    }
}
