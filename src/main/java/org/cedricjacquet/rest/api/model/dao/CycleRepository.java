/**
 * 
 */
package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cjacquet
 *
 */
@Transactional
public interface CycleRepository extends PagingAndSortingRepository<Cycle, Integer> {

}
