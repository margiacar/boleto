package bankslip.services;

import bankslip.entities.Bankslip;
import bankslip.repositories.BankslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankslipServiceImpl implements BankslipService{

    @Autowired
    private BankslipRepository repository;

    public Bankslip create(Bankslip bankslip){

        bankslip.setStatus("PENDING");
        Bankslip response = repository.save(bankslip);

        return response;
    }

    public List<Bankslip> list(){
        List<Bankslip> bankslips = (List<Bankslip>)repository.findAll();
        return bankslips;
    }

    public Bankslip getDetails(String id){
        Bankslip bankslip = retriveBankslip(id);
        return bankslip;
    }

    public Bankslip pay(String id){
        Bankslip bankslip = retriveBankslip(id);
        bankslip.setStatus("Paid");
        bankslip.setPaymentDate(Calendar.getInstance().getTime());
        bankslip = repository.save(bankslip);
        return bankslip;
    }

    public Bankslip cancel(String id){
        Bankslip bankslip = retriveBankslip(id);
        bankslip.setStatus("Canceled");
        bankslip = repository.save(bankslip);
        return bankslip;
    }

    private Bankslip retriveBankslip(String id){
        Bankslip bankslip = null;
        UUID uuidId = UUID.fromString(id);
        try {
            Optional<Bankslip> result  = repository.findById(uuidId);

            if(result != null){
                bankslip = result.get();
            }

        }catch(NoSuchElementException nsElEx){
            throw new NoSuchElementException("Bankslip not found with the specified id");
        }
        return bankslip;
    }
}
