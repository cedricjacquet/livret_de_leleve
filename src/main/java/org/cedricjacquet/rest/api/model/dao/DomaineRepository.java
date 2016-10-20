/**
 * 
 */
package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.Domaine;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cjacquet
 *
 */
@Transactional
public interface DomaineRepository extends PagingAndSortingRepository<Domaine, Integer> {

}
