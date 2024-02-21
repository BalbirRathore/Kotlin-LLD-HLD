package org.example.solid


// Subclass should be replace to super class in all way
// Means subclass adhere all functionality of super class without breaking behaviour of the program
//

fun main() {
    //testWithoutLSPImplementation()
    testWithLSPImplementation()
}


private fun testWithoutLSPImplementation() {
    /// Without LSP
    val vehicleList1: MutableList<Vehicle1> = mutableListOf(Vehicle1())
    vehicleList1.add(Motorcyle1())
    vehicleList1.add(Car1())
    vehicleList1.add(Bicycle1())
    for (vehilcle in vehicleList1) {
        vehilcle.getNumberOfWheels()
        println(vehilcle.hasEngine()!!.equals(true)) // crash the application for Bicycle
    }
}

private fun testWithLSPImplementation() {
    /// WithLSP
    val vehicleList: MutableList<Vehicle> = mutableListOf(Vehicle())
    vehicleList.add(Motorcyle())
    vehicleList.add(Car())
    vehicleList.add(Bicycle())
    for (vehilcle in vehicleList) {
        println(vehilcle.getNumberOfWheels().toString())
        //println(vehilcle.hasEngine()!!.equals(true))  //  compile time error for hasEngine
    }

    val engineVehicleList: MutableList<EngineVehicle> = mutableListOf(EngineVehicle())
    engineVehicleList.add(Motorcyle())
    engineVehicleList.add(Car())
    // engineVehicleList.add(Bicycle()) /// compile time error while adding Bicycle
    for (engineVehicle in engineVehicleList) {
        println(engineVehicle.getNumberOfWheels().toString())
        println(engineVehicle.hasEngine().equals(true))
    }
}


// This design is violate LS Principle
open class Vehicle1 {
    open fun hasEngine(): Boolean? {
        return true
    }

    open fun getNumberOfWheels(): Int {
        return 2
    }
}

class Motorcyle1 : Vehicle1()

class Car1 : Vehicle1() {
    override fun getNumberOfWheels(): Int {
        return 4;
    }
}

class Bicycle1 : Vehicle1() {
    override fun hasEngine(): Boolean? {
        return null
    }
}


// Following way we can follow LS Principle

open class Vehicle {
    open fun getNumberOfWheels(): Int {
        return 2
    }
}

open class EngineVehicle : Vehicle() {
    fun hasEngine(): Boolean {
        return true
    }
}

class Motorcyle : EngineVehicle()

class Car : EngineVehicle() {
    override fun getNumberOfWheels(): Int {
        return 4;
    }
}

class Bicycle : Vehicle()

