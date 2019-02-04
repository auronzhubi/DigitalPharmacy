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
@Table(name = "Farmacia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Farmacia.findAll", query = "SELECT f FROM Farmacia f")
    , @NamedQuery(name = "Farmacia.findByFarmaciaID", query = "SELECT f FROM Farmacia f WHERE f.farmaciaID = :farmaciaID")
    , @NamedQuery(name = "Farmacia.findByEmri", query = "SELECT f FROM Farmacia f WHERE f.emri = :emri")
    , @NamedQuery(name = "Farmacia.findByAdresa", query = "SELECT f FROM Farmacia f WHERE f.adresa = :adresa")
    , @NamedQuery(name = "Farmacia.findByNrKontaktues", query = "SELECT f FROM Farmacia f WHERE f.nrKontaktues = :nrKontaktues")})
public class Farmacia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Farmacia_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer farmaciaID;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Column(name = "Adresa")
    private String adresa;
    @Column(name = "NrKontaktues")
    private String nrKontaktues;
    @OneToMany(mappedBy = "farmaciaID")
    private List<Stafi> stafiList;
    @OneToMany(mappedBy = "farmaciaID")
    private List<Perdoruesit> perdoruesitList;
    @OneToMany(mappedBy = "farmaciaID")
    private List<Fatura> faturaList;
    @OneToMany(mappedBy = "farmaciaID")
    private List<Furnizuesi> furnizuesiList;

    public Farmacia() {
    }

    public Farmacia(Integer farmaciaID) {
        this.farmaciaID = farmaciaID;
    }

    public Farmacia(Integer farmaciaID, String emri) throws FarmaciaException{
        this.farmaciaID = farmaciaID;
        
        if(emri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emri.length() <3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emri = emri;
    }

    public Integer getFarmaciaID() {
        return farmaciaID;
    }

    public void setFarmaciaID(Integer farmaciaID) {
        this.farmaciaID = farmaciaID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) throws FarmaciaException{
        if(emri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emri.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emri = emri;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNrKontaktues() {
        return nrKontaktues;
    }

    public void setNrKontaktues(String nrKontaktues) throws FarmaciaException{
        if(!nrKontaktues.startsWith("0")){
            throw new FarmaciaException("Numri kontaktues duhet te filloj me 0!");
        }
        if(nrKontaktues.length() < 9){
            throw new FarmaciaException("Numri kontaktues duhet te jete 9 shifror!");
        }
        this.nrKontaktues = nrKontaktues;
    }

    @XmlTransient
    public List<Stafi> getStafiList() {
        return stafiList;
    }

    public void setStafiList(List<Stafi> stafiList) {
        this.stafiList = stafiList;
    }

    @XmlTransient
    public List<Perdoruesit> getPerdoruesitList() {
        return perdoruesitList;
    }

    public void setPerdoruesitList(List<Perdoruesit> perdoruesitList) {
        this.perdoruesitList = perdoruesitList;
    }

    @XmlTransient
    public List<Fatura> getFaturaList() {
        return faturaList;
    }

    public void setFaturaList(List<Fatura> faturaList) {
        this.faturaList = faturaList;
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
        hash += (farmaciaID != null ? farmaciaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Farmacia)) {
            return false;
        }
        Farmacia other = (Farmacia) object;
        if ((this.farmaciaID == null && other.farmaciaID != null) || (this.farmaciaID != null && !this.farmaciaID.equals(other.farmaciaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Farmacia[ farmaciaID=" + farmaciaID + " ]";
    }
    
}
