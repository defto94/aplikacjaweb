/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aleksandra
 */
@Entity
@Table(name = "REGISTRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findById", query = "SELECT r FROM Registration r WHERE r.id = :id"),
    @NamedQuery(name = "Registration.findByLogin", query = "SELECT r FROM Registration r WHERE r.login = :login"),
    @NamedQuery(name = "Registration.findByMail", query = "SELECT r FROM Registration r WHERE r.mail = :mail"),
    @NamedQuery(name = "Registration.findByPassword1", query = "SELECT r FROM Registration r WHERE r.password1 = :password1"),
    @NamedQuery(name = "Registration.findByPassword2", query = "SELECT r FROM Registration r WHERE r.password2 = :password2")})
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @Column(name = "PASSWORD1")
    private String password1;
    @Basic(optional = false)
    @Column(name = "PASSWORD2")
    private String password2;

    public Registration() {
    }

    public Registration(BigDecimal id) {
        this.id = id;
    }

    public Registration(BigDecimal id, String login, String mail, String password1, String password2) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.password1 = password1;
        this.password2 = password2;
    }

    Registration(Integer userId, String login, String mail, String password1, String password2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sources.Registration[ id=" + id + " ]";
    }
    
}
