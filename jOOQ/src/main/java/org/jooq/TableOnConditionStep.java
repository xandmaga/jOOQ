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

import org.jooq.impl.DSL;


/**
 * An intermediate (optional) type for the construction of a <code>JOIN</code>
 * clause, where the join criteria is added using an <code>ON</code> clause
 * (with a {@link Condition}. This type can be used as a convenience type for
 * connecting more conditions.
 *
 * @author Lukas Eder
 */
public interface TableOnConditionStep extends Table<Record> {

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep and(Condition condition);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep and(Field<Boolean> condition);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep and(Boolean condition);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#AND} operator.
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String)
     * @see SQL
     */
    @Support
    @PlainSQL
    TableOnConditionStep and(String sql);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#AND} operator.
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, Object...)
     * @see SQL
     */
    @Support
    @PlainSQL
    TableOnConditionStep and(String sql, Object... bindings);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#AND} operator.
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, QueryPart...)
     * @see SQL
     */
    @Support
    @PlainSQL
    TableOnConditionStep and(String sql, QueryPart... parts);

    /**
     * Combine the currently assembled conditions with a negated other one using
     * the {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep andNot(Condition condition);

    /**
     * Combine the currently assembled conditions with a negated other one using
     * the {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep andNot(Field<Boolean> condition);

    /**
     * Combine the currently assembled conditions with a negated other one using
     * the {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep andNot(Boolean condition);

    /**
     * Combine the currently assembled conditions with an <code>EXISTS</code>
     * clause using the {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep andExists(Select<?> select);

    /**
     * Combine the currently assembled conditions with a <code>NOT EXISTS</code>
     * clause using the {@link Operator#AND} operator.
     */
    @Support
    TableOnConditionStep andNotExists(Select<?> select);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep or(Condition condition);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep or(Field<Boolean> condition);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep or(Boolean condition);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#OR} operator.
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String)
     * @see SQL
     */
    @Support
    @PlainSQL
    TableOnConditionStep or(String sql);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#OR} operator.
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, Object...)
     * @see SQL
     */
    @Support
    @PlainSQL
    TableOnConditionStep or(String sql, Object... bindings);

    /**
     * Combine the currently assembled conditions with another one using the
     * {@link Operator#OR} operator.
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, QueryPart...)
     * @see SQL
     */
    @Support
    @PlainSQL
    TableOnConditionStep or(String sql, QueryPart... parts);

    /**
     * Combine the currently assembled conditions with a negated other one using
     * the {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep orNot(Condition condition);

    /**
     * Combine the currently assembled conditions with a negated other one using
     * the {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep orNot(Field<Boolean> condition);

    /**
     * Combine the currently assembled conditions with a negated other one using
     * the {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep orNot(Boolean condition);

    /**
     * Combine the currently assembled conditions with an <code>EXISTS</code>
     * clause using the {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep orExists(Select<?> select);

    /**
     * Combine the currently assembled conditions with a <code>NOT EXISTS</code>
     * clause using the {@link Operator#OR} operator.
     */
    @Support
    TableOnConditionStep orNotExists(Select<?> select);
}
