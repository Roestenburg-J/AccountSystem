package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Account", description = "A DTO that represents Accounts for the account system")
public class AccountDto implements Serializable {
    private static final long serialVersionUID = 37681105632235880L;

    private float accBalance;
    private LocalDate startDate;
    private AccountType accType;
    private Member accMember;

    public AccountDto(){

    }
    public AccountDto(float accBalance, LocalDate startDate, AccountType accType, Member accMember) {
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.accType = accType;
        this.accMember = accMember;
    }

    public AccountDto(Account account){
        this.setAccBalance(account.getAccBalance());
        this.setStartDate(account.getStartDate());
        this.setAccType(account.getAccType());
        this.setAccMember(account.getAccMember());
    }
    @ApiModelProperty(position = 1,
            value = "Account Balance",
            name = "Balance",
            notes = "Balance of the Account",
            dataType = "java.float",
            example = "20.21",
            allowEmptyValue = false,
            required = true)
    public float getAccBalance() {
        return accBalance;
    }

    @ApiModelProperty(position = 1,
            value = "Account Start Date",
            name = "Start Date",
            notes = "Start date of the Account",
            dataType = "java.time.LocalDate",
            example = "2021-08-08",
            allowEmptyValue = false,
            required = true)
    public LocalDate getStartDate() {
        return startDate;
    }

    @ApiModelProperty(position = 1,
            value = "Account Type",
            name = "Type",
            notes = "Type of the Account",
            dataType = "AccountType",
            example = "Miles, Miles",
            allowEmptyValue = false,
            required = true)
    public AccountType getAccType() {
        return accType;
    }

    @ApiModelProperty(position = 1,
            value = "Account Member",
            name = "Member",
            notes = "Owner of the Account",
            dataType = "Member",
            example = "John, Stone, 2000-01-01",
            allowEmptyValue = false,
            required = true)
    public Member getAccMember() {
        return accMember;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setAccType(AccountType accType) {
        this.accType = accType;
    }

    public void setAccMember(Member accMember) {
        this.accMember = accMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDto)) return false;
        AccountDto that = (AccountDto) o;
        return Float.compare(that.accBalance, accBalance) == 0 && startDate.equals(that.startDate) && accType.equals(that.accType) && accMember.equals(that.accMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accBalance, startDate, accType, accMember);
    }
}
