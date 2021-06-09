import org.testng.annotations.Test;

public class QuckTest extends TestBase{

    @Test(groups = {"my", "pay"})
    public void quckTest(){
        logger.info("Passed quick");

    }
}
