/**
 * Created by fchan on 5/25/2015.
 */
public class NLinkedList<T1>
{

    public void push_back( Node<T1> node )
    {
        if ( head ==  null )
        {
            head = node;
        }

        if ( tail != null )
        {
            tail.setNext(node);
        }
        tail = node;

    }

    public Node<T1> head() { return this.head; }
    public Node<T1> tail() { return this.tail; }

    public Node<T1> middle( )
    {
        Node<T1> current = this.head;
        Node<T1> mid = this.head;
        int cnt = 0;
        if ( current == null )
        {
            return null;
        }

        while ( current.next() != null )
        {
            cnt++;
            if (cnt % 2 == 0)
            {
                mid = mid.next();
            }
            current = current.next();
        }
        return mid;
    }

    public static class Node<T1>
    {
        Node( T1 val )
        {
            data = val;
        }

        // Functions
        public Node<T1> next() { return n; }
        public T1 data() { return data; }

        public void setNext( Node<T1> node ) { n = node; }
        public void setData( T1 data ) { this.data = data; }

        // Variables
        private Node n = null;
        private T1 data;
    }

    private Node<T1> head = null;
    private Node<T1> tail = null;

}
