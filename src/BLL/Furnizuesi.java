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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Furnizuesi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Furnizuesi.findAll", query = "SELECT f FROM Furnizuesi f")
    , @NamedQuery(name = "Furnizuesi.findByFurnizuesiID", query = "SELECT f FROM Furnizuesi f WHERE f.furnizuesiID = :furnizuesiID")
    , @NamedQuery(name = "Furnizuesi.findByEmriFurnizuesit", query = "SELECT f FROM Furnizuesi f WHERE f.emriFurnizuesit = :emriFurnizuesit")
    , @NamedQuery(name = "Furnizuesi.findByNumriTelefonit", query = "SELECT f FROM Furnizuesi f WHERE f.numriTelefonit = :numriTelefonit")})
public class Furnizuesi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Furnizuesi_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer furnizuesiID;
    @Basic(optional = false)
    @Column(name = "EmriFurnizuesit")
    private String emriFurnizuesit;
    @Column(name = "NumriTelefonit")
    private String numriTelefonit;
    @JoinTable(name = "ProduktetEFurnizuesit", joinColumns = {
        @JoinColumn(name = "Furnizuesi_ID", referencedColumnName = "Furnizuesi_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")})
    @ManyToMany
    private List<Produkti> produktiList;
    @JoinColumn(name = "Farmacia_ID", referencedColumnName = "Farmacia_ID")
    @ManyToOne
    private Farmacia farmaciaID;
    @JoinColumn(name = "Komuna_ID", referencedColumnName = "Komuna_ID")
    @ManyToOne
    private Komuna komunaID;

    public Furnizuesi() {
    }

    public Furnizuesi(Integer furnizuesiID) {
        this.furnizuesiID = furnizuesiID;
    }

    public Furnizuesi(Integer furnizuesiID, String emriFurnizuesit) throws FarmaciaException{
        this.furnizuesiID = furnizuesiID;
        
        if(emriFurnizuesit.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emriFurnizuesit.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emriFurnizuesit = emriFurnizuesit;
    }

    public Integer getFurnizuesiID() {
        return furnizuesiID;
    }

    public void setFurnizuesiID(Integer furnizuesiID) {
        this.furnizuesiID = furnizuesiID;
    }

    public String getEmriFurnizuesit() {
        return emriFurnizuesit;
    }

    public void setEmriFurnizuesit(String emriFurnizuesit) throws FarmaciaException{
        if(emriFurnizuesit.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emriFurnizuesit.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emriFurnizuesit = emriFurnizuesit;
    }

    public String getNumriTelefonit() {
        return numriTelefonit;
    }

    public void setNumriTelefonit(String numriTelefonit) throws FarmaciaException{
        if(!numriTelefonit.startsWith("0")){
            throw new FarmaciaException("Numri kontaktues duhet te filloj me 0!");
        }
        if(numriTelefonit.length() < 9){
            throw new FarmaciaException("Numri kontaktues duhet te jete 9 shifror!");
        }
        this.numriTelefonit = numriTelefonit;
    }

    @XmlTransient
    public List<Produkti> getProduktiList() {
        return produktiList;
    }

    public void setProduktiList(List<Produkti> produktiList) {
        this.produktiList = produktiList;
    }

    public Farmacia getFarmaciaID() {
        return farmaciaID;
    }

    public void setFarmaciaID(Farmacia farmaciaID) {
        this.farmaciaID = farmaciaID;
    }

    public Komuna getKomunaID() {
        return komunaID;
    }

    public void setKomunaID(Komuna komunaID) {
        this.komunaID = komunaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (furnizuesiID != null ? furnizuesiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Furnizuesi)) {
            return false;
        }
        Furnizuesi other = (Furnizuesi) object;
        if ((this.furnizuesiID == null && other.furnizuesiID != null) || (this.furnizuesiID != null && !this.furnizuesiID.equals(other.furnizuesiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriFurnizuesit;
    }
    
}
