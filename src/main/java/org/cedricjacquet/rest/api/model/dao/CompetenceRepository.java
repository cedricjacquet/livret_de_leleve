package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.Competence;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cjacquet
 *
 */
@Transactional
public interface CompetenceRepository extends PagingAndSortingRepository<Competence, Integer> {

}