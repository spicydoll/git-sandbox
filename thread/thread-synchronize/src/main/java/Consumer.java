/**
 * Created by fchan on 5/23/2015.
 */
public class Consumer extends Thread
{
    Consumer( Context ctx )
    {
        this.ctx = ctx;
        threadId = threadCnt++;
    }

    @Override
    public void run()
    {
        while( !ctx.die() )
        {
            Message str = ctx.pull();
            if ( str != null )
            {
                System.out.println( "C" + threadId + ": " + str.getMsg() );
            }
            else
            {
                // Sleep 0 allows the scheduler to release time slices
                try
                {
                    Thread.sleep( 0 );
                }
                catch (InterruptedException e)
                {
                }
            }
        }
    }

    private Context ctx;

    // Let's just create a dummy thread ID so we can identify which consumer is running
    private int threadId;
    private static int threadCnt = 0;
}
