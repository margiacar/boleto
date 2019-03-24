package bankslip.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
public class Bankslip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date dueDate;
    private Date paymentDate;
    private BigDecimal totalInCents;
    private String customer;
    private String status;

    public UUID getId() {
        return id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getTotalInCents() {
        return totalInCents;
    }

    public void setTotalInCents(BigDecimal totalInCents) {
        this.totalInCents = totalInCents;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bankslip{" +
                "id=" + id +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", totalInCents=" + totalInCents +
                ", customer='" + customer + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
