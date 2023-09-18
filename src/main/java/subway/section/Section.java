package subway.section;

import java.util.Objects;
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

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Section section = (Section) object;
    return Objects.equals(line, section.line) && Objects.equals(station,
        section.station);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line, station);
  }
}
