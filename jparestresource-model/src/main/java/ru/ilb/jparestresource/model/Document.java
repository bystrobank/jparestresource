/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.jparestresource.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Convert;
import ru.ilb.common.jpa.history.AutoHistory;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(indexes = @Index(columnList = "DOCDATE"))
@AutoHistory
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    /**
     * Document name
     */
    @Basic
    @Size(min = 1, max = 255, message = "must be beweeen 1 and 255 chars")
    @XmlElement
    private String displayName;
    /**
     * Document description
     */
    @Basic
    private String description;
    /**
     * Document date
     */
    @Basic
    private LocalDate docDate;
    /**
     * UUID документа
     */
    @Basic
    @Column(unique = true)
    @Convert("uuid")
    private UUID uid;
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Document document;
    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = CascadeType.ALL)
    @CascadeOnDelete
    @XmlElementRef
    private List<Docfile> docfiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get document name
     *
     * @return {@link #displayName}
     */

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set document name
     *
     * @param displayName {@link #displayName}
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Set document name
     *
     * @param displayName {@link #displayName}
     * @return {@link #Document}
     */
    public Document withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get document description
     *
     * @return {@link #description}
     */

    public String getDescription() {
        return description;
    }

    /**
     * Set document description
     *
     * @param description {@link #description}
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set document description
     *
     * @param description {@link #description}
     * @return {@link #Document}
     */
    public Document withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get document date
     *
     * @return {@link #docDate}
     */

    public LocalDate getDocDate() {
        return docDate;
    }

    /**
     * Set document date
     *
     * @param docDate {@link #docDate}
     */
    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    /**
     * Set document date
     *
     * @param docDate {@link #docDate}
     * @return {@link #Document}
     */
    public Document withDocDate(LocalDate docDate) {
        this.docDate = docDate;
        return this;
    }

    /**
     * Get UUID документа
     *
     * @return {@link #uid}
     */
    public UUID getUid() {
        return uid;
    }

    /**
     * Set UUID документа
     *
     * @param uid {@link #uid}
     */
    public void setUid(UUID uid) {
        this.uid = uid;
    }

    /**
     * Set UUID документа
     *
     * @param uid {@link #uid}
     * @return {@link #Document}
     */
    public Document withUid(UUID uid) {
        this.uid = uid;
        return this;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Document withDocument(Document document) {
        this.document = document;
        return this;
    }

    public void addDoc(Docfile doc) {
        this.getDocfiles().add(doc);
    }

    public void addDoc2(Docfile doc) {
        this.getDocfiles().add(doc);
    }

    public List<Docfile> getDocfiles() {
        if (docfiles == null) {
            docfiles = new ArrayList<>();
        }
        return docfiles;
    }

    public void setDocfiles(List<Docfile> docfiles) {
        this.docfiles = docfiles;
    }

    public Document withDocfiles(List<Docfile> docfiles) {
        this.docfiles = docfiles;
        return this;
    }

    public void addDocfile(Docfile docfile) {
        getDocfiles().add(docfile);
        docfile.setDocument(this);
    }

    public void removeDocfile(Docfile docfile) {
        getDocfiles().remove(docfile);
        docfile.setDocument(null);
    }

}