package subway.section;

import subway.line.Line;
import subway.station.Station;

public final class Section {

  private final Line line;
  private final Station station;

  private Section(
      final Line line,
      final Station station
  ) {
    this.line = line;
    this.station = station;
  }

  public static Section of(
      final Line line,
      final Station station
  ) {
    return new Section(line, station);
  }

  public Line getLine() {
    return line;
  }

  public Station getStation() {
    return station;
  }
}
