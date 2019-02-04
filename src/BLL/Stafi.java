/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.FarmaciaException;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Stafi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stafi.findAll", query = "SELECT s FROM Stafi s")
    , @NamedQuery(name = "Stafi.findByStafiID", query = "SELECT s FROM Stafi s WHERE s.stafiID = :stafiID")
    , @NamedQuery(name = "Stafi.findByEmri", query = "SELECT s FROM Stafi s WHERE s.emri = :emri")
    , @NamedQuery(name = "Stafi.findByMbiemri", query = "SELECT s FROM Stafi s WHERE s.mbiemri = :mbiemri")
    , @NamedQuery(name = "Stafi.findByDataLindjes", query = "SELECT s FROM Stafi s WHERE s.dataLindjes = :dataLindjes")
    , @NamedQuery(name = "Stafi.findByGjinia", query = "SELECT s FROM Stafi s WHERE s.gjinia = :gjinia")})
public class Stafi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Stafi_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer stafiID;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "DataLindjes")
    @Temporal(TemporalType.DATE)
    private Date dataLindjes;
    @Column(name = "Gjinia")
    private Character gjinia;
    @JoinColumn(name = "Farmacia_ID", referencedColumnName = "Farmacia_ID")
    @ManyToOne
    private Farmacia farmaciaID;
    @JoinColumn(name = "Tipi_ID", referencedColumnName = "Tipi_ID")
    @ManyToOne
    private TipiStafit tipiID;

    public Stafi() {
    }

    public Stafi(Integer stafiID) {
        this.stafiID = stafiID;
    }

    public Stafi(Integer stafiID, String emri, String mbiemri, Date dataLindjes) throws FarmaciaException{
        this.stafiID = stafiID;
        
        if(emri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emri.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emri = emri;
        
        if(mbiemri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(mbiemri.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.mbiemri = mbiemri;
        
        this.dataLindjes = dataLindjes;
    }

    public Integer getStafiID() {
        return stafiID;
    }

    public void setStafiID(Integer stafiID) {
        this.stafiID = stafiID;
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

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) throws FarmaciaException{
        if(mbiemri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(mbiemri.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.mbiemri = mbiemri;
    }

    public Date getDataLindjes() {
        return dataLindjes;
    }

    public void setDataLindjes(Date dataLindjes) {
        this.dataLindjes = dataLindjes;
    }

    public Character getGjinia() {
        return gjinia;
    }

    public void setGjinia(Character gjinia) {
        this.gjinia = gjinia;
    }

    public Farmacia getFarmaciaID() {
        return farmaciaID;
    }

    public void setFarmaciaID(Farmacia farmaciaID) {
        this.farmaciaID = farmaciaID;
    }

    public TipiStafit getTipiID() {
        return tipiID;
    }

    public void setTipiID(TipiStafit tipiID) {
        this.tipiID = tipiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stafiID != null ? stafiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stafi)) {
            return false;
        }
        Stafi other = (Stafi) object;
        if ((this.stafiID == null && other.stafiID != null) || (this.stafiID != null && !this.stafiID.equals(other.stafiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri + " " + mbiemri;
    }
    
}
