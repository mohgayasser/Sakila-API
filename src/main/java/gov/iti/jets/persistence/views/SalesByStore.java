package gov.iti.jets.persistence.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "sales_by_store")
public class SalesByStore {
    @Id
    private  int Id;

    @Size(max = 101)
    @Column(name = "store", length = 101)
    private String store;

    @Size(max = 91)
    @Column(name = "manager", length = 91)
    private String manager;

    @Column(name = "total_sales", precision = 27, scale = 2)
    private BigDecimal totalSales;

    public String getStore() {
        return store;
    }

    public String getManager() {
        return manager;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    protected SalesByStore() {
    }
}