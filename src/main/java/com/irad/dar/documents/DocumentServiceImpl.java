package com.irad.dar.documents;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	DocumentDao documentDao;
	@Autowired
	EdarDocFormsRepo edarDocFormsRepo;

	@Override
	public String savePassengerdocuments(DocumentEntity documentEntity) {
		if (documentEntity.getAccidentId() != null) {
			documentDao.save(documentEntity);
			return "Success";
		}
		return "Failed";
	}

	@Override
	public List<EdarFormsDocEntity> getEdarDocForms(String accidentId) {
     List<EdarFormsDocEntity> getEdarDocForms = edarDocFormsRepo.getEdarDocForms(accidentId);
		
		return getEdarDocForms;
	}

	@Override
	public String saveEdarDocuments(EdarDocumentsEntity edarDocumentsEntity) {
		System.out.println(edarDocumentsEntity.getAccidentId());
		if (edarDocumentsEntity.getAccidentId() != null) {
			edarDocFormsRepo.save(edarDocumentsEntity);
			return "Success";
		}
		return "Failed";
	}

}
