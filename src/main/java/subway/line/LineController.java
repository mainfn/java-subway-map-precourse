package subway.line;

import java.util.List;
import subway.FeatureKind;
import subway.view.InputView;
import subway.view.OutputView;

public final class LineController {

  private final InputView inputView;
  private final OutputView outputView;
  private final LineService lineService;

  public LineController(
      final InputView inputView,
      final OutputView outputView,
      final LineService lineService
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lineService = lineService;
  }

  public void selectFeature() {
    final LineFeature feature = inputView.inputLineFeature();
    if (LineFeature.CREATE_LINE.equals(feature)) {
      addLine();
    }
    if (LineFeature.REMOVE_LINE.equals(feature)) {
      removeLine();
    }
    if (LineFeature.QUERY_LINE.equals(feature)) {
      queryLine();
    }
  }

  private void addLine() {
    final CreateLine createLine = inputView.inputCreateLine();
    lineService.addLine(createLine);
    outputView.printCreationMessage(FeatureKind.LINE_FEATURE);
  }

  private void removeLine() {
    final String lineName = inputView.inputNameForDeletion(FeatureKind.LINE_FEATURE);
    lineService.deleteLine(lineName);
    outputView.printDeletionMessage(FeatureKind.LINE_FEATURE);
  }

  private void queryLine() {
    final List<Line> lines = lineService.findAllLines();
    outputView.printList(FeatureKind.LINE_FEATURE, lines);
  }
}
