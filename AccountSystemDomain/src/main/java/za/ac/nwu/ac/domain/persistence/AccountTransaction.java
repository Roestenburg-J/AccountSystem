package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1650586227852005297L;

    private long transactID;
    private LocalDate transactDate;
    private String transactValue;
    private Account acc;

    public AccountTransaction(long transactID, LocalDate transactDate, String transactValue, Account acc) {
        this.transactID = transactID;
        this.transactDate = transactDate;
        this.transactValue = transactValue;
        this.acc = acc;
    }

    @Id
    @SequenceGenerator(name = "GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")
    @Column(name = "ACC_TRANSACT_ID")
    public long getTransactID() {
        return transactID;
    }

    public void setTransactID(long transactID) {
        this.transactID = transactID;
    }

    @Column(name = "ACC_TRANSACT_DATE")
    public LocalDate getTransactDate() {
        return transactDate;
    }

    public void setTransactDate(LocalDate transactDate) {
        this.transactDate = transactDate;
    }

    @Column(name = "ACC_TRANSACT_VALUE")
    public String getTransactValue() {
        return transactValue;
    }

    public void setTransactValue(String transactValue) {
        this.transactValue = transactValue;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_ID")
    public Account getAcc() {
        return acc;
    }

    public void setAccID(Account accID) {
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactID=" + transactID +
                ", transactDate=" + transactDate +
                ", transactValue='" + transactValue + '\'' +
                ", acc=" + acc +
                '}';
    }
}
