package exemplo.jpa.facade;

import exemplo.jpa.Contato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/ContatoFacade")
public class ContatoFacade extends AbstractFacade<Contato> implements ContatoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContatoFacade() {
        super(Contato.class);
    }
}
