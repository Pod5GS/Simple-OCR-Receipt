package dao;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;

import static generated.Tables.TAGS;

public class TagDao {
    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public void toggleTag(int receiptId, String tagName){
        int deletionStatus = dsl
                .delete(TAGS)
                .where(TAGS.RECEIPT_ID.eq(receiptId).and(TAGS.NAME.eq(tagName)))
                .execute();

        if (deletionStatus == 0){
            dsl.insertInto(TAGS, TAGS.RECEIPT_ID, TAGS.NAME).values(receiptId, tagName).execute();
        }
    }

    public List<Integer> getReceiptsByTagName(String tagName){
        return dsl.selectFrom(TAGS).where(TAGS.NAME.eq(tagName)).fetch(TAGS.RECEIPT_ID);
    }
}
