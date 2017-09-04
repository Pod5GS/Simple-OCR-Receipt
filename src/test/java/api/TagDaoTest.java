package api;
import org.h2.jdbcx.JdbcConnectionPool;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import dao.ReceiptDao;
import dao.TagDao;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import java.math.BigDecimal;

public class TagDaoTest {
    @Test
    public void TestTagDao(){
        final String jdbcUrl = "jdbc:h2:mem:test;MODE=MySQL;INIT=RUNSCRIPT from 'classpath:schema.sql'";
        JdbcConnectionPool cp = JdbcConnectionPool.create(jdbcUrl, "sa", "sa");
        org.jooq.Configuration jooqConfig = new DefaultConfiguration();
        jooqConfig.set(SQLDialect.MYSQL);   // Lets stick to using MySQL (H2 is OK with this!)
        jooqConfig.set(cp);
        ReceiptDao receiptDao = new ReceiptDao(jooqConfig);
        TagDao tagDao = new TagDao(jooqConfig);
        // Create two Receipts
        receiptDao.insert("Trader Joes", BigDecimal.valueOf(22.04));
        receiptDao.insert("Best Buy", BigDecimal.valueOf(816.5));
        // Tag Receipts
        tagDao.toggleTag(receiptDao.getReceiptByMerchant("Trader Joes").getId(), "Grocery");
        tagDao.toggleTag(receiptDao.getReceiptByMerchant("Best Buy").getId(), "Electronics");
        // Check
        List<Integer> grocery = tagDao.getReceiptsByTagName("Grocery");
        List<Integer> electronics = tagDao.getReceiptsByTagName("Electronics");
        Assert.assertEquals(grocery.size(), 1);
        Assert.assertEquals(electronics.size(), 1);
        // Untag grocery
        tagDao.toggleTag(receiptDao.getReceiptByMerchant("Trader Joes").getId(), "Grocery");
        // Check
        grocery = tagDao.getReceiptsByTagName("Grocery");
        Assert.assertEquals(grocery.size(), 0);
    }
}
