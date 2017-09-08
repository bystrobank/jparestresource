/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ilb.jparestresource.web;

import io.swagger.annotations.Api;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ilb.jparestresource.api.DocumentsResource;
import ru.ilb.jparestresource.mappers.DocumentMapper;
import ru.ilb.jparestresource.utils.JaxbHelper;
import ru.ilb.jparestresource.repositories.DocumentRepository;
import ru.ilb.jparestresource.providers.AuthorizationHandler;
import ru.ilb.jparestresource.view.Document;
import ru.ilb.jparestresource.view.Documents;

@Path("documents")
@Api("documents")
public class DocumentsResourceImpl implements DocumentsResource {
    
    @Autowired 
    AuthorizationHandler authorizationHandler;

    @Autowired
    JaxbHelper jaxbHelper;
    
    @Autowired
    private DocumentMapper documentMapper;
    
    private UriInfo uriInfo;

    @Context
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Autowired
    DocumentRepository documentRepository;

    private SearchContext searchContext;

    @Context
    public void setSearchContext(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    private static final Logger LOG = LoggerFactory.getLogger(DocumentsResourceImpl.class);

//    @Override
//    @Transactional
//    public Document find(long  documentId) {
//        return documentRepository.findOne(documentId);
//    }
//
//    @Override
//    @Transactional
//    public long create(Document document) {
//        return documentRepository.save(document).getId();
//    }
//
//    @Override
//    @Transactional
//    public void edit(long  documentId, Document document) {
//        Document doc = documentRepository.findOne(documentId);
//        BeanUtils.copyProperties(document, doc, new String[]{"id"});
//    }
//
//    @Override
//    @Transactional
//    public void remove(long  documentId) {
//        documentRepository.delete(documentId);
//    }
//
//    @Override
//    public List<Document> list(Integer limit, String order) {
//        return documentRepository.findAll();
//    }
//
//    @Override
//    @Transactional
//    public void createBatch(List<Document> documents) {
//        documentRepository.save(documents);
//    }

    @Override
    public Documents list(Integer limit, String order) {
        return documentMapper.createWrapperFromEntities(documentRepository.findAll());
    }

    @Override
    public long create(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createBatch(Documents documents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(long documentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Document find(long documentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(long documentId, Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
