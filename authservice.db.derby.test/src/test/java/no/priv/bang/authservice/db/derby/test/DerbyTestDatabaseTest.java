/*
 * Copyright 2018 Steinar Bang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations
 * under the License.
 */
package no.priv.bang.authservice.db.derby.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.jupiter.api.Test;
import org.ops4j.pax.jdbc.derby.impl.DerbyDataSourceFactory;
import org.osgi.service.jdbc.DataSourceFactory;

import no.priv.bang.osgi.service.mocks.logservice.MockLogService;

class DerbyTestDatabaseTest {
    DataSourceFactory derbyDataSourceFactory = new DerbyDataSourceFactory();

    @Test
    void testCreate() throws Exception {
        MockLogService logservice = new MockLogService();
        DerbyTestDatabase database = new DerbyTestDatabase();
        database.setLogservice(logservice);
        database.setDataSourceFactory(derbyDataSourceFactory);
        database.activate();

        try(PreparedStatement statment = database.prepareStatement("select * from users")) {
            ResultSet results = statment.executeQuery();
            int usercount = 0;
            while(results.next()) {
                ++usercount;
            }

            assertEquals(1, usercount);
        }
    }

}