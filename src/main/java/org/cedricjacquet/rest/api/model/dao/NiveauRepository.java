/**
 * 
 */
package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.Niveau;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cjacquet
 *
 */
@Transactional
public interface NiveauRepository extends PagingAndSortingRepository<Niveau, Integer> {

}
