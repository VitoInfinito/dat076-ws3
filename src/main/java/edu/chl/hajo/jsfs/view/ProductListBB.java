package edu.chl.hajo.jsfs.view;

import edu.chl.hajo.jsfs.core.SingletonShop;
import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.Shop;
import java.util.Collection;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * 
 *
 * @author hajo
 */

public class ProductListBB  {
    private Shop reg;
    private static final Logger LOG = Logger.getLogger(ProductListBB.class.getName());
    private int currentPage = 0;
    private final int pageSize = 5;
    private int count;

    protected ProductListBB() {
        // Must have for CDI
    }

    @Inject
    public ProductListBB(SingletonShop reg) {
        this.reg = (Shop) reg.getShop();
    }

    @PostConstruct
    public void post() {
        count = reg.getProductCatalogue().count();
    }

    public Collection<Product> getList() {       
        return reg.getProductCatalogue().findRange(pageSize * currentPage, pageSize);
    }

    public void next() {
        if (currentPage * pageSize + 1 < count) {
            currentPage = currentPage + 1;
        }
    }

    public void prev() {
        if (currentPage > 0) {
            currentPage = currentPage - 1;
        }
    }

    // ---- Get/Set -------------
   
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int count() {
        return count;
    }
   

}
