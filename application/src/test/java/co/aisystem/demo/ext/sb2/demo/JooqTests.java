package co.aisystem.demo.ext.sb2.demo;

import co.aisystem.demo.api.db.users.tables.records.PersonRecord;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TransactionProvider;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Driver;
import java.time.OffsetDateTime;

import static co.aisystem.demo.api.db.users.tables.Person.PERSON;
import static org.jooq.SQLDialect.POSTGRES_9_5;
import static org.jooq.impl.DSL.using;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JooqTests {

    private final static String URL = "jdbc:postgresql://localhost:5432/users";
    private final static String USER = "crm_user";
    private final static String PASSWORD = "crm_user";

    DSLContext dsl;

    private DataSourceTransactionManager txMgr;

    @Before
    public void init_jooq_dsl() {
        Try.run(() -> {

            Driver driver = new org.postgresql.Driver();
            DataSource ds = new SimpleDriverDataSource(driver, URL, USER, PASSWORD);
                    Settings settings = new Settings().withRenderNameStyle(RenderNameStyle.QUOTED);

                    TransactionProvider transactionProvider = new PolygeneTransactionProvider(txMgr);
            txMgr = new DataSourceTransactionManager(ds);
            Configuration configuration = new DefaultConfiguration();
            configuration.set(POSTGRES_9_5)
                    .set(ds)
                    .set(settings)
                    .set(transactionProvider)
            ;
                    dsl = using(configuration);
                }
        );

//        Try.run(() -> dsl =
//                using(getConnection(URL, USER, PASSWORD), POSTGRES_9_5));
    }

    @Test
    public void test_dsl_sample() {
        dsl.select().from(PERSON).fetch();
    }


    @Test
    public void transaction_test() {
        val person = new PersonRecord();
        person.setDate(OffsetDateTime.now().minusYears(10));

        person.setFirstVisit(true);
        person.setName("Gregory");
        person.setSurname("Polak");
        person.setNip("232342323");
        person.setStatus("ACTIVATE");

        dsl.transaction(() ->
                dsl.insertInto(PERSON)
                        .set(person)
                        .execute()
        );

//        log.debug("insertResult: {}", insertResult);
    }

}
