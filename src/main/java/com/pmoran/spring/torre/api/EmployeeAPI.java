package com.pmoran.spring.torre.api;

import com.pmoran.spring.torre.model.EmployeeDTO;
import com.pmoran.spring.torre.model.ErrorMessageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ankit Patel
 * @implNote Employee related API
 */
@Tag(name = "Employee", description = "Employee Management API")
@RequestMapping(EmployeeAPI.BASE_URL)
public interface EmployeeAPI {

    public static final String BASE_URL = "/employee";

    @Operation(summary = "Get All Employee", description = "Get All Employee")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeeDTO.class)))}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessageDTO.class), examples = {
                            @ExampleObject(name = "Error", value = "{}")})})})
    @GetMapping(value = "/getAll", produces = {"application/json"})
    ResponseEntity<List<EmployeeDTO>> getAllEmployee();

    @Operation(summary = "Save Employee", description = "Create new Employee")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessageDTO.class), examples = {
                            @ExampleObject(name = "Error", value = "{}")})}), @ApiResponse(responseCode = "409", description = "Duplicate Email Found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessageDTO.class), examples = {
                    @ExampleObject(name = "Error", value = "{}")})})})

    @PostMapping(value = "/save", produces = {"application/json"})
    ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO);

    @Operation(summary = "Update Employee", description = "Update existing employee Using Employee ID")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessageDTO.class), examples = {
                            @ExampleObject(name = "Error", value = "{}")})})})
    @PutMapping(value = "/update/{id}", produces = {"application/json"})
    ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO);

    @Operation(summary = "Delete Employee", description = "Delete existing employee Using Employee ID")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessageDTO.class), examples = {
                            @ExampleObject(name = "Error", value = "{}")})})})
    @DeleteMapping(value = "/delete/{id}", produces = {"application/json"})
    ResponseEntity<String> deleteEmployee(@PathVariable Long id);
}
