package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
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

    private final FetchAccountFlow fetchAccountTypeFlow;
   // private final CreateAccountFlow createAccountTypeFlow;

    @Autowired
    public AccountController(FetchAccountFlow fetchAccountTypeFlow){//@Qualifier("createAccountFlowName") CreateAccountFlow createAccountTypeFlow) {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
       // this.createAccountTypeFlow = createAccountTypeFlow;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all account types", notes = "Returns a list of configured accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountDto>>> getAll(){
        List<AccountDto> accountTypes = fetchAccountTypeFlow.getAllAccounts();
        GeneralResponse<List<AccountDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//        @PostMapping("")
//        @ApiOperation(value = "Creates a new account type", notes = "Creates a new Account Type for the account system")
//        @ApiResponses(value = {
//                @ApiResponse(code = 200, message = "Account Type was created successfully", response = GeneralResponse.class),
//                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//                @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//        public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
//                @ApiParam(value = "Request body to create new Account type.", required = true)
//                @RequestBody AccountTypeDto accountType){
//            AccountTypeDto AccountTypeResponse = createAccountTypeFlow.create(accountType);
//            GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, AccountTypeResponse);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        }
}
