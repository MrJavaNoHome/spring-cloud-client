package konrad.feignclient.withouthystrix;

import feign.Feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientWithoutHystrixConfig {

   private final Logger log = LoggerFactory.getLogger(this.getClass());

   @Bean
   public Feign.Builder feignBuilder() {
      log.debug("Creating feign builder without hystrix");
      return Feign.builder();
   }

}
