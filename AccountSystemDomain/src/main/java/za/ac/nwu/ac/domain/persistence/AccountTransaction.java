package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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
}
