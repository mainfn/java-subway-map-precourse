package subway.line;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import subway.station.Station;
import subway.station.StationRepository;

public final class LineService {

  private final LineRepository lineRepository;
  private final StationRepository stationRepository;

  public LineService(
      final LineRepository lineRepository,
      final StationRepository stationRepository
  ) {
    this.lineRepository = lineRepository;
    this.stationRepository = stationRepository;
  }

  // 1. 지하철 노선 등록
  public void addLine(final CreateLine createLine) {
    final Optional<Line> foundLine = lineRepository.findLineByName(createLine.getLineName());

    if (foundLine.isPresent()) {
      throw new IllegalArgumentException("중복된 노선명입니다");
    }

    lineRepository.addLine(createLine);
  }

  // 지하철 노선 생성
  private void createLine(
      final String lineName,
      final String firstStationName,
      final String lastStationName
  ) {
    final Optional<Station> firstStation = stationRepository.findByName(firstStationName);
    final Optional<Station> lastStation = stationRepository.findByName(lastStationName);

    if (firstStation.isEmpty() || lastStation.isEmpty()) {
      throw new IllegalArgumentException("유효하지 않은 상행 or 하행역명입니다.");
    }
    CreateLine createLine = CreateLine.of(lineName, firstStation.get(), lastStation.get());
    lineRepository.addLine(createLine);
  }

  // 2. 지하철 노선 삭제
  public void deleteLine(final String lineName) {
    final Optional<Line> foundLine = lineRepository.findLineByName(lineName);
    if (foundLine.isEmpty()) {
      throw new IllegalArgumentException("존재하지 않는 노선입니다.");
    }

    final List<Station> stations = lineRepository.findStationsByLine(foundLine.get());
    if (!stations.isEmpty()) {
      throw new IllegalStateException("해당 노선이 포함하는 구간이 존재하므로 삭제 불가입니다");
    }
    lineRepository.deleteLineByName(lineName);
  }

  // 3. 지하철 노선 조회
  public Map<Line, List<Station>> getSubwayMap() {
    return lineRepository.getSubwayMap();
  }

  public List<Line> findAllLines() {
    return lineRepository.findAllLines();
  }
}
