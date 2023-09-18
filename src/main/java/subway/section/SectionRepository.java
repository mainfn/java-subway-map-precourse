package subway.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.line.Line;
import subway.station.Station;

public final class SectionRepository {

  private final Map<Line, List<Section>> sectionMap = new HashMap<>();

  // 1. 구간 추가
  public void addSection(
      final Line line,
      final Station station,
      final int order
  ) {
    final int index = order - 1;
    final Section section = Section.of(line, station);
    sectionMap.putIfAbsent(line, new ArrayList<>());
    sectionMap.get(line).add(index, section);
  }

  // 2. 구간 삭제
  public void deleteSection(
      final Line line,
      final Station station
  ) {
    final List<Section> sections = getSectionsByLine(line);

    sections
        .removeIf(section -> section.getStation().equals(station)
        );
  }

  private List<Section> getSectionsByLine(final Line line) {
    return sectionMap.get(line);
  }
}
