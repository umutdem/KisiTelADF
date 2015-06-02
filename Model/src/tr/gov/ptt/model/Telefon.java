package tr.gov.ptt.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * To create ID generator sequence "TELEFON_ID_SEQ_GEN":
 * CREATE SEQUENCE "TELEFON_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Telefon.findAll", query = "select o from Telefon o") })
@SequenceGenerator(name = "Telefon_Id_Seq_Gen", sequenceName = "TELEFON_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Telefon implements Serializable {
    private static final long serialVersionUID = -3772198424579954184L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Telefon_Id_Seq_Gen")
    private BigDecimal no;
    @Column(length = 20)
    private String telno;
    @Column(length = 5)
    private String tur;
    @ManyToOne
    @JoinColumn(name = "KISINO")
    private Kisi kisi;

    public Telefon() {
    }

    public Telefon(Kisi kisi, BigDecimal no, String telno, String tur) {
        this.kisi = kisi;
        this.no = no;
        this.telno = telno;
        this.tur = tur;
    }


    public BigDecimal getNo() {
        return no;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
}
