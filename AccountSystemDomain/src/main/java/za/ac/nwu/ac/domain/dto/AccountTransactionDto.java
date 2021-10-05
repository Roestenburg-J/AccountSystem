package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Account Transaction", description = "A DTO that represents Account transactions for the account system")
public class AccountTransactionDto implements Serializable {
    private static final long serialVersionUID = -7819344808062462808L;

    private LocalDate transactDate;
    private float transactValue;
    private Account transactAccount;

    public AccountTransactionDto(){

    }

    public AccountTransactionDto(LocalDate transactDate, float transactValue, Account transactAccount) {
        this.transactDate = transactDate;
        this.transactValue = transactValue;
        this.transactAccount = transactAccount;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setTransactDate(accountTransaction.getTransactDate());
        this.setTransactValue(accountTransaction.getTransactValue());
        this.setTransactAccount(accountTransaction.getTransactAccount());
    }

    @ApiModelProperty(position = 1,
            value = "Account Transaction Date",
            name = "Date",
            notes = "Date of the transaction",
            dataType = "java.lang.String",
            example = "2021-01-01",
            allowEmptyValue = false,
            required = true)
    public LocalDate getTransactDate() {
        return transactDate;
    }

    @ApiModelProperty(position = 2,
            value = "Account Transaction Value",
            name = "Value",
            notes = "Value of the transaction",
            dataType = "java.lang.String",
            example = "20.21",
            allowEmptyValue = false,
            required = true)
    public float getTransactValue() {
        return transactValue;
    }

    @ApiModelProperty(position = 1,
            value = "Account Transaction Account",
            name = "Account",
            notes = "Account of the transaction",
            dataType = "java.lang.String",
            example = "John, Stone, 2000-01-01",
            allowEmptyValue = false,
            required = true)
    public Account getTransactAccount() {
        return transactAccount;
    }

    public void setTransactDate(LocalDate transactDate) {
        this.transactDate = transactDate;
    }

    public void setTransactValue(float transactValue) {
        this.transactValue = transactValue;
    }

    public void setTransactAccount(Account transactAccount) {
        this.transactAccount = transactAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransactionDto)) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Float.compare(that.transactValue, transactValue) == 0 && transactDate.equals(that.transactDate) && transactAccount.equals(that.transactAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactDate, transactValue, transactAccount);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getTransactDate(), getTransactValue(), getTransactAccount());
    }
}
