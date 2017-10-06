package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * Represents the result of an OCR parse
 */
public class ReceiptSuggestionResponse {
    @JsonProperty
    public final String merchantName;

    @JsonProperty
    public final BigDecimal amount;

    @JsonProperty
    public final Integer tl_x;

    @JsonProperty
    public final Integer tl_y;

    @JsonProperty
    public final Integer br_x;

    @JsonProperty
    public final Integer br_y;


    public ReceiptSuggestionResponse(String merchantName, BigDecimal amount, Integer tl_x, Integer tl_y, Integer br_x, Integer br_y) {
        this.merchantName = merchantName;
        this.amount = amount;
        this.tl_x = tl_x;
        this.tl_y = tl_y;
        this.br_x = br_x;
        this.br_y = br_y;
    }
}
