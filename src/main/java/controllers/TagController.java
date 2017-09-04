package controllers;

import api.ReceiptResponse;
import dao.ReceiptDao;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags/{tag}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final ReceiptDao receipts;
    final TagDao tags;

    public TagController(ReceiptDao receipts, TagDao tags){
        this.receipts = receipts;
        this.tags = tags;
    }

    @PUT
    public void toggleTag(String request_body, @PathParam("tag") String tagName){
        tags.toggleTag(Integer.parseInt(request_body), tagName);
    }

    @GET
    public List<ReceiptResponse> getReceiptByTagName(@PathParam("tag") String tagName){
        List<ReceiptsRecord> receiptRecords = receipts.getAllReceipts();
        List<Integer> receiptIds = tags.getReceiptsByTagName(tagName);
        return receiptRecords
                .stream()
                .filter(receiptRecord -> receiptIds.contains(receiptRecord.getId()))
                .map(ReceiptResponse::new)
                .collect(toList());
    }
}
