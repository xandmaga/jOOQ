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

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.function;

import org.jooq.Configuration;
import org.jooq.Field;

/**
 * @author Lukas Eder
 */
class CurrentUser extends AbstractFunction<String> {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = -7273879239726265322L;

    CurrentUser() {
        super("current_user", SQLDataType.VARCHAR);
    }

    @Override
    final Field<String> getFunction0(Configuration configuration) {
        switch (configuration.family()) {
            /* [pro] xx
            xxxx xxxxxxx
                xxxxxx xxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx

            xxxx xxxx
            xxxx xxxxxxxxx
            xxxx xxxxxxx
                xxxxxx xxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx

            xxxx xxxx
            xxxx xxxxx
            xxxx xxxxxxx
            xxxx xxxxxxxxx
            xxxx xxxxxxxxxx
            xxxx xxxxxxx
            xx [/pro] */
            case DERBY:
            case FIREBIRD:
            case HSQLDB:
            case POSTGRES:
            case SQLITE:
                return field("{current_user}", String.class);
        }

        return function("current_user", SQLDataType.VARCHAR);
    }
}
