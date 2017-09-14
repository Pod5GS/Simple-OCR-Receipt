package controllers;

import api.TagResponse;
import dao.TagDao;
import generated.tables.records.TagsRecord;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Path("/gettags")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GetTagController {
    final TagDao tags;
    public GetTagController(TagDao tags){
        this.tags = tags;
    }
    @GET
    public List<TagResponse> getAllTags(){
        List<TagsRecord> tagRecords = tags.getAllTags();
        return tagRecords.stream().map(TagResponse::new).collect(toList());
    }
}
