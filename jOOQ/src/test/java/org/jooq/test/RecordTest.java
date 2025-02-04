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

package org.jooq.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jooq.Record1;
import org.jooq.test.data.Table1;
import org.jooq.test.data.Table1Record;
import org.jooq.test.data.Table2;
import org.jooq.test.data.Table2Record;
import org.jooq.test.data.Table4;
import org.jooq.test.data.Table4Record;

import org.junit.Test;


/**
 * A test suite for jOOQ functionality related to records
 *
 * @author Lukas Eder
 */
public class RecordTest extends AbstractTest {

    @Test
    public void testComparableRecords() throws Exception {
        Table1Record r1 = create.newRecord(Table1.TABLE1);
        Table2Record r2 = create.newRecord(Table2.TABLE2);
        Table4Record r4a = create.newRecord(Table4.TABLE4);
        Table4Record r4b = create.newRecord(Table4.TABLE4);

        // Incomparable (incompatible) records
        try {
            r1.compareTo(r4a);
            fail();
        }
        catch (ClassCastException expected) {}

        // Comparable records
        assertEquals(0, r1.compareTo(r2));
        assertEquals(0, r4a.compareTo(r4b));

        r2.setValue(Table2.FIELD_ID2, 1);
        assertEquals(1, r1.compareTo(r2));

        r2.setValue(Table2.FIELD_NAME2, "1");
        assertEquals(1, r1.compareTo(r2));

        r1.setValue(Table1.FIELD_ID1, 1);
        assertEquals(1, r1.compareTo(r2));

        r1.setValue(Table1.FIELD_NAME1, "1");
        assertEquals(0, r1.compareTo(r2));

        r2.setValue(Table2.FIELD_ID2, null);
        assertEquals(-1, r1.compareTo(r2));

        // Arrays
        r4b.setValue(Table4.FIELD_ARRAY4, new Object[] { 1 });
        assertEquals(1, r4a.compareTo(r4b));

        r4a.setValue(Table4.FIELD_ARRAY4, new Object[] {});
        assertEquals(-1, r4a.compareTo(r4b));

        r4a.setValue(Table4.FIELD_ARRAY4, new Object[] { 1 });
        assertEquals(0, r4a.compareTo(r4b));

        r4a.setValue(Table4.FIELD_ARRAY4, new Object[] { 1, 0 });
        assertEquals(1, r4a.compareTo(r4b));

        r4b.setValue(Table4.FIELD_ARRAY4, new Object[] { 1, 0 });
        assertEquals(0, r4a.compareTo(r4b));

        r4b.setValue(Table4.FIELD_ARRAY4, new Object[] { 1, 1 });
        assertEquals(-1, r4a.compareTo(r4b));
    }

    @Test
    public void testRecordInto() {
        Table1Record r1 = create.newRecord(Table1.TABLE1);
        r1.setValue(Table1.FIELD_ID1, 1);
        r1.setValue(Table1.FIELD_NAME1, "x");

        Record1<Integer> r2 = r1.into(Table1.FIELD_ID1);
        assertEquals(1, r2.size());
        assertEquals(Table1.FIELD_ID1, r2.field(0));
        assertEquals(1, (int) r2.value1());
        assertTrue(r2.changed());

        r1.changed(false);
        r2 = r1.into(Table1.FIELD_ID1);
        assertEquals(1, r2.size());
        assertEquals(Table1.FIELD_ID1, r2.field(0));
        assertEquals(1, (int) r2.value1());
        assertFalse(r2.changed());
    }
}
