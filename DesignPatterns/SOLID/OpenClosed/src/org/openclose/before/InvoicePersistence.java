package org.openclose.before;

// This Program violates Open Closed Principle
// Now if we have to introduce a new persistence Type like CockroachDB
// Then we need modify the existing code(conditional block in save method, and new methode to CockroachDB)
// which violates Open-Closed Principle

// One Possible Solution could be
// We change the type of InvoicePersistence to Interface and add a save method.
// Each persistence class will implement this save method
public class InvoicePersistence {

    private final Invoice invoice;

    public InvoicePersistence(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save(String persistenceType){
        if("File".equals(persistenceType)){
            saveToFile();
        }
        else if("OracleDB".equals(persistenceType)){
            saveToOracleDB();
        }
        else if("Cassandra".equals(persistenceType)){
            saveToCassandra();
        }
    }

    private void saveToCassandra() {

    }

    private void saveToFile() {

    }

    private void saveToOracleDB() {

    }
}
