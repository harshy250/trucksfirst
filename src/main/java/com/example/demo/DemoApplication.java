
              package com.example.demo;
              import com.example.demo.model.Trucks;
              import com.example.demo.repository.TrucksRepository;
              import org.springframework.beans.factory.annotation.Autowired;
              import org.springframework.boot.CommandLineRunner;
              import org.springframework.boot.SpringApplication;
              import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
              import org.springframework.boot.autoconfigure.SpringBootApplication;
              import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
              import org.springframework.web.bind.annotation.GetMapping;
              import org.springframework.web.bind.annotation.RequestParam;
              import org.springframework.web.bind.annotation.RestController;

              @SpringBootApplication
//              @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
              @RestController
              public class DemoApplication implements CommandLineRunner {

                  public static void main(String[] args) {
                  SpringApplication.run(DemoApplication.class, args);
                  }

                  @Autowired
                  private TrucksRepository trucksRepository;
                  @Override
                  public void run(String... args) throws Exception {
//                      Trucks truck1 = new Trucks();
//                      truck1.setTruck_id(10);
//                      truck1.setSpace(100);
//                      trucksRepository.save(truck1);
//
//                      Trucks truck2 = new Trucks();
//                      truck1.setTruck_id(12);
//                      truck2.setSpace(1000);
//                      trucksRepository.save(truck2);

                  }

//                  @GetMapping("/hello")
//                  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//                  return String.format("Hello %s!", name);
//                  }
                
              }
            