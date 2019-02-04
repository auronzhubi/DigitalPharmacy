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
@Table(name = "Perdoruesit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perdoruesit.findAll", query = "SELECT p FROM Perdoruesit p")
    , @NamedQuery(name = "Perdoruesit.findByPerdoruesiID", query = "SELECT p FROM Perdoruesit p WHERE p.perdoruesiID = :perdoruesiID")
    , @NamedQuery(name = "Perdoruesit.findByEmriPerdoruesit", query = "SELECT p FROM Perdoruesit p WHERE p.emriPerdoruesit = :emriPerdoruesit")
    , @NamedQuery(name = "Perdoruesit.findByFjalekalimi", query = "SELECT p FROM Perdoruesit p WHERE p.fjalekalimi = :fjalekalimi")
    , @NamedQuery(name = "Perdoruesit.findByNiveliPerdorimit", query = "SELECT p FROM Perdoruesit p WHERE p.niveliPerdorimit = :niveliPerdorimit")})
public class Perdoruesit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PerdoruesiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer perdoruesiID;
    @Basic(optional = false)
    @Column(name = "EmriPerdoruesit")
    private String emriPerdoruesit;
    @Basic(optional = false)
    @Column(name = "Fjalekalimi")
    private String fjalekalimi;
    @Column(name = "NiveliPerdorimit")
    private String niveliPerdorimit;
    @JoinColumn(name = "Farmacia_ID", referencedColumnName = "Farmacia_ID")
    @ManyToOne
    private Farmacia farmaciaID;

    public Perdoruesit() {
    }

    public Perdoruesit(Integer perdoruesiID) throws FarmaciaException{
        this.perdoruesiID = perdoruesiID;
    }

    public Perdoruesit(Integer perdoruesiID, String emriPerdoruesit, String fjalekalimi) throws FarmaciaException{
        this.perdoruesiID = perdoruesiID;
        
        if(emriPerdoruesit.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emriPerdoruesit.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emriPerdoruesit = emriPerdoruesit;
        
        
        if(fjalekalimi.length() < 8){
            throw new FarmaciaException("Fjalkalimi duhet te jete me i gjate se 7 shkronja!");
        }
        this.fjalekalimi = fjalekalimi;
    }

    public Integer getPerdoruesiID() {
        return perdoruesiID;
    }

    public void setPerdoruesiID(Integer perdoruesiID) {
        this.perdoruesiID = perdoruesiID;
    }

    public String getEmriPerdoruesit() {
        return emriPerdoruesit;
    }

    public void setEmriPerdoruesit(String emriPerdoruesit) throws FarmaciaException{
        if(emriPerdoruesit.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emriPerdoruesit.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emriPerdoruesit = emriPerdoruesit;
    }

    public String getFjalekalimi() {
        return fjalekalimi;
    }

    public void setFjalekalimi(String fjalekalimi) throws FarmaciaException{
        
        if(fjalekalimi.length() < 8){
            throw new FarmaciaException("Fjalkalimi duhet te jete me i gjate se 7 shkronja!");
        }
        this.fjalekalimi = fjalekalimi;
    }

    public String getNiveliPerdorimit() {
        return niveliPerdorimit;
    }

    public void setNiveliPerdorimit(String niveliPerdorimit) throws FarmaciaException{
        
        this.niveliPerdorimit = niveliPerdorimit;
    }

    public Farmacia getFarmaciaID() {
        return farmaciaID;
    }

    public void setFarmaciaID(Farmacia farmaciaID) {
        this.farmaciaID = farmaciaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perdoruesiID != null ? perdoruesiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perdoruesit)) {
            return false;
        }
        Perdoruesit other = (Perdoruesit) object;
        if ((this.perdoruesiID == null && other.perdoruesiID != null) || (this.perdoruesiID != null && !this.perdoruesiID.equals(other.perdoruesiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriPerdoruesit;
    }
    
}
