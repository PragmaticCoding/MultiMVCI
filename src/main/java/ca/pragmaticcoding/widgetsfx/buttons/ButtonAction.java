package ca.pragmaticcoding.widgetsfx.buttons;

import javafx.concurrent.Task;

import java.util.function.Consumer;

/**
 * Utility class to simplify creation of background actions to
 * support Action type screen elements like Buttons.  Ideally,
 * the ButtonAction would be defined in the Controller and passed
 * to the ViewBuilder through its constructor.
 * <p>
 * The view would call this Consumer inside the onAction event
 * handler for a Button.  Any pre-action GUI actions would happen
 * first, then the accept() method would be called, passing a
 * Runnable containing the post action GUI events.
 * <p>
 * For instance, the Button's event handler might disable the Button
 * to prevent subsequent triggering of the handler while the
 * background task was running, then create a Runnable which enables
 * the Button and pass it to the accept() method of the ButtonAction.
 */

public class ButtonAction implements Consumer<Runnable> {

    private final Runnable backgroundJob;
    private Runnable postNonGuiAction = () -> {
    };

    /**
     * Constructor to create a background job only.
     *
     * @param backgroundJob Runnable to execute in a background task
     */

    public ButtonAction(Runnable backgroundJob) {
        this.backgroundJob = backgroundJob;
    }

    /**
     * Constructor to create both a background job, and a job to run on
     * the FXAT but outside the layout code after completion of the
     * background task.
     *
     * @param backgroundJob    Runnable to execute in a background task
     * @param postNonGuiAction Non-GUI related code to run on the FXAT
     */

    public ButtonAction(Runnable backgroundJob, Runnable postNonGuiAction) {
        this.backgroundJob = backgroundJob;
        this.postNonGuiAction = postNonGuiAction;
    }

    /**
     * Executes background and FXAT Runnables, then executes the
     * Runnable passed here on the FXAT.
     *
     * @param postGuiAction Runnable to execute after completion of the
     *                      background task.
     */

    @Override
    public void accept(Runnable postGuiAction) {
        Task<Void> backgroundTask = new Task<>() {
            @Override
            protected Void call() {
                backgroundJob.run();
                return null;
            }
        };
        backgroundTask.setOnSucceeded(evt -> {
            postNonGuiAction.run();
            postGuiAction.run();
        });
        Thread backgroundThread = new Thread(backgroundTask);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

}
