package com.hcl.respositry;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hcl.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByAccountNumber(long value);

}
