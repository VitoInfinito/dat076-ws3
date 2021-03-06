
package edu.chl.hajo.jsfs.view;

import edu.chl.hajo.jsfs.core.SingletonShop;
import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.Shop;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Named
@RequestScoped
public class AddProductBB {
    private Shop reg;
    private static final Logger LOG = Logger.getLogger(AddProductBB.class.getName());
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    private String name;
    
    @Min(value = 0, message = "Too small")
    private double price;

    protected AddProductBB() {
        // Must have for CDI
    }

    @Inject
    public AddProductBB(SingletonShop reg) {
        this.reg = (Shop) reg.getShop();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
