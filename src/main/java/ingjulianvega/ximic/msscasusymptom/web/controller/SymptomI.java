package ingjulianvega.ximic.msscasusymptom.web.controller;


import ingjulianvega.ximic.msscasusymptom.web.model.ApiError;
import ingjulianvega.ximic.msscasusymptom.web.model.Symptom;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomDto;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface SymptomI {

    @Operation(summary = "Endpoint to get the list of symptoms", description = "Returns a list of symptoms", tags = {"symptom"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = SymptomList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<SymptomList> get(@Parameter(in = ParameterIn.QUERY, description = "The using of cache", required = true, schema = @Schema()) Boolean usingCache);

    @Operation(summary = "Endpoint to get the information of a symptom given the id", description = "Returns a symptom", tags = {"symptom"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = SymptomDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<SymptomDto> getById(@Parameter(in = ParameterIn.PATH, description = "The symptom type id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

    @Operation(summary = "Endpoint to create a symptom", description = "Creates a new symptom", tags = {"symptom"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "symptom types's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Symptom symptom);

    @Operation(summary = "Endpoint to update the information of a symptom given the id", description = "Updates a symptom", tags = {"symptom"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The symptom id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "symptom's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Symptom symptom);


    @Operation(summary = "Endpoint to delete a symptom", description = "Deletes a symptom", tags = {"symptom"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The symptom id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}
