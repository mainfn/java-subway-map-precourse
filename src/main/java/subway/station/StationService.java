package subway.station;

import java.util.List;
import java.util.Optional;

public final class StationService {

  private final StationRepository stationRepository;

  public StationService(final StationRepository stationRepository) {
    this.stationRepository = stationRepository;
  }

  // 1. 지하철 역 등록
  public void addStation(final String stationName) {
    final Optional<Station> station = stationRepository.findByName(stationName);
    if (station.isPresent()) {
      throw new IllegalArgumentException("이미 존재하는 역입니다.");
    }
    stationRepository.addStation(Station.of(stationName));
  }

  // 2. 지하철 역 삭제
  public void deleteStation(final String stationName) {
    // TODO: 노선(Section)에 등록된 역은 삭제할 수 없음
    stationRepository.deleteByName(stationName);
  }

  // 3. 모든 지하철 역 조회
  public List<Station> findAllStations() {
    return stationRepository.findAllStations();
  }
}
