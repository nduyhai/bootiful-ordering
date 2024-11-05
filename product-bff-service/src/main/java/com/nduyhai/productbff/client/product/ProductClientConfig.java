package com.nduyhai.productbff.client.product;

import com.nduyhai.productbff.client.RestClientProperties;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ProductClientConfig {

  @ConfigurationProperties(prefix = "client.product")
  @Bean
  public RestClientProperties productProperties() {
    return new RestClientProperties();
  }

  @Bean
  public ProductClient productClient(
      RestClientProperties productProperties, ObservationRegistry observationRegistry) {

    RestClient restClient =
        RestClient.builder()
            .baseUrl(productProperties.getBaseUrl())
            .observationRegistry(observationRegistry)
            .build();
    RestClientAdapter adapter = RestClientAdapter.create(restClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

    return factory.createClient(ProductClient.class);
  }
}
