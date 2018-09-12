/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nsand
 */
@Entity
@Table(name = "tbTweetsData")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "TbTweetsData.findAll", query = "SELECT t FROM TbTweetsData t")
    /*,    @NamedQuery(
    name="countPDate",
    query="SELECT data, DATEPART(hour,data) as Hour, Count(1) FROM tbTweetsData where CONVERT(date,data) = CONVERT (date, SYSDATETIME()) group by data, datepart(hour,data) order by 1,2")*/
    , @NamedQuery(name = "TbTweetsData.findById", query = "SELECT t FROM TbTweetsData t WHERE t.id = :id")
    , @NamedQuery(name = "TbTweetsData.findByHashtag", query = "SELECT t FROM TbTweetsData t WHERE t.hashtag = :hashtag")
    , @NamedQuery(name = "TbTweetsData.findByData", query = "SELECT t FROM TbTweetsData t WHERE t.data = :data")
    , @NamedQuery(name = "TbTweetsData.findByFollowers", query = "SELECT t FROM TbTweetsData t WHERE t.followers = :followers")
    , @NamedQuery(name = "TbTweetsData.findByCountry", query = "SELECT t FROM TbTweetsData t WHERE t.country = :country")
    , @NamedQuery(name = "TbTweetsData.findByLanguage", query = "SELECT t FROM TbTweetsData t WHERE t.language = :language")
    , @NamedQuery(name = "TbTweetsData.findByUserId", query = "SELECT t FROM TbTweetsData t WHERE t.userId = :userId")})
public class TbTweetsData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "hashtag")
    private String hashtag;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "followers")
    private Integer followers;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Size(max = 50)
    @Column(name = "language")
    private String language;
    @Size(max = 50)
    @Column(name = "userId")
    private String userId;

    public TbTweetsData() {
    }

    public TbTweetsData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        if (!(object instanceof TbTweetsData)) {
            return false;
        }
        TbTweetsData other = (TbTweetsData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.TbTweetsData[ id=" + id + " ]";
    }
    
}
