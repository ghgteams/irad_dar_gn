package com.irad.dar.documents;

import java.util.List;

public interface DocumentService {

	String savePassengerdocuments(DocumentEntity documentEntity);

	public List<EdarFormsDocEntity> getEdarDocForms(String accidentId);

	String saveEdarDocuments(EdarDocumentsEntity edarDocumentsEntity);

}
