package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.service.GeneralResponse;

@RestController
@RequestMapping("za.ac.nwu.ac.web.sb.controller.AccountTypeController")
public class AccountTypeController {

    @GetMapping("/all")
    @ApiOperation(value = "Return general Response", notes = "Returns a general response when calling a controller")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The controller was called", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public GeneralResponse<String> getAll() {return new GeneralResponse<String>( true, "No types found");}

}
