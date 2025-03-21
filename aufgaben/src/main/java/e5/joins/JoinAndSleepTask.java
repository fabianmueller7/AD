/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package e5.joins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

/**
 * Parametrierbarer Task, der auf einen fremden Thread wartet und danach für
 * eine bestimmte Zeit schläft.
 */
public class JoinAndSleepTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleepTask.class);
    private final String taskName;
    private Thread joinFor;
    private final int sleepTime;

    /**
     * Erzeugt einen Task mit Namen.
     * 
     * @param taskName der Name des Tasks.
     * @param sleepTime die Zeit in mSec die der Task schläft.
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime, final Thread joinFor) {
        this.taskName = taskName;
        this.joinFor = joinFor;
        this.sleepTime = sleepTime;
    }

    /**
     * Hier wird auf das Ende des fremden Threads gewartet und danach für eine
     * bestimmte Zeit geschlafen. Beide Teile können unterbrochen werden.
     */
    @Override
    public void run() {
        LOG.info("Thead: " + this.taskName + "starting...");

        try {
            if (this.joinFor != null) {
                this.joinFor.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            int counter = 0;
            while (!Thread.currentThread().isInterrupted() && counter < sleepTime) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }

            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }

        } catch (InterruptedException e) {
            LOG.warn("Thread interrupted: " + this.taskName);
            LOG.warn(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            LOG.info("Thead: " + this.taskName + "finishing...");
        }
    }
}
