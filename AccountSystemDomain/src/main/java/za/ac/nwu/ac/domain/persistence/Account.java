package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = -2690647136011659583L;
    @Id
    @Column(name = "ACC_ID")
    private long accID;

    @Column(name = "ACC_BALANCE")
    private float accBalance;

    @Column(name = "ACC_START_DATE")
    private LocalDate startDate;

    @Column(name = "ACC_TYPE_ID")
    private long typeID;

    @Column(name = "MEM_ID")
    private long memberID;

    public Account(long accID, float accBalance, LocalDate startDate, long typeID, long memberID) {
        this.accID = accID;
        this.accBalance = accBalance;
        this.startDate = startDate;
        this.typeID = typeID;
        this.memberID = memberID;
    }

    public long getAccID() {
        return accID;
    }

    public float getAccBalance() {
        return accBalance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public long getTypeID() {
        return typeID;
    }

    public long getMemberID() {
        return memberID;
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

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public void setMemberID(long memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", accBalance=" + accBalance +
                ", startDate=" + startDate +
                ", typeID=" + typeID +
                ", memberID=" + memberID +
                '}';
    }
}
