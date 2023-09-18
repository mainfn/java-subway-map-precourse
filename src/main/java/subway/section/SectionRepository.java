package subway.section;

import java.util.ArrayList;
import java.util.List;
import subway.line.Line;
import subway.station.Station;

public final class SectionRepository {

  private final List<Section> sections = new ArrayList<>();

  // 1. 구간 추가
  public void addSection(
      final Line line,
      final Station station,
      final int order
  ) {
    final int index = order - 1;
    final Section section = Section.of(line, station);
    sections.add(index, section);
  }
}
