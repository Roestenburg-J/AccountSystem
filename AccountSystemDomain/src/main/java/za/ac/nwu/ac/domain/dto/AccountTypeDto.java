package za.ac.nwu.ac.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -7731154715176897719L;

    private String accountType;

    public AccountTypeDto(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTypeDto)) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return accountType.equals(that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType);
    }


}
