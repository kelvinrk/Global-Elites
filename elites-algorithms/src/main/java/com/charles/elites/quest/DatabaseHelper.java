package com.charles.elites.quest;

public class DatabaseHelper {
    public interface Connection {
        void execute(String query) throws Exception;
        void commit();
        void rollback();
        void close();
    }

    public static void ExecuteQuery(Connection conn, String query) {
        try {
            conn.execute(query);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    public static void main(String[] args) {
        ConnectionImplementation conn = new ConnectionImplementation();
        ExecuteQuery(conn, "SELECT * FROM Users;");
    }
}

class ConnectionImplementation implements DatabaseHelper.Connection {

    public void execute(String query) {
        System.out.println("executed: " + query);
    }

    public void commit() {
        System.out.println("commit");
    }

    public void rollback() {
        System.out.println("rollback");
    }

    public void close() {
        System.out.println("close");
    }
}
