package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;

import java.util.List;

@Component
public interface FetchAccountFlow {
    List<AccountDto> getAllAccounts();
}
