package subway.section;

import subway.line.Line;
import subway.line.LineRepository;
import subway.station.Station;
import subway.station.StationRepository;

public final class SectionService {

  private final LineRepository lineRepository;
  private final StationRepository stationRepository;

  public SectionService(
      final LineRepository lineRepository,
      final StationRepository stationRepository
  ) {
    this.lineRepository = lineRepository;
    this.stationRepository = stationRepository;
  }

  // 1. 구간 추가
  public void addSection(final CreateSection createSection) {
    final Line line = lineRepository.getLineByName(createSection.getLineName());
    final Station station = stationRepository.getByName(createSection.getStationName());

    lineRepository.addSection(line, station, createSection.getOrder());
  }

  // 2. 구간 삭제
  public void deleteSection(final DeleteSection deleteSection) {
    final Line line = lineRepository.getLineByName(deleteSection.getLineName());
    final Station station = stationRepository.getByName(deleteSection.getStationName());
    lineRepository.deleteSection(line, station);
  }
}
