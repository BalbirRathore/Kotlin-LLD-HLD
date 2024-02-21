package org.example.solid


// Open for extension and close for modification
// Violate open close principle
data class InvoiceDao1(val invoice: Invoice){
    fun saveToDB(){
        /// Save into the DB
    }

    fun saveToFile(){
        //save into file
    }
}

// Following way we can apply open close principle

interface InvoiceDaoInterface {
    fun save(invoice: Invoice)
}

data class DatabaseInvoiceDao(val invoice: Invoice) : InvoiceDaoInterface {
    override fun save(invoice: Invoice) {
        // save to DB
    }
}


data class FileInvoiceDao(val invoice: Invoice) : InvoiceDaoInterface {
    override fun save(invoice: Invoice) {
        // save to File
    }
}