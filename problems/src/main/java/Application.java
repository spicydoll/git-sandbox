import java.util.ArrayList;

/**
 * Created by fchan on 5/24/2015.
 */
public class Application
{
    public static void main( String [] args )
    {
        // String manipulations
        {
            NString nstr = new NString();

            String str = nstr.replace_r("helloworld",
                    'o',
                    'w');
            System.out.println("replace recurse:" + str + ":");

            String str2 = nstr.replace("helloworld",
                    'o',
                    'w');
            System.out.println("replace :" + str2 + ":");

            String str3 = nstr.reverse("helloworld");
            System.out.println("reverse :" + str3 + ":");
        }

        // Test for primality
        {
            Numbers num = new Numbers();
            System.out.println("brute 7 is prime :" + num.isPrime_bruteForce(7));
            System.out.println("simplesq 7 is prime :" + num.isPrime_simpleSquare(7));
            System.out.println("brute 256 is prime :" + num.isPrime_bruteForce(256));
            System.out.println("simplesq 256 is prime :" + num.isPrime_simpleSquare(256));
        }

        // Swap two numbers without a third number
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(6);
            list.add(9);

            Numbers num = new Numbers();
            System.out.println("Before: " + list.get(0) + "," + list.get(1) );
            num.swap(list);
            System.out.println("After: " + list.get(0) + "," + list.get(1) );
        }

        // Find the middle of the node
        {
            NLinkedList<Integer> list = new NLinkedList<Integer>();

            list.push_back( new NLinkedList.Node<Integer>(1) );
            list.push_back( new NLinkedList.Node<Integer>(2) );
            list.push_back( new NLinkedList.Node<Integer>(3) );
            list.push_back( new NLinkedList.Node<Integer>(4) );
            list.push_back( new NLinkedList.Node<Integer>(5) );

            System.out.println("Middle: 1,2,3,4,5 = 3 ? " + list.middle().data() );

            NLinkedList<Integer> list2 = new NLinkedList<Integer>();

            list2.push_back( new NLinkedList.Node<Integer>(1) );
            list2.push_back( new NLinkedList.Node<Integer>(2) );
            list2.push_back( new NLinkedList.Node<Integer>(3) );
            list2.push_back( new NLinkedList.Node<Integer>(4) );
            System.out.println("Middle: 1,2,3,4 = 2 ? " + list2.middle().data() );
        }
    }
}
