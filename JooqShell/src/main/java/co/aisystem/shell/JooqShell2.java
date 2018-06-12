package co.aisystem.shell;

import co.aisystem.demo.api.db.users.tables.records.PersonRecord;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.control.Try;
import io.vavr.*;
import lombok.experimental.var;
import lombok.val;
import org.jooq.*;
import org.jooq.impl.DefaultDSLContext;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

import static co.aisystem.demo.api.db.users.Tables.PERSON;
import static org.jooq.impl.DSL.*;

public class JooqShell2 {
    final static String PATH_PROPERTIES = "JooqShell/target/classes/datasource.properties";

    public static    void main(String[] args) {
        JooqShell2 dslForUsers = new JooqShell2();
        final DSLContext dsl = dslForUsers.createContext();

        final SelectWhereStep<PersonRecord> personSelect = dsl.selectFrom(PERSON);

        Function4<DSLContext, Table<?>, Field<?>, Field<?>, Table<?>> pivot = dslForUsers::pivot;
        final Function3<Table<?>, Field<?>, Field<?>, Table<?>> appliedDsl = pivot.apply(dsl);
        final Function1<Table<?>, Function1<Field<?>, Function1<Field<?>, Table<?>>>> curriedDsl = appliedDsl.curried();

//        val pivotDsl = curriedDsl.apply(personSelect.asTable("persons"));


        final Function1<Field<?>, Function1<Field<?>, Table<?>>> personsTab = curriedDsl.apply(personSelect.asTable("persons"));

        final Function1<DSLContext, Function1<Table<?>, Function1<Field<?>, Function1<Field<?>, Table<?>>>>> curried1 = pivot.curried();
//        list = List.ofAll(pResult)

        Function4<DSLContext, Table<?>, Field<String>, Field<?>, ? extends Table<?>> pivot4 = Function4.of(dslForUsers::<String>pivot);
        pivot4.apply(dsl)
                .apply(personSelect.asTable("persons"))
                ;
//        Function4.of(dslForUsers::<String>pivot)
//                .apply(dsl)
//                .apply(personSelect.asTable("persons"));

//       <DSLContext, Field<String>>
        Field<String> f = personSelect.field(PERSON.NAME);
        Class<String> type = f.getType();
//        Table<?> applydF = Function2.of(dslForUsers::<String>pivotT)
////                .curried()
//                .apply(dsl)
//                .apply(personSelect.field(f));


    }

    public <S> Table<?> pivotT(DSLContext dsl, Field<S> pField){
        return null;
    }

    public <T> Table<?> pivot(DSLContext dsl, Table<?> query, Field<T> pField, Field<?> oField) {

        final java.util.List<T> fieldsP = dsl.selectDistinct(pField)
                .from(query)
                .fetch(pField);

        final List<Field<Integer>> fieldList = List.ofAll(fieldsP)
                .map(fs ->
                        count()
                                .filterWhere(pField.eq(fs))// condition("? = ? ", pField, fs))//pField.eq(fs))
//                                .over()
//                                .partitionBy(pField)
                                .as(fs.toString()))
                .collect(List.collector());


        return dsl.select(
                List.<Field<?>>of(oField)
                        .appendAll(fieldList)
                        .toJavaList()
        )
                .from(query)
                .groupBy(oField)
                .asTable("pivot_table");
    }

    public DSLContext createContext() {

        FileInputStream fis = Try.of(() -> new FileInputStream(PATH_PROPERTIES)).get();
        Properties prop = new Properties();
        Try.run(() -> prop.load(fis));
        prop.list(System.out);

        Properties p1 = limitOnlyDatasourceProp(prop);
        HikariConfig hc = new HikariConfig(p1);
        DataSource ds = new HikariDataSource(hc);
        return new DefaultDSLContext(ds, SQLDialect.POSTGRES_9_5);
    }

    private Properties limitOnlyDatasourceProp(Properties prop) {
        Properties prop1 = new Properties();
        prop1.putAll(
                HashMap.ofAll(prop)
                        .map(t -> t.map1(Object::toString))
                        .filter(t -> t._1.contains("datasource"))
                        .map(t -> t.map1(this::cutKeyDataSource))
                        .collect(HashMap.collector())
                        .toJavaMap()
        );
        return prop1;
    }

    private String cutKeyDataSource(String key) {
        return key.substring("users.datasource.".length());
    }
}
