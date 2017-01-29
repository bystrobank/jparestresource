/**
 * This file was generated by the JPA Modeler
 */ 

package ru.ilb.jparestresource.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name="DOCUMENT",uniqueConstraints={@UniqueConstraint(columnNames={"UID"})})
public class Document implements Serializable { 

    @Column(nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    private String description;

    @Basic
    private Integer direction;

    @Basic
    private String displayName;

    @Basic
    private LocalDate docDate;

    @Basic
    private String keywords;

    @XmlTransient
    @OneToMany(targetEntity = Docfile.class,mappedBy = "document")
    private List<Docfile> docfiles;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDirection() {
        return this.direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LocalDate getDocDate() {
        return this.docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<Docfile> getDocfiles() {
        return this.docfiles;
    }

    public void setDocfiles(List<Docfile> docfiles) {
        this.docfiles = docfiles;
    }

}
