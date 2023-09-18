package subway.line;

import subway.station.Station;

public final class Line {

  private final String name;
  private final Station firstStation;
  private final Station lastStation;

  private Line(
      final String name,
      final Station firstStation,
      final Station lastStation
  ) {
    validateLineNameLength(name);
    this.name = name;
    this.firstStation = firstStation;
    this.lastStation = lastStation;
  }

  public static Line of(
      final String name,
      final Station firstStation,
      final Station lastStation
  ) {
    return new Line(name, firstStation, lastStation);
  }

  private void validateLineNameLength(final String lineName) {
    if (lineName.length() < 2) {
      throw new IllegalArgumentException("노선명은 2글자 이상이어야 합니다");
    }
  }

  // 추가 기능 구현
  public String getName() {
    return name;
  }

  public Station getFirstStation() {
    return firstStation;
  }

  public Station getLastStation() {
    return lastStation;
  }
}
