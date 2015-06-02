package tr.gov.ptt.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface KisiTelFacadeLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Kisi persistKisi(Kisi kisi);

    Kisi mergeKisi(Kisi kisi);

    void removeKisi(Kisi kisi);

    List<Kisi> getKisiFindAll();

    Telefon persistTelefon(Telefon telefon);

    Telefon mergeTelefon(Telefon telefon);

    void removeTelefon(Telefon telefon);

    List<Telefon> getTelefonFindAll();
}
