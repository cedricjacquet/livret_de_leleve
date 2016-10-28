package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.Eleve;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 
 * @author cjacquet
 *
 */
@Transactional
public interface EleveRepository extends PagingAndSortingRepository<Eleve, Integer> {

}

