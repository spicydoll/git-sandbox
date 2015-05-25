/**
 * Created by fchan on 5/24/2015.
 */
public class Prime
{
    public boolean isPrime_bruteForce( int val )
    {
        for ( int i = 2; i < val; i++ )
        {
            if ( val % i == 0 )
            {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime_simpleSquare( int val )
    {
        int maxfactor = (int)Math.floor( Math.sqrt( (double)val ) ) + 1;
        for ( int i = 2; i < maxfactor; i++ )
        {
            if ( val % i == 0 )
            {
                return false;
            }
        }
        return true;
    }
}
