package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MethodInterface {

	void insert(List<Object> flights, Connection connection) throws SQLException, IOException;

	String delete(List<Object> flights, Connection connection) throws SQLException, IOException;

}
