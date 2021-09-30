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

    public Account(long accID, float accBalance, LocalDate startDate, AccountType type, Member member) {
        this.accID = accID;
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.type = type;
        this.member = member;
    }

    @Id
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

    @Column(name = "ACC_TYPE_ID")
    public AccountType getTypeID() {
        return type;
    }

    @Column(name = "MEM_ID")
    public Member getMemberID() {
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

    public void setTypeID(AccountType type) {
        this.type = type;
    }

    public void setMemberID(Member member) {
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
}
