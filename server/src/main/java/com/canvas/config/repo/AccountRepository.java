package com.canvas.config.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.canvas.config.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{


}
