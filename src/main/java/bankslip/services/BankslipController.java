package bankslip.services;

import bankslip.entities.Bankslip;
import bankslip.repositories.BankslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
public class BankslipController {
    public static final String SRV_ROOT_PATH = "/bankslips";

    @Autowired
    private BankslipRepository repository;

    @PostMapping(SRV_ROOT_PATH)
    public Bankslip create(@RequestBody Bankslip request){
        request.setStatus("PENDING");
        Bankslip response = repository.save(request);

        return response;
    }

    @GetMapping(SRV_ROOT_PATH)
    public List<Bankslip> list(){
        List<Bankslip> response = (List<Bankslip>)repository.findAll();
        return response;
    }

    @GetMapping(SRV_ROOT_PATH  + "/{id}")
    public Bankslip getDetails(@PathVariable String id){
        UUID uuidId = UUID.fromString(id);
        Bankslip response = repository.findById(uuidId).get();
        return response;
    }

    @PutMapping(SRV_ROOT_PATH  + "/{id}/pay")
    public Bankslip pay(@PathVariable String id){
        UUID uuidId = UUID.fromString(id);
        Bankslip response = repository.findById(uuidId).get();
        response.setStatus("Paid");
        response.setPaymentDate(Calendar.getInstance().getTime());
        response = repository.save(response);
        return response;
    }

    @PutMapping(SRV_ROOT_PATH  + "/{id}/cancel")
    public Bankslip cancel(@PathVariable String id){
        UUID uuidId = UUID.fromString(id);
        Bankslip response = repository.findById(uuidId).get();
        response.setStatus("Canceled");
        response = repository.save(response);
        return response;
    }


}
