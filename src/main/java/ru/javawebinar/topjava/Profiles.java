package ru.javawebinar.topjava;

public class Profiles {
    public static final String
            JDBC = "jdbc",
            JPA = "jpa",
            DATAJPA = "datajpa",
            JDBC_MEAL_REPOSITORY_POSTGRES = "jdbcMealRepository_postgres",
            JDBC_MEAL_REPOSITORY_HSQLDB = "jdbcMealRepository_hsqldb";


    public static final String REPOSITORY_IMPLEMENTATION = JDBC_MEAL_REPOSITORY_HSQLDB;

    public static final String
            POSTGRES_DB = "postgres",
            HSQL_DB = "hsqldb";

    //  Get DB profile depending of DB driver in classpath
    public static String getActiveDbProfile() {
        try {
            Class.forName("org.postgresql.Driver");
            return POSTGRES_DB;
        } catch (ClassNotFoundException ex) {
            try {
                Class.forName("org.hsqldb.jdbcDriver");
                return Profiles.HSQL_DB;
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Could not find DB driver");
            }
        }
    }

    public static String getActiveRepositoryProfile() {
        return REPOSITORY_IMPLEMENTATION;
    }
}
