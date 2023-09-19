package subway.utils;

import subway.line.CreateLine;
import subway.line.Line;
import subway.line.LineRepository;
import subway.station.Station;
import subway.station.StationRepository;

public final class DataContainer {

  private final StationRepository stationRepository;
  private final LineRepository lineRepository;

  public DataContainer(
      final StationRepository stationRepository,
      final LineRepository lineRepository
  ) {
    this.stationRepository = stationRepository;
    this.lineRepository = lineRepository;
  }

  public void save() {
    savePreStations();
  }

  private void savePreStations() {
    /**
     * Save Predefined Stations
     */
    final Station 교대역 = Station.of("교대역");
    final Station 강남역 = Station.of("강남역");
    final Station 역삼역 = Station.of("역삼역");
    final Station 남부터미널역 = Station.of("남부터미널역");
    final Station 양재역 = Station.of("양재역");
    final Station 양재시민의숲역 = Station.of("양재시민의숲역");
    final Station 매봉역 = Station.of("매봉역");
    stationRepository.addStations(교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역);

    /*
     * Save Predefined Lines
     */
    final CreateLine 이호선 = CreateLine.of("2호선", 교대역, 역삼역);
    final CreateLine 삼호선 = CreateLine.of("3호선", 교대역, 매봉역);
    final CreateLine 신분당선 = CreateLine.of("신분당선", 강남역, 양재시민의숲역);
    lineRepository.addLines(이호선, 삼호선, 신분당선);

    /*
     * Save Predefined Sections
     */
    final Line line2 = lineRepository.findLineByName("2호선").get();
    final Line line3 = lineRepository.findLineByName("2호선").get();
    final Line lineBun = lineRepository.findLineByName("2호선").get();
    lineRepository.addSection(line2, 역삼역, 3);

    lineRepository.addSection(line3, 양재역, 3);
    lineRepository.addSection(line3, 매봉역, 4);

    lineRepository.addSection(lineBun, 양재시민의숲역, 3);
  }
}
