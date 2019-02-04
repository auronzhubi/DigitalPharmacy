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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Produkti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkti.findAll", query = "SELECT p FROM Produkti p")
    , @NamedQuery(name = "Produkti.findByProduktiID", query = "SELECT p FROM Produkti p WHERE p.produktiID = :produktiID")
    , @NamedQuery(name = "Produkti.findByNumriSerik", query = "SELECT p FROM Produkti p WHERE p.numriSerik = :numriSerik")
    , @NamedQuery(name = "Produkti.findByEmri", query = "SELECT p FROM Produkti p WHERE p.emri = :emri")
    , @NamedQuery(name = "Produkti.findByPerbersiBaze", query = "SELECT p FROM Produkti p WHERE p.perbersiBaze = :perbersiBaze")
    , @NamedQuery(name = "Produkti.findByDataSkadimit", query = "SELECT p FROM Produkti p WHERE p.dataSkadimit = :dataSkadimit")
    , @NamedQuery(name = "Produkti.findByNumriTabletave", query = "SELECT p FROM Produkti p WHERE p.numriTabletave = :numriTabletave")
    , @NamedQuery(name = "Produkti.findByQmimi", query = "SELECT p FROM Produkti p WHERE p.qmimi = :qmimi")
    , @NamedQuery(name = "Produkti.findByQmimiFurnizues", query = "SELECT p FROM Produkti p WHERE p.qmimiFurnizues = :qmimiFurnizues")
    , @NamedQuery(name = "Produkti.findByProdhuesi", query = "SELECT p FROM Produkti p WHERE p.prodhuesi = :prodhuesi")
    , @NamedQuery(name = "Produkti.findByShtetiProdhimit", query = "SELECT p FROM Produkti p WHERE p.shtetiProdhimit = :shtetiProdhimit")
    , @NamedQuery(name = "Produkti.numeroProduktet", query = "SELECT count(p) FROM Produkti p")})
public class Produkti implements Serializable {

    @OneToMany(mappedBy = "produktiID")
    private List<ProduktetEFurnizuesit> produktetEFurnizuesitList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Produkti_ID")
    private Integer produktiID;
    @Basic(optional = false)
    @Column(name = "NumriSerik")
    private int numriSerik;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Column(name = "PerbersiBaze")
    private String perbersiBaze;
    @Basic(optional = false)
    @Column(name = "DataSkadimit")
    @Temporal(TemporalType.DATE)
    private Date dataSkadimit;
    @Column(name = "NumriTabletave")
    private Integer numriTabletave;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Qmimi")
    private BigDecimal qmimi;
    @Column(name = "QmimiFurnizues")
    private BigDecimal qmimiFurnizues;
    @Column(name = "Prodhuesi")
    private String prodhuesi;
    @Column(name = "ShtetiProdhimit")
    private String shtetiProdhimit;
    @ManyToMany(mappedBy = "produktiList")
    private List<Fatura> faturaList;
    @ManyToMany(mappedBy = "produktiList")
    private List<Furnizuesi> furnizuesiList;
    @JoinColumn(name = "LlojiProduktit_ID", referencedColumnName = "LlojiProduktit_ID")
    @ManyToOne
    private LlojiProduktit llojiProduktitID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produktiID")
    private List<ProduktetETerapise> produktetETerapiseList;

    public Produkti() {
    }

    public Produkti(Integer produktiID) {
        this.produktiID = produktiID;
    }

    public Produkti(Integer produktiID, int numriSerik, String emri, Date dataSkadimit) throws FarmaciaException{
        this.produktiID = produktiID;
        
        if(numriSerik <= 0){
            throw new FarmaciaException("Numri serik nuk duhet te jete negativ apo 0!");
        }
        this.numriSerik = numriSerik;
        
        if(emri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emri.length() < 3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emri = emri;
        
        this.dataSkadimit = dataSkadimit;
    }

    public Integer getProduktiID() {
        return produktiID;
    }

    public void setProduktiID(Integer produktiID) {
        this.produktiID = produktiID;
    }

    public int getNumriSerik() {
        return numriSerik;
    }

    public void setNumriSerik(int numriSerik) throws FarmaciaException{
        if(numriSerik <= 0){
            throw new FarmaciaException("Numri serik nuk duhet te jete negativ apo 0!");
        }
        this.numriSerik = numriSerik;
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

    public String getPerbersiBaze() {
        return perbersiBaze;
    }

    public void setPerbersiBaze(String perbersiBaze) throws FarmaciaException{
        if(perbersiBaze.length() < 6){
            throw new FarmaciaException("Perberesi duhet te jete me i gjate se 5 shkronja!");
        }
        this.perbersiBaze = perbersiBaze;
    }

    public Date getDataSkadimit() {
        return dataSkadimit;
    }

    public void setDataSkadimit(Date dataSkadimit) {
        this.dataSkadimit = dataSkadimit;
    }

    public Integer getNumriTabletave() {
        return numriTabletave;
    }

    public void setNumriTabletave(Integer numriTabletave) throws FarmaciaException{
        if(numriTabletave <= 0){
            throw new FarmaciaException("Numri tabletave nuk duhet te jete negativ ose 0!");
        }
        if(numriTabletave < 8){
            throw new FarmaciaException("Numri tabletave qe permban nje paketim minimalja eshte 8!");
        }
        this.numriTabletave = numriTabletave;
    }

    public BigDecimal getQmimi() {
        return qmimi;
    }

    public void setQmimi(BigDecimal qmimi) throws FarmaciaException{
        this.qmimi = qmimi;
    }

    public BigDecimal getQmimiFurnizues() {
        return qmimiFurnizues;
    }

    public void setQmimiFurnizues(BigDecimal qmimiFurnizues) throws FarmaciaException{
        this.qmimiFurnizues = qmimiFurnizues;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }

    public void setProdhuesi(String prodhuesi) throws FarmaciaException{
        if(prodhuesi.matches("[0-9]+")){
            throw new FarmaciaException("Nuk duhet te permbaj numra!");
        }
        if(prodhuesi.length() < 3){
            throw new FarmaciaException("Prodhuesi duhet te jete me i gjate se 2 shkronja!");
        }
        this.prodhuesi = prodhuesi;
    }

    public String getShtetiProdhimit() {
        return shtetiProdhimit;
    }

    public void setShtetiProdhimit(String shtetiProdhimit) throws FarmaciaException{
        if(shtetiProdhimit.matches("[0-9]+")){
            throw new FarmaciaException("Nuk duhet te permbaj numra!");
        }
        if(shtetiProdhimit.length() < 3){
            throw new FarmaciaException("Prodhuesi duhet te jete me i gjate se 2 shkronja!");
        }
        this.shtetiProdhimit = shtetiProdhimit;
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

    public LlojiProduktit getLlojiProduktitID() {
        return llojiProduktitID;
    }

    public void setLlojiProduktitID(LlojiProduktit llojiProduktitID) {
        this.llojiProduktitID = llojiProduktitID;
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
        hash += (produktiID != null ? produktiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produkti)) {
            return false;
        }
        Produkti other = (Produkti) object;
        if ((this.produktiID == null && other.produktiID != null) || (this.produktiID != null && !this.produktiID.equals(other.produktiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri + " : " + numriTabletave;
    }

    @XmlTransient
    public List<ProduktetEFurnizuesit> getProduktetEFurnizuesitList() {
        return produktetEFurnizuesitList;
    }

    public void setProduktetEFurnizuesitList(List<ProduktetEFurnizuesit> produktetEFurnizuesitList) {
        this.produktetEFurnizuesitList = produktetEFurnizuesitList;
    }
    
}
