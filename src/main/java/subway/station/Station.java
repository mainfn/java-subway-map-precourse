package subway.station;

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
}
