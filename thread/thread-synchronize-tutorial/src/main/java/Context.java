/**
 * Created by fchan on 5/23/2015.
 */
import java.util.LinkedList;
import java.util.ListIterator;


// Something is wrong with this class.  Remember this class is shared by multiple threads.
public class Context
{
    public void push( Message s )
    {
        q.addLast( s );
    }

    public Message pull( )
    {
        if ( !q.isEmpty() )
        {
            Message msg = q.peekFirst();
            msg.decrementCnt();

            // All messages were consumed so remove from Q.
            if ( msg.getCnt() == 0 )
            {
                q.pop();
            }

            return msg;
        }
        else
        {
            return null;
        }
    }

    public  void terminate( )
    {
        // Change the "die" value
        // Interrupt all the threads (they may be sleeping)
    }

    public boolean die( )
    {
        return die;
    }

    public boolean dead( )
    {
        boolean allDead = true;

        // Check the thread status and return if all are dead?

        return allDead;
    }

    public void attach( Thread thd )
    {
        thdList.add( thd );
    }

    private LinkedList<Message> q = new LinkedList<Message>();
    private LinkedList<Thread> thdList = new LinkedList<Thread>();
    private boolean die = false;
}
