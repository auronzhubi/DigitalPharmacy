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
@Table(name = "LlojiProduktit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiProduktit.findAll", query = "SELECT l FROM LlojiProduktit l")
    , @NamedQuery(name = "LlojiProduktit.findByLlojiProduktitID", query = "SELECT l FROM LlojiProduktit l WHERE l.llojiProduktitID = :llojiProduktitID")
    , @NamedQuery(name = "LlojiProduktit.findByLlojiProduktit", query = "SELECT l FROM LlojiProduktit l WHERE l.llojiProduktit = :llojiProduktit")})
public class LlojiProduktit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LlojiProduktit_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer llojiProduktitID;
    @Column(name = "LlojiProduktit")
    private String llojiProduktit;
    @OneToMany(mappedBy = "llojiProduktitID")
    private List<Produkti> produktiList;

    public LlojiProduktit() {
    }

    public LlojiProduktit(Integer llojiProduktitID) {
        this.llojiProduktitID = llojiProduktitID;
    }

    public Integer getLlojiProduktitID() {
        return llojiProduktitID;
    }

    public void setLlojiProduktitID(Integer llojiProduktitID) {
        this.llojiProduktitID = llojiProduktitID;
    }

    public String getLlojiProduktit() {
        return llojiProduktit;
    }

    public void setLlojiProduktit(String llojiProduktit) throws FarmaciaException{
        if(llojiProduktit.matches("[0-9]+")){
            throw new FarmaciaException("Lloji produktit nuk duhet te permbaj numra!");
        }
        if(llojiProduktit.length() < 3){
            throw new FarmaciaException("Lloji produktit duhet te jete me i gjate se 2 shkronja!");
        }
        this.llojiProduktit = llojiProduktit;
    }

    @XmlTransient
    public List<Produkti> getProduktiList() {
        return produktiList;
    }

    public void setProduktiList(List<Produkti> produktiList) {
        this.produktiList = produktiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (llojiProduktitID != null ? llojiProduktitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlojiProduktit)) {
            return false;
        }
        LlojiProduktit other = (LlojiProduktit) object;
        if ((this.llojiProduktitID == null && other.llojiProduktitID != null) || (this.llojiProduktitID != null && !this.llojiProduktitID.equals(other.llojiProduktitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return llojiProduktit;
    }
    
}
