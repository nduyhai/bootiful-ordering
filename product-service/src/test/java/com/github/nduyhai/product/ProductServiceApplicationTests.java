package com.github.nduyhai.product;

import com.nduyhai.product.ProductServiceApplication;
import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(classes = ProductServiceApplication.class)
class ProductServiceApplicationTests {
  static PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>("postgres:15.2")
          .withDatabaseName("testdb")
          .withUsername("test")
          .withPassword("test");

  static {
    postgres.start();
  }

  @Autowired private DataSource dataSource;

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
  }

  @Test
  void testConnection() {
    Assertions.assertDoesNotThrow(
        () -> {
          System.out.println("Database URL: " + dataSource.getConnection().getMetaData().getURL());
        });
  }

  @Test
  void moduleCheck() {
    Assertions.assertDoesNotThrow(
        () -> {
          ApplicationModules modules = ApplicationModules.of(ProductServiceApplication.class);
          modules.forEach(System.out::println);

          modules.verify();
        });
  }

  @Test
  void writeDocumentationSnippets() {
    Assertions.assertDoesNotThrow(
        () -> {
          ApplicationModules modules = ApplicationModules.of(ProductServiceApplication.class);

          new Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
        });
  }

  @Test
  void writeAggregatingDocumentationSnippets() {
    Assertions.assertDoesNotThrow(
        () -> {
          ApplicationModules modules = ApplicationModules.of(ProductServiceApplication.class);

          new Documenter(modules).writeAggregatingDocument();
        });
  }
}
