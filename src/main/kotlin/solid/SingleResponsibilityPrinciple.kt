package org.example.solid

import javax.print.attribute.standard.PrintQuality

data class Marker(val name :String, val color :String, val price :Int)


// Voilate the single responsibility principle
data class Invoice1(val marker: Marker, val quality: Int){
    fun calculateTotal(): Int {
        val price  = ((marker.price)*quality)
        return price
    }

    fun saveToDB(){
        /// Save into the DB
    }

    fun printInvoice(){
        // print invoice
    }
}


// Following way we can apply single responsibility principle

data class Invoice(val marker: Marker, val quality: Int){
    fun calculateTotal(): Int {
        val price  = ((marker.price)*quality)
        return price
    }
}

data class InvoiceDao(val invoice: Invoice){
    fun saveToDB(){
        /// Save into the DB
    }
}

data class InvoicePrinter(val invoice: Invoice){

    fun printInvoice(){
        // print invoice
    }
}
