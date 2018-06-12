package co.aisystem.demo.ext.sb2.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Transaction;
import org.jooq.TransactionContext;
import org.jooq.TransactionProvider;
import org.jooq.exception.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.springframework.transaction.TransactionDefinition.PROPAGATION_NESTED;

@RequiredArgsConstructor
@Slf4j
public class PolygeneTransactionProvider implements TransactionProvider {

//    private final TransactionProvider delegate;

    private final  DataSourceTransactionManager txMgr;

    @Override
    public void begin(TransactionContext ctx) throws DataAccessException {
        log.debug("\"------------------------------> begin( " + ctx + " )");
        TransactionStatus tx = txMgr.getTransaction(new DefaultTransactionDefinition(PROPAGATION_NESTED));
        ctx.transaction(new SpringTransaction(tx));
    }

    @Override
    public void commit(TransactionContext ctx) throws DataAccessException {
        log.debug("------------------------------> commit( " + ctx + " )");
        txMgr.commit(((SpringTransaction) ctx.transaction()).tx);
    }

    @Override
    public void rollback(TransactionContext ctx) throws DataAccessException {
        log.debug("\"------------------------------> rollback( " + ctx + " )");
        txMgr.rollback(((SpringTransaction) ctx.transaction()).tx);
    }


    static class SpringTransaction implements Transaction {
        final TransactionStatus tx;

        SpringTransaction(TransactionStatus tx) {
            this.tx = tx;
        }
    }
}
