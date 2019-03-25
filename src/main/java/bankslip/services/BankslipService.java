package bankslip.services;

import bankslip.entities.Bankslip;

import java.util.List;

public interface BankslipService {

    public Bankslip create(Bankslip bankslip);

    public List<Bankslip> list();

    public Bankslip getDetails(String id);

    public Bankslip pay(String id);

    public Bankslip cancel(String id);
}
