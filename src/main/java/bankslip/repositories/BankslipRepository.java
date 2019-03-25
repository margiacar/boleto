package bankslip.repositories;

import bankslip.entities.Bankslip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("bankslipRepository")
public interface BankslipRepository extends CrudRepository<Bankslip, UUID> {

}
