package konrad.feignclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "withHystrix", url = "conrad.fake", fallback = FeignClientWithHystrix.Fallback.class)
public interface FeignClientWithHystrix {

   @RequestMapping(method = RequestMethod.GET, value = "/fake/url")
   String getFromFakeUrl();

   @Component
   class Fallback implements FeignClientWithHystrix {

      private final Logger log = LoggerFactory.getLogger(this.getClass());

      @Override
      public String getFromFakeUrl() {
         log.debug("Fallback occurred for getFromFakeUrl");
         return "Fallback";
      }
   }

}
