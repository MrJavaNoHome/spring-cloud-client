package konrad.feignclient.withouthystrix;

import feign.FeignException;
import feign.RetryableException;
import konrad.CloudClient;
import konrad.feignclient.FeignClientWithHystrix;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudClient.class)
public class TestFeignClientFallbacks {

   @Autowired
   private FeignClientWithoutHystrix feignClientWithoutHystrix;

   @Autowired
   private FeignClientWithHystrix feignClientWithHystrix;

   @Test(expected = FeignException.class)
   public void exceptionWithNoFallback() {
      feignClientWithoutHystrix.getFromFakeUrl();
   }

   @Test
   public void fallback() {
      Assert.assertEquals("Fallback", feignClientWithHystrix.getFromFakeUrl());
   }

}