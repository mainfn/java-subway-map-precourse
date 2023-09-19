package subway;

import subway.line.LineController;
import subway.line.LineRepository;
import subway.line.LineService;
import subway.section.SectionController;
import subway.section.SectionService;
import subway.station.StationController;
import subway.station.StationRepository;
import subway.station.StationService;
import subway.utils.DataContainer;
import subway.view.InputView;
import subway.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final StationRepository stationRepository = new StationRepository();
    final StationService stationService = new StationService(stationRepository);
    final StationController stationController = new StationController(stationService, inputView,
        outputView);
    final LineRepository lineRepository = new LineRepository();
    final DataContainer dataContainer = new DataContainer(stationRepository, lineRepository);
    dataContainer.save();

    final LineService lineService = new LineService(lineRepository, stationRepository);
    final LineController lineController = new LineController(inputView, outputView, lineService);
    final SectionService sectionService = new SectionService(lineRepository, stationRepository);
    final SectionController sectionController = new SectionController(inputView, outputView,
        sectionService);

    final AppController appController = new AppController(inputView, outputView, stationController,
        lineController, sectionController, lineService);

    appController.run();
  }
}
