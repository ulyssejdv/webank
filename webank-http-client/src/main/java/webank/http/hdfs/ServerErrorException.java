package webank.http.hdfs;

/**
 * Created by ulysse on 14/12/2017.
 */
public class ServerErrorException extends Exception {
    public ServerErrorException(String msg) {
        super(msg);
    }
}
