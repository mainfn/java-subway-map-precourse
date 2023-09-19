package subway.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class StationRepository {

  private final List<Station> stations = new ArrayList<>();

  public List<Station> findAllStations() {
    return Collections.unmodifiableList(stations);
  }

  public void addStation(final Station station) {
    stations.add(station);
  }

  public void addStations(final Station... stations) {
    for (final Station station : stations) {
      addStation(station);
    }
  }

  public void deleteByName(final String name) {
    stations.removeIf(station -> Objects.equals(station.getName(), name));
  }

  public Optional<Station> findByName(final String stationName) {
    return stations.stream()
        .filter(station -> station.getName().equals(stationName))
        .findFirst();
  }

  public Station getByName(final String stationName) {
    final Optional<Station> station = findByName(stationName);
    if (station.isEmpty()) {
      throw new IllegalArgumentException("존재하지 않는 역입니다.");
    }
    return station.get();
  }

}
