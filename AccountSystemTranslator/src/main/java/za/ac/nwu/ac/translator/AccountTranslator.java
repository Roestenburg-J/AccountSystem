package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;

import java.util.List;

@Component
public interface AccountTranslator {

    List<AccountDto> getAllAccounts();

    AccountDto create(AccountDto accountDto);

    AccountDto getBalanceForAccount(String id) ;

    AccountDto subtractAccount(Long id, Float value);

    AccountDto addToAccount(Long id, Float value);
}
