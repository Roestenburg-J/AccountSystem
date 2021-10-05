package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT " +
            "ACC_ID" +
            "ACC_BALANCE" +
            "FROM" +
            "ACCOUNT" +
            "WHERE ACC_IS = ID", nativeQuery = true)
    Account getBalanceForAccount(String id);

    @Query(value = "UPDATE ACCOUNT " +
            "SET ACC_BALANCE = " +
            "SUM(ACC_BALANCE) - value" +
            "WHERE ACC_IS = ID", nativeQuery = true)
    Account subtractAccount(long id, Float value);

    @Query(value = "UPDATE ACCOUNT " +
            "SET ACC_BALANCE = " +
            "SUM(ACC_BALANCE) + value" +
            "WHERE ACC_IS = ID", nativeQuery = true)
    Account addToAccount(Long id, Float value);
}
