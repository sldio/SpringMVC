import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args)
    {
        int i = 10;
        logger.error("test{}", i);
        logger.info("sdfgh");

        String message = "test logging";

        logger.trace(message);
        logger.debug(message);
        logger.info(message);
        logger.warn(message);
        logger.error(message);
    }
}
