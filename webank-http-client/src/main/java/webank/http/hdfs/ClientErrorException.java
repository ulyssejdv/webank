package webank.http.hdfs;

/**
 * Created by ulysse on 14/12/2017.
 */
public class ClientErrorException extends Exception {
    public ClientErrorException(String msg) {
        super(msg);
    }
}
