package com.easybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful Response information"
)
public class ResponseDto {

    @Schema(description = "Status code for the response")
    private String statusCode;

    @Schema(description = "Status message for the response")
    private String statusMessage;


}
