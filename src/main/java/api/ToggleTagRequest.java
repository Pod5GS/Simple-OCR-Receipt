package api;


import javax.validation.constraints.NotNull;

public class ToggleTagRequest {
    @NotNull
    public int receipt_id;
}
