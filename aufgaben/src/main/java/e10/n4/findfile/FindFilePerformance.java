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
package e10.n4.findfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class FindFilePerformance {

    private static final Logger LOG = LoggerFactory.getLogger(FindFilePerformance.class);

    /**
     * Privater Konstruktor.
     */
    private FindFilePerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "find.me";

        final File rootDir = new File("/Users/muellefa/repos");
        LOG.info("Start searching '{}' recursive in '{}'", search, rootDir);

        long startRec = System.currentTimeMillis();
        FindFile.findFile(search, rootDir);
        long endRec = System.currentTimeMillis();
        LOG.info("Einfach Rekursiv in {} msec.", endRec - startRec);
        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);

        long startParallel = System.currentTimeMillis();
        final FindFileTask root = new FindFileTask(search, rootDir);
        long endParallel = System.currentTimeMillis();
        LOG.info(root.invoke());
        LOG.info("Found in {} msec.", endParallel - startParallel);
        LOG.info("Find '{}' concurrent in '{}'", search, root.getRawResult());
    }
}
