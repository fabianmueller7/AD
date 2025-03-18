/*
 * Copyright 2025 Hochschule Luzern - Informatik.
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
package e5.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bankauftrag, der der von einem Quell-Bankkonto einen Betrag an ein Ziel-Bankkonto überweist. Die
 * Überweisung wird in Mircoüberweisungen aufgeteilt.
 */
public final class AccountTask implements Runnable {

    private final BankAccount source;
    private final BankAccount target;
    private final int amount;
    private static final Logger LOG = LoggerFactory.getLogger(AccountTask.class);

    /**
     * Erzeugt ein Bankauftrag für eine Überweisung von einem Bankkonto auf ein anderes Bankkonto.
     * @param source Quell-Bankkonto
     * @param target Ziel-Bankkonto
     * @param amount zu überweisender Betrag
     */
    public AccountTask(final BankAccount source, final BankAccount target, final int amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int n = 0; n < amount; n++) {
            try {
                source.transfer(target, 1);
            } catch (InterruptedException e) {
                LOG.warn(e.getMessage());
            }
        }
    }

}
