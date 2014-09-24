package edu.chl.hajo.jsfs.ctrl;

import edu.chl.hajo.jsfs.core.SingletonShop;
import edu.chl.hajo.jsfs.view.AddProductBB;
import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.Shop;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddProductCtrl {
    private static final Logger LOG = Logger.getLogger(EditProductCtrl.class.getName());
    private Shop reg;
    private AddProductBB productBB;

    protected AddProductCtrl() {
        // Must have for CDI
    }

    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddProductCtrl alive {0}", this);
    }

    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddProductCtrl to be destroyed {0}", this);
    }

    @Inject
    public AddProductCtrl(SingletonShop reg) {
        this.reg = (Shop) reg.getShop();
    }
    
    // Lie this --------------------
    @Inject
    public void setProductBB(AddProductBB productBB) {
        this.productBB = productBB;
    }

    public String add() {
        LOG.log(Level.INFO, "Add: {0}" + productBB);
        reg.getProductCatalogue().create(new Product(productBB.getName(), productBB.getPrice()));
        return "productList?faces-redirect=true";
    }
  
}
