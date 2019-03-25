package bankslip.controllers;

import bankslip.entities.Bankslip;
import bankslip.services.BankslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankslipController {
    public static final String SRV_ROOT_PATH = "/bankslips";

    @Autowired
    private BankslipService service;

    @PostMapping(SRV_ROOT_PATH)
    public Bankslip create(@RequestBody Bankslip request){
        Bankslip response = service.create(request);

        return response;
    }

    @GetMapping(SRV_ROOT_PATH)
    public List<Bankslip> list(){
        List<Bankslip> response = service.list();

        return response;
    }

    @GetMapping(SRV_ROOT_PATH  + "/{id}")
    public Bankslip getDetails(@PathVariable String id){
        Bankslip response = service.getDetails(id);

        return response;
    }

    @PutMapping(SRV_ROOT_PATH  + "/{id}/pay")
    public Bankslip pay(@PathVariable String id){
        Bankslip response = service.pay(id);

        return response;
    }

    @PutMapping(SRV_ROOT_PATH  + "/{id}/cancel")
    public Bankslip cancel(@PathVariable String id){
        Bankslip response = service.cancel(id);

        return response;
    }


}
