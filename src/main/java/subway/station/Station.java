package subway.station;

import java.util.Objects;

public final class Station {

  private final String name;

  private Station(final String name) {
    validateStationNameLength(name);
    this.name = name;
  }

  public static Station of(final String name) {
    return new Station(name);
  }

  public String getName() {
    return name;
  }

  private void validateStationNameLength(final String stationName) {
    if (stationName.length() < 2) {
      throw new IllegalArgumentException("역명은 2글자 이상이어야 합니다.");
    }
  }

  // 추가 기능 구현

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Station station = (Station) object;
    return Objects.equals(name, station.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }


}
