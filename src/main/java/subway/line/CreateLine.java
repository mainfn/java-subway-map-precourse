package subway.line;

import subway.station.Station;

public final class CreateLine {

  private final String lineName;
  private final Station firstStation;
  private final Station lastStation;

  private CreateLine(
      final String lineName,
      final Station firstStation,
      final Station lastStation
  ) {
    this.lineName = lineName;
    this.firstStation = firstStation;
    this.lastStation = lastStation;
  }

  public static CreateLine of(
      final String lineName,
      final Station firstStation,
      final Station lastStation
  ) {
    return new CreateLine(lineName, firstStation, lastStation);
  }

  public String getLineName() {
    return lineName;
  }

  public Station getFirstStation() {
    return firstStation;
  }

  public Station getLastStation() {
    return lastStation;
  }
}
