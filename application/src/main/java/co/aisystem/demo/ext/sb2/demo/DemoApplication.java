package co.aisystem.demo.ext.sb2.demo;

import co.aisystem.demo.api.db.users.tables.records.PersonRecord;
import io.vavr.collection.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Queries;
import org.jooq.Query;
import org.jooq.SelectWhereStep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static co.aisystem.demo.api.db.users.Public.PUBLIC;
import static co.aisystem.demo.api.db.users.tables.Person.PERSON;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner schema(DSLContext dsl) {
        return __ -> {
            Queries ddl = dsl.ddl(PUBLIC);
            log.info("schema: {}", dsl.informationSchema(PUBLIC).toString());
            List.of(ddl.queries())
                    .map(Query::getSQL)
                    .forEach(log::info);
        };
    }

    @Bean
    CommandLineRunner reportPerson(DSLContext dsl) {
        SelectWhereStep<PersonRecord> personRecords = dsl.selectFrom(PERSON);
        personRecords.fetch();

        return __ -> {
            personRecords.fetch();
        };
    }

}
