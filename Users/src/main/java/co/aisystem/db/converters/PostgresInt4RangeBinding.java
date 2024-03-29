package co.aisystem.db.converters;

import org.jooq.Binding;
import org.jooq.BindingGetResultSetContext;
import org.jooq.BindingGetSQLInputContext;
import org.jooq.BindingGetStatementContext;
import org.jooq.BindingRegisterContext;
import org.jooq.BindingSQLContext;
import org.jooq.BindingSetSQLOutputContext;
import org.jooq.BindingSetStatementContext;
import org.jooq.Converter;
import org.jooq.lambda.tuple.Range;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.Objects;

import static org.jooq.impl.DSL.val;

public class PostgresInt4RangeBinding implements Binding<Object, Range<Integer>> {
    @Override
    public Converter<Object, Range<Integer>> converter() {
        return new Int4RangeConverter();
    }

    @Override
    public void sql(BindingSQLContext<Range<Integer>> ctx) throws SQLException {
        ctx.render()
                .visit(val(ctx.convert(converter()).value()))
                .sql("::int4range");
    }

    @Override
    public void register(BindingRegisterContext<Range<Integer>> ctx) throws SQLException {
        ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR);
    }

    @Override
    public void set(BindingSetStatementContext<Range<Integer>> ctx) throws SQLException {
        ctx.statement().setString(ctx.index(), Objects.toString(ctx.convert(converter()).value(), null));
    }

    @Override
    public void set(BindingSetSQLOutputContext<Range<Integer>> ctx) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void get(BindingGetResultSetContext<Range<Integer>> ctx) throws SQLException {
        ctx.convert(converter()).value(ctx.resultSet().getString(ctx.index()));
    }

    @Override
    public void get(BindingGetStatementContext<Range<Integer>> ctx) throws SQLException {
        ctx.convert(converter()).value(ctx.statement().getString(ctx.index()));
    }

    @Override
    public void get(BindingGetSQLInputContext<Range<Integer>> ctx) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

}
