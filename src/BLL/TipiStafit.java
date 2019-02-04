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
@Table(name = "TipiStafit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipiStafit.findAll", query = "SELECT t FROM TipiStafit t")
    , @NamedQuery(name = "TipiStafit.findByTipiID", query = "SELECT t FROM TipiStafit t WHERE t.tipiID = :tipiID")
    , @NamedQuery(name = "TipiStafit.findByLlojiTipit", query = "SELECT t FROM TipiStafit t WHERE t.llojiTipit = :llojiTipit")})
public class TipiStafit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Tipi_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer tipiID;
    @Basic(optional = false)
    @Column(name = "LlojiTipit")
    private String llojiTipit;
    @OneToMany(mappedBy = "tipiID")
    private List<Stafi> stafiList;

    public TipiStafit() {
    }

    public TipiStafit(Integer tipiID) {
        this.tipiID = tipiID;
    }

    public TipiStafit(Integer tipiID, String llojiTipit) throws FarmaciaException{
        this.tipiID = tipiID;
        
        if(llojiTipit.matches("[0-9]+")){
            throw new FarmaciaException("Nuk duhet te permbaj numra!");
        }
        if(llojiTipit.length() < 2){
            throw new FarmaciaException("Duhet te jete me i gjate se 2 shkronja!");
        }
        this.llojiTipit = llojiTipit;
    }

    public Integer getTipiID() {
        return tipiID;
    }

    public void setTipiID(Integer tipiID) {
        this.tipiID = tipiID;
    }

    public String getLlojiTipit() {
        return llojiTipit;
    }

    public void setLlojiTipit(String llojiTipit) throws FarmaciaException{
        if(llojiTipit.matches("[0-9]+")){
            throw new FarmaciaException("Nuk duhet te permbaj numra!");
        }
        if(llojiTipit.length() < 2){
            throw new FarmaciaException("Duhet te jete me i gjate se 2 shkronja!");
        }
        this.llojiTipit = llojiTipit;
    }

    @XmlTransient
    public List<Stafi> getStafiList() {
        return stafiList;
    }

    public void setStafiList(List<Stafi> stafiList) {
        this.stafiList = stafiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipiID != null ? tipiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipiStafit)) {
            return false;
        }
        TipiStafit other = (TipiStafit) object;
        if ((this.tipiID == null && other.tipiID != null) || (this.tipiID != null && !this.tipiID.equals(other.tipiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return llojiTipit;
    }
    
}
