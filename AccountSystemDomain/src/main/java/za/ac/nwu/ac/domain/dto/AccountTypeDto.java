package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the account type")


public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -7731154715176897719L;

    private String accountTypeName;
    private String mnemonic;

    public AccountTypeDto(){
    }
    public AccountTypeDto(String accountTypeName, String mnemonic) {
        this.accountTypeName = accountTypeName;
        this.mnemonic = mnemonic;
    }

    public AccountTypeDto(AccountType accountType){
        this.setAccountTypeName(accountType.getTypeName());
        this.setMnemonic(accountType.getMnemonic());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the account type",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "The uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            allowEmptyValue = false,
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTypeDto)) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return accountTypeName.equals(that.accountTypeName) && mnemonic.equals(that.mnemonic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeName, mnemonic);
    }

    @JsonIgnore
    public AccountType getAccountType() {
        return new AccountType(getAccountTypeName(), getMnemonic());
    }
}
