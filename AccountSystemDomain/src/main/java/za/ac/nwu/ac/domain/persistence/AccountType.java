package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 7323243789334252048L;
    @Id
    @Column(name = "ACC_TYPE_ID")
    private long typeID;

    @Column(name = "ACC_TYPE")
    private String type;

    public AccountType(long typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }

    public long getTypeID() {
        return typeID;
    }

    public String getType() {
        return type;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "typeID=" + typeID +
                ", type='" + type + '\'' +
                '}';
    }
}
