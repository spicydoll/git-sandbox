/**
 * Created by fchan on 5/24/2015.
 */
public class Application
{
    public static void main( String [] args )
    {
        NString nstr = new NString();
        Prime p = new Prime();

        String str = nstr.replace_r("helloworld",
                                    'o',
                                    'w');
        System.out.println( "replace recurse:" + str + ":" );

        String str2 = nstr.replace( "helloworld",
                                    'o',
                                    'w');
        System.out.println( "replace :" + str2 + ":" );

        String str3 = nstr.reverse( "helloworld");
        System.out.println( "reverse :" + str3 + ":" );

        System.out.println( "brute 7 is prime :" + p.isPrime_bruteForce( 7 ) );
        System.out.println( "simplesq 7 is prime :" + p.isPrime_simpleSquare(7) );
        System.out.println( "brute 256 is prime :" + p.isPrime_bruteForce( 256 ) );
        System.out.println( "simplesq 256 is prime :" + p.isPrime_simpleSquare( 256 ) );
    }
}
