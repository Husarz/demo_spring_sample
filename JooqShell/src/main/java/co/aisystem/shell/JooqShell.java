package co.aisystem.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@Slf4j
public class JooqShell {

    public static void main(String[] args) {
        SpringApplication.run(JooqShell.class, args);
    }

//    @Configuration
//    public class DslUsers {
//
//        DSLContext dslContext(){
//
//
//            Connection connection;
//            return new  DSLContext(connection, SQLDialect.POSTGRES_9_5)
//        }
//
//    }
}
