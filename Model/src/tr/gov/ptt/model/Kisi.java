package tr.gov.ptt.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "KISI_ID_SEQ_GEN":
 * CREATE SEQUENCE "KISI_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Kisi.findAll", query = "select o from Kisi o") })
@SequenceGenerator(name = "Kisi_Id_Seq_Gen", sequenceName = "KISI_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class Kisi implements Serializable {
    private static final long serialVersionUID = 568195572686686404L;
    @Column(length = 20)
    private String ad;
    @Temporal(TemporalType.DATE)
    private Date dogtar;
    private Integer maas;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Kisi_Id_Seq_Gen")
    private BigDecimal no;
    @Column(length = 20)
    private String soyad;
    @OneToMany(mappedBy = "kisi", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Telefon> telefonList;

    public Kisi() {
    }

    public Kisi(String ad, Date dogtar, Integer maas, BigDecimal no, String soyad) {
        this.ad = ad;
        this.dogtar = dogtar;
        this.maas = maas;
        this.no = no;
        this.soyad = soyad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Date getDogtar() {
        return dogtar;
    }

    public void setDogtar(Date dogtar) {
        this.dogtar = dogtar;
    }

    public Integer getMaas() {
        return maas;
    }

    public void setMaas(Integer maas) {
        this.maas = maas;
    }

    public BigDecimal getNo() {
        return no;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public List<Telefon> getTelefonList() {
        return telefonList;
    }

    public void setTelefonList(List<Telefon> telefonList) {
        this.telefonList = telefonList;
    }

    public Telefon addTelefon(Telefon telefon) {
        getTelefonList().add(telefon);
        telefon.setKisi(this);
        return telefon;
    }

    public Telefon removeTelefon(Telefon telefon) {
        getTelefonList().remove(telefon);
        telefon.setKisi(null);
        return telefon;
    }
}
