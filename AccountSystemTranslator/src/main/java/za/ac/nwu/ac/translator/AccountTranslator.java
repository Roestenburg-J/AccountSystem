package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;

import java.util.List;

@Component
public interface AccountTranslator {
    List<AccountDto> getAllAccounts();

    AccountDto create(AccountDto accountDto);
}
