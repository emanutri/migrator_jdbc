package it.prova.migratorjdbc.dao;

public interface IConstants {
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String CONNECTION_URL_NEW = "jdbc:mysql://localhost:3306/schemanew?user=root&password=root&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	public static final String CONNECTION_URL_OLD = "jdbc:mysql://localhost:3306/schemaold?user=root&password=root&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

}
