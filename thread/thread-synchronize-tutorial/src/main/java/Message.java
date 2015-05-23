/**
 * Created by fchan on 5/23/2015.
 */

// This class is ok... so just leave it alone.
public class Message
{
    Message( String msg, int cnt )
    {
        this.msg = msg;
        this.cnt = cnt;
    }

    public String getMsg()
    {
        return msg;
    }

    public int getCnt()
    {
        return cnt;
    }

    public void decrementCnt( )
    {
        if ( cnt != 0 )
        {
            cnt--;
        }
    }

    private String msg;
    private int cnt;
}
