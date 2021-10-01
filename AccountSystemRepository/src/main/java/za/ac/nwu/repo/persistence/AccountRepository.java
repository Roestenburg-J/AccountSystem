package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
