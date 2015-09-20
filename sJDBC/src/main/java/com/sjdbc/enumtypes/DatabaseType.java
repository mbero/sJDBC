package com.sjdbc.enumtypes;

/**
 * Typ wyliczeniowy dzięki któremu użytkownik bibilioteki jest w stanie wybrać do jakiego typu bazy danych chce sie połączyc.
 * W przypadku obsługi kolejnych baz danych, dodawne będą nowe wartości dla tego typu.
 * @author Marcin Berendt
 *
 */
public enum DatabaseType 
{
	POSTGRESQL,
	MYSQL
}
