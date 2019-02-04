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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Terapia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terapia.findAll", query = "SELECT t FROM Terapia t")
    , @NamedQuery(name = "Terapia.findByTerapiaID", query = "SELECT t FROM Terapia t WHERE t.terapiaID = :terapiaID")
    , @NamedQuery(name = "Terapia.findByKohezgjatja", query = "SELECT t FROM Terapia t WHERE t.kohezgjatja = :kohezgjatja")
    , @NamedQuery(name = "Terapia.numeroTerapite", query = "SELECT count(t) FROM Terapia t")
    , @NamedQuery(name = "Terapia.findTerapiaKlientit", query = "SELECT t FROM Terapia AS t INNER JOIN Klienti AS k" +
            " ON t.Klienti_ID = k.Klienti_ID WHERE k.klientiID = :klientiID")})
public class Terapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Terapia_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer terapiaID;
    @Column(name = "Kohezgjatja")
    private Integer kohezgjatja;
    @JoinColumn(name = "Klienti_ID", referencedColumnName = "Klienti_ID")
    @ManyToOne
    private Klienti klientiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terapiaID")
    private List<ProduktetETerapise> produktetETerapiseList;

    public Terapia() {
    }

    public Terapia(Integer terapiaID) {
        this.terapiaID = terapiaID;
    }

    public Integer getTerapiaID() {
        return terapiaID;
    }

    public void setTerapiaID(Integer terapiaID) {
        this.terapiaID = terapiaID;
    }

    public Integer getKohezgjatja() {
        return kohezgjatja;
    }

    public void setKohezgjatja(Integer kohezgjatja) throws FarmaciaException{
        if(kohezgjatja <= 0){
            throw new FarmaciaException("Kohezgjatja nuk duuhet te jete negative ose 0!");
        }
        this.kohezgjatja = kohezgjatja;
    }

    public Klienti getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Klienti klientiID){
        this.klientiID = klientiID;
    }

    @XmlTransient
    public List<ProduktetETerapise> getProduktetETerapiseList() {
        return produktetETerapiseList;
    }

    public void setProduktetETerapiseList(List<ProduktetETerapise> produktetETerapiseList) {
        this.produktetETerapiseList = produktetETerapiseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terapiaID != null ? terapiaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terapia)) {
            return false;
        }
        Terapia other = (Terapia) object;
        if ((this.terapiaID == null && other.terapiaID != null) || (this.terapiaID != null && !this.terapiaID.equals(other.terapiaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Terapia[ terapiaID=" + terapiaID + " ]";
    }
    
}
