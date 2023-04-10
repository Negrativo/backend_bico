package com.backend_bico.bico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coordenadas {

  private final double latitude;
  private final double longitude;

  public Coordenadas(String lat, String lon) {
    this.latitude = Double.parseDouble(lat);
    this.longitude = Double.parseDouble(lon);
  }

}
