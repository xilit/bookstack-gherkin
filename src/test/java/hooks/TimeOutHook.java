package hooks;

import io.cucumber.java.AfterStep;

public class TimeOutHook {
    @AfterStep
    public void afterStep() throws InterruptedException {
        Thread.sleep(0); // пауза 2 секунды после каждого шага
    }
}