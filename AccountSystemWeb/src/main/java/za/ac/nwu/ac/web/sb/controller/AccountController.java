package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    private final FetchAccountFlow fetchAccountFlow;
    private final CreateAccountFlow createAccountFlow;

    @Autowired
    public AccountController(FetchAccountFlow fetchAccountFlow, @Qualifier("createAccountFlowName") CreateAccountFlow createAccountFlow) {
        this.fetchAccountFlow = fetchAccountFlow;
        this.createAccountFlow = createAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all Accounts", notes = "Returns a list of accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountDto>>> getAll() {
        List<AccountDto> accounts = fetchAccountFlow.getAllAccounts();
        GeneralResponse<List<AccountDto>> response = new GeneralResponse<>(true, accounts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Account", notes = "Creates a new Account for the account system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountDto>> create(
            @ApiParam(value = "Request body to create new Account.", required = true)
            @RequestBody AccountDto account) {
        AccountDto AccountResponse = createAccountFlow.create(account);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, AccountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{balance}")
    @ApiOperation(value = "Returns the balance of an Account", notes = "Returns the balance of a specific account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Balance was returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountDto>> getBalance(
            @ApiParam(value = "Account ID",
                    example = "1",
                    name = "ID",
                    required = true)
            @PathVariable("ID") final String id) {

        AccountDto account = fetchAccountFlow.getBalanceForAccount(id);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{subtract}")
    @ApiOperation(value = "Subtracts an Account", notes = "Subtracts from the balance of an account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account subrtacted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountDto>> subtractAccount(
            @ApiParam(value = "Account ID",
                    example = "1",
                    name = "ID",
                    required = true)
            @PathVariable("ID") final Long id,
            @ApiParam(value = "Value",
                    example = "200.50",
                    name = "value",
                    required = true)
            @PathVariable("ID") final float value) {

        AccountDto account = fetchAccountFlow.subtractAccount(id, value);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{add}")
    @ApiOperation(value = "Add to an Account", notes = "Adds to the balance of an account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account balance increased", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountDto>> addToAccount(
            @ApiParam(value = "Account ID",
                    example = "1",
                    name = "ID",
                    required = true)
            @PathVariable("ID") final Long id,
            @ApiParam(value = "Value",
                    example = "200.50",
                    name = "value",
                    required = true)
            @PathVariable("ID") final float value) {

        AccountDto account = fetchAccountFlow.addToAccount(id, value);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
