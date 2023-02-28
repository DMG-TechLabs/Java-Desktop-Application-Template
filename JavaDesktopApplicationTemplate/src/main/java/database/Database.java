
package database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kdesp73.madb.MADB;

public class Database {
        private static final String FILEPATH = null; //Add database path
        
        public static MADB db(){
                try {
                        return new MADB(FILEPATH);
                } catch (SQLException ex) {
                        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
        }
}
