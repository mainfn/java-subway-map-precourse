package subway.section;

import subway.line.Line;
import subway.line.LineRepository;
import subway.station.Station;
import subway.station.StationRepository;

public final class SectionService {

  private final LineRepository lineRepository;
  private final SectionRepository sectionRepository;
  private final StationRepository stationRepository;

  public SectionService(
      final LineRepository lineRepository,
      final SectionRepository sectionRepository,
      final StationRepository stationRepository
  ) {
    this.lineRepository = lineRepository;
    this.sectionRepository = sectionRepository;
    this.stationRepository = stationRepository;
  }

  // 1. 구간 추가
  public void addSection(
      final String lineName,
      final String stationName,
      final int order
  ) {
    final Line line = lineRepository.getByName(lineName);
    final Station station = stationRepository.getByName(stationName);

    sectionRepository.addSection(line, station, order);
  }

  // 2. 구간 삭제
  public void deleteSection(
      final String lineName,
      final String stationName
  ) {
    final Line line = lineRepository.getByName(lineName);
    final Station station = stationRepository.getByName(stationName);
    sectionRepository.deleteSection(line, station);
  }
}
