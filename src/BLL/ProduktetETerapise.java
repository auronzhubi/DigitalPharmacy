/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.FarmaciaException;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "ProduktetETerapise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduktetETerapise.findAll", query = "SELECT p FROM ProduktetETerapise p")
    , @NamedQuery(name = "ProduktetETerapise.findByProduktetETerapiseID", query = "SELECT p FROM ProduktetETerapise p WHERE p.produktetETerapiseID = :produktetETerapiseID")
    , @NamedQuery(name = "ProduktetETerapise.findByDoza", query = "SELECT p FROM ProduktetETerapise p WHERE p.doza = :doza")
    , @NamedQuery(name = "ProduktetETerapise.findByDitore", query = "SELECT p FROM ProduktetETerapise p WHERE p.ditore = :ditore")
    , @NamedQuery(name = "ProduktetETerapise.findTerapiaKlientit", query = "SELECT p FROM ProduktetETerapise AS p INNER JOIN" +
                        " Terapia AS t on p.Terapia_ID = t.Terapia_ID INNER JOIN Klienti AS k on t.Klienti_ID = k.Klienti_ID WHERE k.klientiID = :klientiID")})
public class ProduktetETerapise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProduktetETerapise_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer produktetETerapiseID;
    @Column(name = "Doza")
    private Integer doza;
    @Column(name = "Ditore")
    private Integer ditore;
    @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")
    @ManyToOne(optional = false)
    private Produkti produktiID;
    @JoinColumn(name = "Terapia_ID", referencedColumnName = "Terapia_ID")
    @ManyToOne(optional = false)
    private Terapia terapiaID;

    public ProduktetETerapise() {
    }

    public ProduktetETerapise(Integer produktetETerapiseID) {
        this.produktetETerapiseID = produktetETerapiseID;
    }

    public Integer getProduktetETerapiseID() {
        return produktetETerapiseID;
    }

    public void setProduktetETerapiseID(Integer produktetETerapiseID) {
        this.produktetETerapiseID = produktetETerapiseID;
    }

    public Integer getDoza() {
        return doza;
    }

    public void setDoza(Integer doza) throws FarmaciaException{
        if(doza <= 0){
            throw new FarmaciaException("Doza nuk duhet te jete negativ ose 0!");
        }
        if(doza > 4){
            throw new FarmaciaException("Doza maksimale eshte 4!");
        }
        this.doza = doza;
    }

    public Integer getDitore() {
        return ditore;
    }

    public void setDitore(Integer ditore) throws FarmaciaException{
        if(ditore <= 0){
            throw new FarmaciaException("Doza ditore nuk duhet te jete negativ ose 0!");
        }
        if(ditore > 4){
            throw new FarmaciaException("Doza ditore maksimale eshte 4!");
        }
        this.ditore = ditore;
    }

    public Produkti getProduktiID() {
        return produktiID;
    }

    public void setProduktiID(Produkti produktiID) {
        this.produktiID = produktiID;
    }

    public Terapia getTerapiaID() {
        return terapiaID;
    }

    public void setTerapiaID(Terapia terapiaID) {
        this.terapiaID = terapiaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produktetETerapiseID != null ? produktetETerapiseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduktetETerapise)) {
            return false;
        }
        ProduktetETerapise other = (ProduktetETerapise) object;
        if ((this.produktetETerapiseID == null && other.produktetETerapiseID != null) || (this.produktetETerapiseID != null && !this.produktetETerapiseID.equals(other.produktetETerapiseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.ProduktetETerapise[ produktetETerapiseID=" + produktetETerapiseID + " ]";
    }
    
}
