package tr.gov.ptt.model;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "KisiTelFacade", mappedName = "KisiTelADF-Model-KisiTelFacade")
public class KisiTelFacadeBean implements KisiTelFacade, KisiTelFacadeLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public KisiTelFacadeBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Kisi persistKisi(Kisi kisi) {
        em.persist(kisi);
        return kisi;
    }

    public Kisi mergeKisi(Kisi kisi) {
        return em.merge(kisi);
    }

    public void removeKisi(Kisi kisi) {
        kisi = em.find(Kisi.class, kisi.getNo());
        em.remove(kisi);
    }

    /** <code>select o from Kisi o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Kisi> getKisiFindAll() {
        return em.createNamedQuery("Kisi.findAll", Kisi.class).getResultList();
    }

    public Telefon persistTelefon(Telefon telefon) {
        em.persist(telefon);
        return telefon;
    }

    public Telefon mergeTelefon(Telefon telefon) {
        return em.merge(telefon);
    }

    public void removeTelefon(Telefon telefon) {
        telefon = em.find(Telefon.class, telefon.getNo());
        em.remove(telefon);
    }

    /** <code>select o from Telefon o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Telefon> getTelefonFindAll() {
        return em.createNamedQuery("Telefon.findAll", Telefon.class).getResultList();
    }
}
