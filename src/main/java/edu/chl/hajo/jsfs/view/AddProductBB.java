
package edu.chl.hajo.jsfs.view;

import edu.chl.hajo.jsfs.core.SingletonShop;
import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.Shop;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author hajo
 */
@Named
@ViewScoped
public class AddProductBB {
    private Shop reg;
    private static final Logger LOG = Logger.getLogger(ProductListBB.class.getName());
    private int currentPage = 0;
    private final int pageSize = 5;
    private int count;

    protected AddProductBB() {
        // Must have for CDI
    }

    @Inject
    public AddProductBB(SingletonShop reg) {
        this.reg = (Shop) reg.getShop();
    }

    @PostConstruct
    public void post() {
        count = reg.getProductCatalogue().count();
    }
    
    public Product getProduct(long id){
        return reg.getProductCatalogue().find(id);
    }
   
    
}
