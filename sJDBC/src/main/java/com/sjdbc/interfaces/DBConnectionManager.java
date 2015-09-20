package com.sjdbc.interfaces;

import java.sql.Connection;

import com.sjdbc.configuration.DBConnectionConfiguration;

/**
 * Interfejs ktory beda implementowac klasy zestawiajace i zamykajace polaczenie JDBC z roznymi bazami danych
 * @author Marcin
 *
 */
public interface DBConnectionManager {
	/**
	 * Metoda będzie tworzyc nowe polaczenie lub zwracac juz istniejace jeżeli zostało wcześniej utworzone
	 * @param dbConnectionConfiguraton - obiekt konfiguracyjny z którego będą pobierane dane do połączenia z bazą
	 * @return Connection conn
	 */
	public Connection createConnection(DBConnectionConfiguration dbConnectionConfiguraton);
	
	/**
	 * Metoda będzie zamykała połączenie z bazą na podstawie parametru (obiektu Connection)
	 * @param conn
	 */
	public void closeConnection(Connection conn);

}
