/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

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
 * @author Auron
 */
@Entity
@Table(name = "ProduktetEFurnizuesit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduktetEFurnizuesit.findAll", query = "SELECT p FROM ProduktetEFurnizuesit p")
    , @NamedQuery(name = "ProduktetEFurnizuesit.findByProduktetEFurnizuesitID", query = "SELECT p FROM ProduktetEFurnizuesit p WHERE p.produktetEFurnizuesitID = :produktetEFurnizuesitID")})
public class ProduktetEFurnizuesit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProduktetEFurnizuesitID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer produktetEFurnizuesitID;
    @JoinColumn(name = "Furnizuesi_ID", referencedColumnName = "Furnizuesi_ID")
    @ManyToOne
    private Furnizuesi furnizuesiID;
    @JoinColumn(name = "Produkti_ID", referencedColumnName = "Produkti_ID")
    @ManyToOne
    private Produkti produktiID;

    public ProduktetEFurnizuesit() {
    }

    public ProduktetEFurnizuesit(Integer produktetEFurnizuesitID) {
        this.produktetEFurnizuesitID = produktetEFurnizuesitID;
    }

    public Integer getProduktetEFurnizuesitID() {
        return produktetEFurnizuesitID;
    }

    public void setProduktetEFurnizuesitID(Integer produktetEFurnizuesitID) {
        this.produktetEFurnizuesitID = produktetEFurnizuesitID;
    }

    public Furnizuesi getFurnizuesiID() {
        return furnizuesiID;
    }

    public void setFurnizuesiID(Furnizuesi furnizuesiID) {
        this.furnizuesiID = furnizuesiID;
    }

    public Produkti getProduktiID() {
        return produktiID;
    }

    public void setProduktiID(Produkti produktiID) {
        this.produktiID = produktiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produktetEFurnizuesitID != null ? produktetEFurnizuesitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduktetEFurnizuesit)) {
            return false;
        }
        ProduktetEFurnizuesit other = (ProduktetEFurnizuesit) object;
        if ((this.produktetEFurnizuesitID == null && other.produktetEFurnizuesitID != null) || (this.produktetEFurnizuesitID != null && !this.produktetEFurnizuesitID.equals(other.produktetEFurnizuesitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.ProduktetEFurnizuesit[ produktetEFurnizuesitID=" + produktetEFurnizuesitID + " ]";
    }
    
}
