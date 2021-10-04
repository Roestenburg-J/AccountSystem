package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

//    @GetMapping("/all")
//    @ApiOperation(value = "Gets all account types", notes = "Returns a list of configured accounts")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Members Returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
//        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
//        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
//        return new ResponseEntity<>(response, HttpStatus.OK);

//    @PostMapping("")
//    @ApiOperation(value = "Creates a new account type", notes = "Creates a new Account Type for the account system")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Member was created Successfully", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
//            @ApiParam(value = "Request body to create new Account type.", required = true)
//            @RequestBody AccountTypeDto accountType){
//        AccountTypeDto AccountTypeResponse = createAccountTypeFlow.create(accountType);
//        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, AccountTypeResponse);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
}
