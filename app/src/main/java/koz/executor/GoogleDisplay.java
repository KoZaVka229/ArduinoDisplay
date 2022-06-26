package koz.executor;

import koz.googlesr.IFastAnswer;
import koz.googlesr.ResultOfSearch;

public class GoogleDisplay {
    private final IDisplay<ResultOfSearch> selectedResultOfSearchDisplay;
    private final IDisplay<ResultOfSearch> selectorResultOfSearchDisplay;
    private final IDisplay<IFastAnswer> fastAnswerDisplay;
    private final IDisplay<Exception> exceptionDisplay;

    public GoogleDisplay(IDisplay<ResultOfSearch> selectedResultOfSearchDisplay,
                         IDisplay<ResultOfSearch> selectorResultOfSearchDisplay,
                         IDisplay<IFastAnswer> fastAnswerDisplay,
                         IDisplay<Exception> exceptionDisplay) {
        this.selectedResultOfSearchDisplay = selectedResultOfSearchDisplay;
        this.selectorResultOfSearchDisplay = selectorResultOfSearchDisplay;
        this.fastAnswerDisplay = fastAnswerDisplay;
        this.exceptionDisplay = exceptionDisplay;
    }

    public void displayTextOfResult(ResultOfSearch selectedResult) {
        selectedResultOfSearchDisplay.display(selectedResult);
    }
    public void displayResult(ResultOfSearch result) {
        selectorResultOfSearchDisplay.display(result);
    }
    public void displayFastAnswer(IFastAnswer answer) {
        fastAnswerDisplay.display(answer);
    }
    public void displayException(Exception e) {
        exceptionDisplay.display(e);
    }
}
