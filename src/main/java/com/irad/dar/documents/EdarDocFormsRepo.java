package com.irad.dar.documents;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EdarDocFormsRepo extends JpaRepository<EdarFormsDocEntity, Long>{
	@Query(nativeQuery = true,value="select * from documents.edar_forms_doc where accident_id=:accidentId  and formno='1' and doctype='general' and doc_name in ('far','fir') and flag='1'")
	public List<EdarFormsDocEntity> getEdarDocForms(String accidentId);

	public void save(EdarDocumentsEntity edarDocumentsEntity);

}
