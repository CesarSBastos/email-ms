package com.cbastos.email_ms.repositories;

import com.cbastos.email_ms.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel,Long> {
}
