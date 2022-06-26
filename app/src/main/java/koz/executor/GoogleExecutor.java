package koz.executor;

import java.io.IOException;

import koz.googlesr.Google;
import koz.googlesr.IFastAnswer;
import koz.googlesr.ResultOfSearch;
import koz.googlesr.fa.FactAnswerNotFoundException;
import koz.googlesr.fa.FactAnswerNotSupportedException;
import koz.googlesr.fa.FactAnswerUnknownException;

public class GoogleExecutor implements IExecutor {
    private final Google searcher;
    private final GoogleDisplay display;
    private DisplaySelector<ResultOfSearch> displaySelector;

    public GoogleExecutor(GoogleDisplay display) {
        this.searcher = new Google();
        this.display = display;
    }

    @Override
    public void execute(Command command, Object... args) throws NoArgumentsException, ClassCastException, CommandNotSupportsException {
        switch (command) {
            case SEARCH: {
                checkValue(args.length > 0);

                String arg = (String) args[0];
                search(arg);
                break;
            }
            case FAST_ANSWER: {
                checkValue(args.length > 0);

                String arg = (String) args[0];
                fastAnswer(arg);
                break;
            }
            case NEXT: {
                next();
                break;
            }
            case BACK: {
                back();
                break;
            }
            case HOME: {
                home();
                break;
            }
            case SELECT: {
                if (args.length > 0) {
                    int index = (int) args[0];
                    select(index);
                }
                else select();

                break;
            }
            default: {
                throw new CommandNotSupportsException(command, this);
            }
        }
    }
    private void checkValue(boolean value) throws NoArgumentsException {
        if (!value) throw new NoArgumentsException();
    }

    public void search(String question) {
        try {
            ResultOfSearch[] results = searcher.search(question);
            displaySelector = new DisplaySelector<>(results, display::displayResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fastAnswer(String question) {
        try {
            IFastAnswer answer = searcher.factAnswer(question);
            display.displayFastAnswer(answer);
        } catch (IOException | FactAnswerNotSupportedException | FactAnswerNotFoundException | FactAnswerUnknownException e) {
            display.displayException(e);
        }
    }

    public void next() {
        displaySelector.next();
    }
    public void back() {
        displaySelector.back();
    }
    public void home() {
        displaySelector.home();
    }
    public void select() {
        ResultOfSearch result = displaySelector.get();
        display.displayTextOfResult(result);
    }
    public void select(int index) {
        ResultOfSearch result = displaySelector.setIndex(index);
        display.displayTextOfResult(result);
    }
}
