package com.facturacion.facturacion.infrastructure.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
class DiscoveryDebugController {

  private final org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;

  @GetMapping("/debug/instances/{serviceId}")
  public Object instances(@PathVariable String serviceId) {
    return discoveryClient.getInstances(serviceId);
  }
}

