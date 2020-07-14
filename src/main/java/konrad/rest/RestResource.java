package konrad.rest;

import konrad.feignclient.FeignClientWithHystrix;
import konrad.feignclient.withouthystrix.FeignClientWithoutHystrix;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestResource {

   private final FeignClientWithHystrix feignClientWithHystrix;
   private final FeignClientWithoutHystrix feignClientWithoutHystrix;

   public RestResource(FeignClientWithHystrix feignClientWithHystrix, FeignClientWithoutHystrix feignClientWithoutHystrix) {
      this.feignClientWithHystrix = feignClientWithHystrix;
      this.feignClientWithoutHystrix = feignClientWithoutHystrix;
   }

   @GetMapping("/call-feign-client-with-hystrix")
   public String callFeignClientWithHystrix() {
      return feignClientWithHystrix.getFromFakeUrl();
   }

   @GetMapping("/call-feign-client-without-hystrix")
   public String callFeignClientWithoutHystrix() {
      return feignClientWithoutHystrix.getFromFakeUrl();
   }

   @GetMapping("/return-404")
   public ResponseEntity<Void> return404() {
      return ResponseEntity.notFound().build();
   }

}
