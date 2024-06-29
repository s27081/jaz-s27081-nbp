package com.example.jaz_s27081_nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/cur")

public class CurrencyController {

        private final CurrencyService currencyService;

        public CurrencyController(CurrencyService currencyService) {
            this.currencyService = currencyService;
        }

    @Operation(summary= "Show average currency price", description= "Calling this endpoint allows us to get average currency price between two dates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CurrencyData.class))),
            @ApiResponse(responseCode = "404", description = "Currency not found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", description = "Bad request przekroczony limit - Exceeding request limit will result with this code", content = @Content(schema = @Schema(hidden = true)))})

        @GetMapping("/{currency}/{dateFrom}/{dateTo}")
        public ResponseEntity<CurrencyData> getCurrency(@PathVariable("currency") String currencyId, @PathVariable("dateFrom") LocalDate dateFrom, @PathVariable("dateTo") LocalDate dateTo){
            CurrencyData db = currencyService.calculateCurrency(currencyId, dateFrom, dateTo);
            return ResponseEntity.ok(db);

        }
    }
