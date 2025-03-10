package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResDataIndex;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResDataIndexSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResDataIndex records into the database in bulk.
     * 
     * @param resDataIndex - List of ResDataIndex objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResDataIndex> resDataIndex, Connection connection) throws SQLException, IOException {
 
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResDataIndex.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResDataIndex data to the batch for bulk insertion
        for (ResDataIndex dataIndex : resDataIndex) {
            stmt.setString(1, dataIndex.getID());
            stmt.setShort(2, dataIndex.getNameAssociationID());
            stmt.setString(3, dataIndex.getProfileType());
            stmt.setString(4, dataIndex.getProfileValue());
            stmt.setString(5, dataIndex.getSourceSystemId());
            stmt.setDate(6, dataIndex.getRecordUpdateDate());
            stmt.setTime(7, dataIndex.getRecordUpdateTime());
            stmt.setShort(8, dataIndex.getIntraPNRSetNbr());
            stmt.setShort(9, dataIndex.getCDISeqNbr());
            stmt.setString(10, dataIndex.getResActivityCode());
            stmt.addBatch();
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
