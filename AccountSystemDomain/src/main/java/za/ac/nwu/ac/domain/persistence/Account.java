package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = -2690647136011659583L;

    private long accID;
    private float accBalance;
    private LocalDate startDate;
    private AccountType type;
    private Member member;

    public Account(){

    }

    public Account(long accID, float accBalance, LocalDate startDate, AccountType type, Member member) {
        this.accID = accID;
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.type = type;
        this.member = member;
    }

    public Account(float accBalance, LocalDate startDate, AccountType type, Member member){
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.type = type;
        this.member = member;
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
    public AccountType getType() {
        return type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEM_ID")
    public Member getMember() {
        return member;
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

    public void setType(AccountType type) {
        this.type = type;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", accBalance=" + accBalance +
                ", startDate=" + startDate +
                ", type=" + type +
                ", member=" + member +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accID == account.accID && Float.compare(account.accBalance, accBalance) == 0 && startDate.equals(account.startDate) && type.equals(account.type) && member.equals(account.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accID, accBalance, startDate, type, member);
    }


}
