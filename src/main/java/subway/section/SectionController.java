package subway.section;

import subway.FeatureKind;
import subway.view.InputView;
import subway.view.OutputView;

public final class SectionController {

  private final InputView inputView;
  private final OutputView outputView;
  private final SectionService sectionService;

  public SectionController(
      final InputView inputView,
      final OutputView outputView,
      final SectionService sectionService
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.sectionService = sectionService;
  }

  public void selectFeature() {
    final SectionFeature feature = inputView.inputSectionFeature();

    if (SectionFeature.CREATE_SECTION.equals(feature)) {
      final CreateSection createSection = inputView.inputCreateSection();
      sectionService.addSection(createSection);
      outputView.printCreationMessage(FeatureKind.SECTION_FEATURE);
    }

    if (SectionFeature.REMOVE_SECTION.equals(feature)) {
      final DeleteSection deleteSection = inputView.inputDeletionSection();
      sectionService.deleteSection(deleteSection);
      outputView.printDeletionMessage(FeatureKind.SECTION_FEATURE);
    }
  }

  private void createSection() {
    final CreateSection createSection = inputView.inputCreateSection();
    sectionService.addSection(createSection);
  }

  private void deleteSection() {
    final DeleteSection deleteSection = inputView.inputDeletionSection();
    sectionService.deleteSection(deleteSection);
  }
}
