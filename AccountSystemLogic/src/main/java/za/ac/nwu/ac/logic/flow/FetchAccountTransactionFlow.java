package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

@Component
public interface FetchAccountTransactionFlow {
    List<AccountTransactionDto> getAllAccountTransactions();
}
