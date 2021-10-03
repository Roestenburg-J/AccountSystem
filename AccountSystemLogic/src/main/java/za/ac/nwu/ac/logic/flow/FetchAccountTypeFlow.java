package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

@Component
public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();
}
