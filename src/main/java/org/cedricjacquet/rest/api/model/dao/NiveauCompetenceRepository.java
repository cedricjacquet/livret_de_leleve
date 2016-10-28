package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.NiveauCompetence;
import org.springframework.data.repository.PagingAndSortingRepository;

@Transactional
public interface NiveauCompetenceRepository  extends PagingAndSortingRepository<NiveauCompetence, Integer> {

}
