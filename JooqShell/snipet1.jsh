import org.jooq.DSLContext;
import io.vavr.control.Try;
var fis = Try.of(() -> new FileInputStream("target/classes/application.properties")).get();
import java.util.Properties;
var prop = new Properties();
prop.load(fis)
fis.close()
prop.list(System.out)
prop.list(System.out)
prop.clear()
prop.list(System.out)