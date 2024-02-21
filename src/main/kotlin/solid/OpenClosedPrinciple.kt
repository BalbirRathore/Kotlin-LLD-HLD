package org.example.solid


// Open for extension and close for modification
// Violate open close principle
class InvoiceDao1{
    fun saveToDB(invoice: Invoice){
        /// Save into the DB
    }

    fun saveToFile(invoice: Invoice){
        //save into file
    }
}

// Following way we can apply open close principle

interface InvoiceDaoInterface {
    fun save(invoice: Invoice)
}
 class DatabaseInvoiceDao : InvoiceDaoInterface {
    override fun save(invoice: Invoice) {
        // save to DB
    }
}


class FileInvoiceDao : InvoiceDaoInterface {
    override fun save(invoice: Invoice) {
        // save to File
    }
}