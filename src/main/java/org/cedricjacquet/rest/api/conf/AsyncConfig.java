package org.cedricjacquet.rest.api.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author cjacquet
 *
 */
@Configuration
@EnableAsync(proxyTargetClass = true)
public class AsyncConfig {

}
