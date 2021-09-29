package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION")
public class AccountTransaction implements Serializable {

    @Id
    @Column(name = "ACC_TRANSACT_ID")
    private long transactID;

    @Column(name = "ACC_TRANSACT_DATE")
    private LocalDate transactDate;

    @Column(name = "ACC_TRANSACT_VALUE")
    private String transactValue;

    @Column(name = "ACC_ID")
    private long accID;

    public AccountTransaction(long transactID, LocalDate transactDate, String transactValue, long accID) {
        this.transactID = transactID;
        this.transactDate = transactDate;
        this.transactValue = transactValue;
        this.accID = accID;
    }

    public long getTransactID() {
        return transactID;
    }

    public void setTransactID(long transactID) {
        this.transactID = transactID;
    }

    public LocalDate getTransactDate() {
        return transactDate;
    }

    public void setTransactDate(LocalDate transactDate) {
        this.transactDate = transactDate;
    }

    public String getTransactValue() {
        return transactValue;
    }

    public void setTransactValue(String transactValue) {
        this.transactValue = transactValue;
    }

    public long getAccID() {
        return accID;
    }

    public void setAccID(long accID) {
        this.accID = accID;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactID=" + transactID +
                ", transactDate=" + transactDate +
                ", transactValue='" + transactValue + '\'' +
                ", accID=" + accID +
                '}';
    }
}
