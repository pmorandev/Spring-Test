package com.pmoran.spring.torre.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pmoran.spring.torre.model.ErrorMessageDTO;
import com.pmoran.spring.torre.model.TestDTO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RequestMapping(ApplicationAPI.BASE_URL)
public interface ApplicationAPI {
    
    public static final String BASE_URL = "/application";

    @ApiResponses({ @ApiResponse(responseCode = "200", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = TestDTO.class)) }),
        @ApiResponse(responseCode = "500", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessageDTO.class), examples = {
                        @ExampleObject(name = "Error", value = "{}") }) }) })
    @GetMapping(value = "/test", produces = {"application/json"})
    ResponseEntity<TestDTO> getTestMessageInfo();

}
