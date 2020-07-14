package konrad.feignclient.withouthystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "withoutHystrix",
      url = "conrad.fake",
      fallback = FeignClientWithoutHystrix.FallbackThatShouldNotOccur.class,
      configuration = FeignClientWithoutHystrixConfig.class)
public interface FeignClientWithoutHystrix {

   @RequestMapping(method = RequestMethod.GET, value = "/fake/url")
   String getFromFakeUrl();

   @Component
   class FallbackThatShouldNotOccur implements FeignClientWithoutHystrix {

      private final Logger log = LoggerFactory.getLogger(this.getClass());

      @Override
      public String getFromFakeUrl() {
         log.error("This fallback shouldn't occur");
         return "Fallback";
      }
   }

}
