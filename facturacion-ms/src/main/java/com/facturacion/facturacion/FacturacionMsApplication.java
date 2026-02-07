package com.facturacion.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.facturacion.facturacion.infrastructure.client.feign")
public class FacturacionMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturacionMsApplication.class, args);
    }
}
