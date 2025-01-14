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
package org.jooq.impl;

import static org.jooq.impl.DSL.inline;
import static org.jooq.impl.DSL.not;

import org.jooq.Condition;
import org.jooq.Configuration;
import org.jooq.QueryPart;

/**
 * @author Lukas Eder
 */
class ConditionAsField extends AbstractFunction<Boolean> {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = -5921673852489483721L;
    private final Condition   condition;

    ConditionAsField(Condition condition) {
        super(condition.toString(), SQLDataType.BOOLEAN);

        this.condition = condition;
    }

    @Override
    final QueryPart getFunction0(Configuration configuration) {
        switch (configuration.family()) {

            // Some databases don't accept predicates where column expressions
            // are expected.
            /* [pro] xx
            xxxx xxxx
            xxxx xxxxx
            xxxx xxxxxxx
            xxxx xxxxxxx
            xxxx xxxxxxxxxx
            xxxx xxxxxxx
            xx [/pro] */
            case CUBRID:
            case FIREBIRD:

                // [#3206] Correct implementation of three-valued logic is important here
                return DSL.when(condition, inline(true))
                          .when(not(condition), inline(false))
                          .otherwise(inline((Boolean) null));

            // These databases can inline predicates in column expression contexts
            case DERBY:
            case H2:
            case HSQLDB:
            case MARIADB:
            case MYSQL:
            case POSTGRES:
            case SQLITE:

            /* [pro] xx
            xx xxxxxxx xxx xx xxxxxxxxxxx
            xxxx xxxx
            xx [/pro] */
                return condition;
        }

        // The default, for new dialects
        return condition;
    }
}
