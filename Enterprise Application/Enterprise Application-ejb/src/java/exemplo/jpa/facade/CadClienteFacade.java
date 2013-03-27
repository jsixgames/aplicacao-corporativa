package exemplo.jpa.facade;

import exemplo.jpa.CadCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/CadClienteFacade")
public class CadClienteFacade extends AbstractFacade<CadCliente> implements CadClienteFacadeRemote {
    
        @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadClienteFacade() {
        super(CadCliente.class);
    }
}
