/**
 * Created by fchan on 5/22/2015.
 */
public class thread_application
{
    public static void main ( String [] args )
    {
        // Create the threads
        //      two consumers
        //      one producer

        // Attach the thread object to the context

        // Start the threads, who goes first?

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

        // Wait for termination
        System.out.println( "Waiting for termination..." );

        System.out.println( "Exiting..." );
    }
}
