package edu.chl.hajo.jsfs.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class DeleteProductBB  {
      private static final Logger LOG = Logger.getLogger(DeleteProductBB.class.getName());
    private Long id;
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "DeleteProductBB alive {0}", this);
    }

    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "DeleteProductBB to be destroyed {0}", this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
}
