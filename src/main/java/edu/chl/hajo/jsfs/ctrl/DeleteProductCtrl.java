package edu.chl.hajo.jsfs.ctrl;

import edu.chl.hajo.jsfs.core.SingletonShop;
import edu.chl.hajo.jsfs.view.DeleteProductBB;
import edu.chl.hajo.jsfs.view.EditProductBB;
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
public class DeleteProductCtrl {
    private static final Logger LOG = Logger.getLogger(DeleteProductBB.class.getName());
    private Shop s;
    private DeleteProductBB prodBB;
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "DeleteProductBB alive {0}", this);
    }

    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "DeleteProductBB to be destroyed {0}", this);
    }

    protected DeleteProductCtrl(){}
    
    @Inject
    public DeleteProductCtrl(SingletonShop s) {
        this.s = (Shop) s.getShop();
    }
    
    @Inject
    public void setProductBB(DeleteProductBB productBB) {
        this.prodBB = productBB;
    }

    public void delete(long id) {
        s.getProductCatalogue().delete(id);
        
    }

}
