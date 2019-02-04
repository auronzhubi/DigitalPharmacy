/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.FarmaciaException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Fatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f")
    , @NamedQuery(name = "Fatura.findByFaturaID", query = "SELECT f FROM Fatura f WHERE f.faturaID = :faturaID")
    , @NamedQuery(name = "Fatura.findByDataLeshimit", query = "SELECT f FROM Fatura f WHERE f.dataLeshimit = :dataLeshimit")
    , @NamedQuery(name = "Fatura.findByNrProdukteve", query = "SELECT f FROM Fatura f WHERE f.nrProdukteve = :nrProdukteve")
    , @NamedQuery(name = "Fatura.findByQmimiTotal", query = "SELECT f FROM Fatura f WHERE f.qmimiTotal = :qmimiTotal")})
public class Fatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Fatura_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer faturaID;
    @Column(name = "DataLeshimit")
    @Temporal(TemporalType.DATE)
    private Date dataLeshimit;
    @Column(name = "NrProdukteve")
    private Integer nrProdukteve;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QmimiTotal")
    private BigDecimal qmimiTotal;
    @JoinTable(name = "ProduktetEFatures", joinColumns = {
        @JoinColumn(name = "Fatura_ID", referencedColumnName = "Fatura_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")})
    @ManyToMany
    private List<Produkti> produktiList;
    @JoinColumn(name = "Farmacia_ID", referencedColumnName = "Farmacia_ID")
    @ManyToOne
    private Farmacia farmaciaID;
    @JoinColumn(name = "Klienti_ID", referencedColumnName = "Klienti_ID")
    @ManyToOne
    private Klienti klientiID;

    public Fatura() {
    }

    public Fatura(Integer faturaID) {
        this.faturaID = faturaID;
    }

    public Integer getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(Integer faturaID) {
        this.faturaID = faturaID;
    }

    public Date getDataLeshimit() {
        return dataLeshimit;
    }

    public void setDataLeshimit(Date dataLeshimit) {
        this.dataLeshimit = dataLeshimit;
    }

    public Integer getNrProdukteve() {
        return nrProdukteve;
    }

    public void setNrProdukteve(Integer nrProdukteve) {
        this.nrProdukteve = nrProdukteve;
    }

    public BigDecimal getQmimiTotal() {
        return qmimiTotal;
    }

    public void setQmimiTotal(BigDecimal qmimiTotal) {
        this.qmimiTotal = qmimiTotal;
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

    public Klienti getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Klienti klientiID) {
        this.klientiID = klientiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faturaID != null ? faturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.faturaID == null && other.faturaID != null) || (this.faturaID != null && !this.faturaID.equals(other.faturaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Fatura[ faturaID=" + faturaID + " ]";
    }
    
}
