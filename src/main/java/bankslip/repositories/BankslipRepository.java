package bankslip.repositories;

import bankslip.entities.Bankslip;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BankslipRepository extends CrudRepository<Bankslip, UUID> {

}
