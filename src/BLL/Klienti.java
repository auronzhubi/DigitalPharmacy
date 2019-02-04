/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.FarmaciaException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    //((Number)em.createNamedQuery("Charakteristika.findAllCount").getSingleResult()).intValue();
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k")
    , @NamedQuery(name = "Klienti.findByKlientiID", query = "SELECT k FROM Klienti k WHERE k.klientiID = :klientiID")
    , @NamedQuery(name = "Klienti.findByEmri", query = "SELECT k FROM Klienti k WHERE k.emri = :emri")
    , @NamedQuery(name = "Klienti.findByMbiemri", query = "SELECT k FROM Klienti k WHERE k.mbiemri = :mbiemri")
    , @NamedQuery(name = "Klienti.findByDataLindjes", query = "SELECT k FROM Klienti k WHERE k.dataLindjes = :dataLindjes")
    , @NamedQuery(name = "Klienti.findByGjinia", query = "SELECT k FROM Klienti k WHERE k.gjinia = :gjinia")
    , @NamedQuery(name = "Klienti.findByNrTelefonit", query = "SELECT k FROM Klienti k WHERE k.nrTelefonit = :nrTelefonit")
    , @NamedQuery(name = "Klienti.findByEmriRruges", query = "SELECT k FROM Klienti k WHERE k.emriRruges = :emriRruges")
    , @NamedQuery(name = "Klienti.findByNumriHyrjes", query = "SELECT k FROM Klienti k WHERE k.numriHyrjes = :numriHyrjes")
    , @NamedQuery(name = "Klienti.findByKati", query = "SELECT k FROM Klienti k WHERE k.kati = :kati")
    , @NamedQuery(name = "Klienti.findByPershkrimi", query = "SELECT k FROM Klienti k WHERE k.pershkrimi = :pershkrimi")
    , @NamedQuery(name = "Klienti.numeroKlientat", query = "SELECT count(k) FROM Klienti k")})
public class Klienti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Klienti_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer klientiID;
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
    @Basic(optional = false)
    @Column(name = "NrTelefonit")
    private String nrTelefonit;
    @Basic(optional = false)
    @Column(name = "EmriRruges")
    private String emriRruges;
    @Column(name = "NumriHyrjes")
    private Integer numriHyrjes;
    @Column(name = "Kati")
    private Integer kati;
    @Column(name = "Pershkrimi")
    private String pershkrimi;
    @OneToMany(mappedBy = "klientiID")
    private List<Terapia> terapiaList;
    @JoinColumn(name = "Komuna_ID", referencedColumnName = "Komuna_ID")
    @ManyToOne
    private Komuna komunaID;
    @OneToMany(mappedBy = "klientiID")
    private List<Fatura> faturaList;

    public Klienti() {
    }

    public Klienti(Integer klientiID) throws FarmaciaException{
        this.klientiID = klientiID;
    }

    public Klienti(Integer klientiID, String emri, String mbiemri, Date dataLindjes, String nrTelefonit, String emriRruges) throws FarmaciaException{
        this.klientiID = klientiID;
        
        if(emri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emri.length() <3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.emri = emri;
        
        if(mbiemri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(mbiemri.length() <3){
            throw new FarmaciaException("Emri duhet te jete me i gjate se 2 shkronja!");
        }
        this.mbiemri = mbiemri;
        
        this.dataLindjes = dataLindjes;
        
        if(!nrTelefonit.startsWith("0")){
            throw new FarmaciaException("Numri kontaktues duhet te filloj me 0!");
        }
        if(nrTelefonit.length() < 9){
            throw new FarmaciaException("Numri kontaktues duhet te jete 9 shifror!");
        }
        this.nrTelefonit = nrTelefonit;
        
        this.emriRruges = emriRruges;
    }

    public Integer getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Integer klientiID) {
        this.klientiID = klientiID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) throws FarmaciaException{
        if(emri.matches("[0-9]+")){
            throw new FarmaciaException("Emri nuk duhet te permbaj numra!");
        }
        if(emri.length() <3){
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
        if(mbiemri.length() <3){
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

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public void setNrTelefonit(String nrTelefonit) throws FarmaciaException{
        if(!nrTelefonit.startsWith("0")){
            throw new FarmaciaException("Numri kontaktues duhet te filloj me 0!");
        }
        if(nrTelefonit.length() < 9){
            throw new FarmaciaException("Numri kontaktues duhet te jete 9 shifror!");
        }
        this.nrTelefonit = nrTelefonit;
    }

    public String getEmriRruges() {
        return emriRruges;
    }

    public void setEmriRruges(String emriRruges) {
        this.emriRruges = emriRruges;
    }

    public Integer getNumriHyrjes() {
        return numriHyrjes;
    }

    public void setNumriHyrjes(Integer numriHyrjes) throws FarmaciaException{
        if(numriHyrjes <= 0){
            throw new FarmaciaException("Numri hyrjes nuk duhet te jete negativ ose 0!");
        }
        this.numriHyrjes = numriHyrjes;
    }

    public Integer getKati() {
        return kati;
    }

    public void setKati(Integer kati) throws FarmaciaException{
        if(kati <= 0){
            throw new FarmaciaException("Numri i katit nuk duhet te jete negativ ose 0!");
        }
        this.kati = kati;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    @XmlTransient
    public List<Terapia> getTerapiaList() {
        return terapiaList;
    }

    public void setTerapiaList(List<Terapia> terapiaList) {
        this.terapiaList = terapiaList;
    }

    public Komuna getKomunaID() {
        return komunaID;
    }

    public void setKomunaID(Komuna komunaID) {
        this.komunaID = komunaID;
    }

    @XmlTransient
    public List<Fatura> getFaturaList() {
        return faturaList;
    }

    public void setFaturaList(List<Fatura> faturaList) {
        this.faturaList = faturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klientiID != null ? klientiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.klientiID == null && other.klientiID != null) || (this.klientiID != null && !this.klientiID.equals(other.klientiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri + " " + mbiemri;
    }
    
}
