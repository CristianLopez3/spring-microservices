package com.easybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold Error Response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path that caused the error",
            example = "/api/accounts"
    )
    private String apiPath;

    @Schema(
            description = "HTTP status code for the error",
            example = "400"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message for the error",
            example = "Bad Request"
    )
    private String errorMessage;

    @Schema(
            description = "Time when the error occurred",
            example = "2021-09-01T12:00:00"
    )
    private LocalDateTime errorTime;

}
