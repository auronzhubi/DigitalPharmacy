/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.FarmaciaException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Komuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komuna.findAll", query = "SELECT k FROM Komuna k")
    , @NamedQuery(name = "Komuna.findByKomunaID", query = "SELECT k FROM Komuna k WHERE k.komunaID = :komunaID")
    , @NamedQuery(name = "Komuna.findByEmriKomunes", query = "SELECT k FROM Komuna k WHERE k.emriKomunes = :emriKomunes")})
public class Komuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Komuna_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer komunaID;
    @Basic(optional = false)
    @Column(name = "EmriKomunes")
    private String emriKomunes;
    @OneToMany(mappedBy = "komunaID")
    private List<Klienti> klientiList;
    @OneToMany(mappedBy = "komunaID")
    private List<Furnizuesi> furnizuesiList;

    public Komuna() {
    }

    public Komuna(Integer komunaID) throws FarmaciaException{
        this.komunaID = komunaID;
    }

    public Komuna(Integer komunaID, String emriKomunes) throws FarmaciaException{
        this.komunaID = komunaID;
        
        if(emriKomunes.matches("[0-9]+")){
            throw new FarmaciaException("Emri Komundes nuk duhet te permbaj numra!");
        }
        if(emriKomunes.length() < 3){
            throw new FarmaciaException("Emri Komunes duhet te jete me i gjate se 2 shkronja!");
        }
        this.emriKomunes = emriKomunes;
    }

    public Integer getKomunaID() {
        return komunaID;
    }

    public void setKomunaID(Integer komunaID) {
        this.komunaID = komunaID;
    }

    public String getEmriKomunes() {
        return emriKomunes;
    }

    public void setEmriKomunes(String emriKomunes) throws FarmaciaException{
        if(emriKomunes.matches("[0-9]+")){
            throw new FarmaciaException("Emri Komundes nuk duhet te permbaj numra!");
        }
        if(emriKomunes.length() < 3){
            throw new FarmaciaException("Emri Komunes duhet te jete me i gjate se 2 shkronja!");
        }
        this.emriKomunes = emriKomunes;
    }

    @XmlTransient
    public List<Klienti> getKlientiList() {
        return klientiList;
    }

    public void setKlientiList(List<Klienti> klientiList) {
        this.klientiList = klientiList;
    }

    @XmlTransient
    public List<Furnizuesi> getFurnizuesiList() {
        return furnizuesiList;
    }

    public void setFurnizuesiList(List<Furnizuesi> furnizuesiList) {
        this.furnizuesiList = furnizuesiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (komunaID != null ? komunaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komuna)) {
            return false;
        }
        Komuna other = (Komuna) object;
        if ((this.komunaID == null && other.komunaID != null) || (this.komunaID != null && !this.komunaID.equals(other.komunaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriKomunes;
    }
    
}
