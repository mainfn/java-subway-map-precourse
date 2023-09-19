package subway.line;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import subway.station.Station;

public class LineRepository {

  private final Map<Line, List<Station>> subwayMap = new LinkedHashMap<>();

  public Map<Line, List<Station>> getSubwayMap() {
    return subwayMap;
  }

  public List<Line> findAllLines() {
    return List.copyOf(subwayMap.keySet());
  }

  public Optional<Line> findLineByName(final String lineName) {
    return findAllLines().stream()
        .filter(line -> line.getName().equals(lineName))
        .findFirst();
  }

  public Line getLineByName(final String lineName) {
    final Optional<Line> line = findLineByName(lineName);
    if (line.isEmpty()) {
      throw new IllegalArgumentException("존재하지 않는 노선입니다.");
    }
    return line.get();
  }

  public void addLine(final CreateLine createLine) {
    final Line line = Line.of(createLine.getLineName());
    final List<Station> stations = new ArrayList<>();
    stations.add(createLine.getFirstStation());
    stations.add(createLine.getLastStation());
    subwayMap.put(line, stations);
  }

  public void addLines(final CreateLine... createLines) {
    for (final CreateLine createLine : createLines) {
      addLine(createLine);
    }
  }

  // Line 및 등록된 구간 모두 삭제
  public void deleteLine(final Line line) {
    subwayMap.remove(line);
  }

  // Line 삭제
  public void deleteLineByName(final String lineName) {
//    TODO:

  }

  // 구간 추가
  public void addSection(
      final Line line,
      final Station station,
      final int order
  ) {
    final int index = order - 1;
    final List<Station> stations = subwayMap.get(line);

    stations.add(index, station);
  }

  // 구간 삭제
  public void deleteSection(
      final Line line,
      final Station station
  ) {
    final List<Station> stations = subwayMap.get(line);
    stations.removeIf(s -> s.equals(station));
  }

  public List<Station> findStationsByLine(final Line line) {
    return subwayMap.get(line);
  }
}
