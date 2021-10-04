package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = -2690647136011659583L;

    private long accID;
    private float accBalance;
    private LocalDate startDate;
    private AccountType accType;
    private Member accMember;

    private Set<AccountTransaction> accountTransactions;

    public Account(){

    }

    public Account(long accID, float accBalance, LocalDate startDate, AccountType accType, Member accMember) {
        this.accID = accID;
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.accType = accType;
        this.accMember = accMember;
    }

    public Account(float accBalance, LocalDate startDate, AccountType accType, Member accMember){
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.accType = accType;
        this.accMember = accMember;
    }

    @Id
    @SequenceGenerator(name = "ACC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_SEQ")
    @Column(name = "ACC_ID")
    public long getAccID() {
        return accID;
    }

    @Column(name = "ACC_BALANCE")
    public float getAccBalance() {
        return accBalance;
    }

    @Column(name = "ACC_START_DATE")
    public LocalDate getStartDate() {
        return startDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_TYPE_ID")
    public AccountType getAccType() {
        return accType;
    }

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "MEM_ID")
    public Member getAccMember() {
        return accMember;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "transactAccount", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions ;
    }

    public void setAccID(long accID) {
        this.accID = accID;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setAccType(AccountType type) {
        this.accType = accType;
    }

    public void setAccMember(Member member) {
        this.accMember = accMember;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", accBalance=" + accBalance +
                ", startDate=" + startDate +
                ", type=" + accType +
                ", member=" + accMember +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accID == account.accID && Float.compare(account.accBalance, accBalance) == 0 && startDate.equals(account.startDate) && accType.equals(account.accType) && accMember.equals(account.accMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accID, accBalance, startDate, accType, accMember);
    }


}
