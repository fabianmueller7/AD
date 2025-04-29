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
package e10.n4.quicksort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 5;
    /**
     * Zu sortierendes Array.
     */
    private final int[] array;
    /**
     * Unterer Array-Index des Sortierbereichs.
     */
    private final int min;
    /**
     * Oberer Array-Index des Sortierbereichs.
     */
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }
    private void merge(final int min, final int mid, final int max) {
        int[] buf = Arrays.copyOfRange(array, min, mid);  // linke Hälfte
        int i = 0;   // Index in buf
        int j = min; // Zielindex im originalen array
        int k = mid; // Index in rechter Hälfte

        // Vergleichen und zurückschreiben
        while (i < buf.length && k < max) {
            if (buf[i] <= array[k]) {
                array[j++] = buf[i++];
            } else {
                array[j++] = array[k++];
            }
        }

        // Rest aus buf zurückkopieren
        while (i < buf.length) {
            array[j++] = buf[i++];
        }

        // Kein Rest aus rechter Hälfte nötig – ist schon an Ort und Stelle
    }


    @Override
    protected void compute() {
        if( max - min < THRESHOLD ) {
            QuicksortRecursive.quicksort(array, min, max);
        } else {
            int mid = min + (max - min) / 2;
            invokeAll(
                    new QuicksortTask(array, min, mid),
                    new QuicksortTask(array, mid + 1, max));
            System.out.println(Arrays.toString(array));
            merge(min,mid,max);
            System.out.println(Arrays.toString(array));
        }
    }
}
