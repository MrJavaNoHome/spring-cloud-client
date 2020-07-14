package konrad;

import konrad.feignclient.withouthystrix.FeignClientWithoutHystrixConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = "konrad",
      excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = FeignClientWithoutHystrixConfig.class)})
public class CloudClient {

   public static void main(String[] args) {
      SpringApplication.run(CloudClient.class, args);
   }

}
