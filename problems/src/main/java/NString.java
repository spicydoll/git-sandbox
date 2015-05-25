/**
 * Created by fchan on 5/24/2015.
 */
public class NString
{
    public String replace_r( String in,
                                    char oldCh,
                                    char newCh )
    {
        StringBuilder str = new StringBuilder( );
        if ( in.length( ) == 0 )
        {
            return "";
        }
        str.insert( 0,
                    replace_r(in.substring(1,
                                    in.length()),
                            oldCh,
                            newCh) );

        if ( in.charAt(0) == oldCh )
        {
            return str.insert( 0,
                               newCh ).toString( );
        }
        return str.insert( 0,
                           in.charAt(0) ).toString( );

    }

    public String replace( String in,
                           char oldCh,
                           char newCh )
    {
        StringBuilder str = new StringBuilder( );

        for ( int i = 0; i < in.length(); i++ )
        {
            if ( in.charAt(i) == oldCh )
            {
                str.append( newCh );
            }
            else
            {
                str.append( in.charAt(i) );
            }
        }
        return str.toString();
    }

    public String reverse ( String in )
    {
        if ( in.length() == 0 )
        {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append( reverse( in.substring( 1 ) ) + in.charAt(0) );
        return str.toString();
    }
}
