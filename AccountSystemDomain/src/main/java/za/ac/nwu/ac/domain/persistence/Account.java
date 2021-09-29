package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

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

}
