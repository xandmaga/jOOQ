/**
 * Copyright (c) 2009-2015, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package org.jooq;

import java.util.List;

/**
 * An object representing a database schema
 *
 * @author Lukas Eder
 */
public interface Schema extends QueryPart {

    /**
     * The name of this schema
     */
    String getName();

    /**
     * List all tables contained in this schema
     */
    List<Table<?>> getTables();

    /**
     * Get a table by its name (case-sensitive) in this schema, or
     * <code>null</code> if no such table exists
     */
    Table<?> getTable(String name);

    /**
     * List all UDTs contained in this schema
     */
    List<UDT<?>> getUDTs();

    /**
     * Get a UDT by its name (case-sensitive) in this schema, or
     * <code>null</code> if no such UDT exists
     */
    UDT<?> getUDT(String name);

    /**
     * List all sequences contained in this schema
     */
    List<Sequence<?>> getSequences();

    /**
     * Get a sequence by its name (case-sensitive) in this schema, or
     * <code>null</code> if no such sequence exists
     */
    Sequence<?> getSequence(String name);
}
