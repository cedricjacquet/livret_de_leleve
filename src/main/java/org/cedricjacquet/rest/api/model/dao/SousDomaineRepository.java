/**
 * 
 */
package org.cedricjacquet.rest.api.model.dao;

import javax.transaction.Transactional;

import org.cedricjacquet.rest.api.model.entity.SousDomaine;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cjacquet
 *
 */
@Transactional
public interface SousDomaineRepository extends PagingAndSortingRepository<SousDomaine, Integer> {

}
