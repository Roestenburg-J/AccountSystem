package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;

import java.util.List;

@Component
public interface FetchAccountFlow {
    List<AccountDto> getAllAccounts();

    AccountDto getBalanceForAccount(String id);

    AccountDto subtractAccount(Long id, Float value);

    AccountDto addToAccount(Long id, Float value);
}
