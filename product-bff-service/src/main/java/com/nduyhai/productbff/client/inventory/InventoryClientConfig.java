package com.nduyhai.productbff.client.inventory;

import com.nduyhai.productbff.client.RestClientProperties;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class InventoryClientConfig {

  @ConfigurationProperties(prefix = "client.inventory")
  @Bean
  public RestClientProperties inventoryProperties() {
    return new RestClientProperties();
  }

  @Bean
  public InventoryClient inventoryClient(
      RestClientProperties inventoryProperties, ObservationRegistry observationRegistry) {
    RestClient restClient =
        RestClient.builder()
            .baseUrl(inventoryProperties.getBaseUrl())
            .observationRegistry(observationRegistry)
            .build();

    RestClientAdapter adapter = RestClientAdapter.create(restClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

    return factory.createClient(InventoryClient.class);
  }
}
