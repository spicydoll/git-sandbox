/**
 * Created by fchan on 5/23/2015.
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class Context
{
    public synchronized void push( Message s )
    {
        q.addLast( s );
    }

    public synchronized Message pull( )
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

    public synchronized void terminate( )
    {
        die = true;

        // Interrupt all the threads (they may be sleeping)
        ListIterator<Thread> it = thdList.listIterator();
        while ( it.hasNext() )
        {
            it.next().interrupt();
        }
    }

    public synchronized boolean die( )
    {
        return die;
    }

    public synchronized boolean dead( )
    {
        boolean allDead = true;

        // Check the thread status
        ListIterator<Thread> it = thdList.listIterator();
        while ( it.hasNext() )
        {
            if ( it.next().isAlive() )
            {
                allDead = false;
            }
        }
        return allDead;
    }

    public synchronized void attach( Thread thd )
    {
        thdList.add( thd );
    }

    private LinkedList<Message> q = new LinkedList<Message>();
    private LinkedList<Thread> thdList = new LinkedList<Thread>();
    private boolean die = false;
}
