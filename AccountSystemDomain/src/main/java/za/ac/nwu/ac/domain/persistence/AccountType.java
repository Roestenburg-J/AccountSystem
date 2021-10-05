package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 7323243789334252048L;

    private long typeID;
    private String typeName;
    private String mnemonic;

    private Set<Account> accounts;


    public AccountType() {

    }

    public AccountType(long typeID, String typeName, String mnemonic) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.mnemonic = mnemonic;
    }

    public AccountType(String typeName, String mnemonic) {
        this.typeName = typeName;
        this.mnemonic = mnemonic;
    }

    @Id
    @SequenceGenerator(name = "ACC_TYPE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_TYPE_SEQ")
    @Column(name = "ACC_TYPE_ID")
    public long getTypeID() {
        return typeID;
    }

    @Column(name = "ACC_TYPE_NAME")
    public String getTypeName() {
        return typeName;
    }

    @Column(name = "ACC_MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    @OneToMany(targetEntity = Account.class, fetch = FetchType.LAZY, mappedBy = "accType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(Set<Account> accounts){
        this.accounts = accounts;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountType)) return false;
        AccountType that = (AccountType) o;
        return typeID == that.typeID && typeName.equals(that.typeName) && mnemonic.equals(that.mnemonic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeID, typeName, mnemonic);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "typeID=" + typeID +
                ", typeName='" + typeName + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
