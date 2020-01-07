package com.example.bidpro

object DataManager {

    var flights = ArrayList<FlightData>()
    var flights2 = ArrayList<FlightData>()
    var flights3 = ArrayList<FlightData>()

    var pilots = ArrayList<PilotData>()
    var pilots2 = ArrayList<PilotData>()
    var pilots3 = ArrayList<PilotData>()

    init {
        initializeAmerican()
        initializeAlaskan()
        initializeFrontier()
        initializeAmericanPilots()
        initializeAlaskanPilots()
        initializeFrontierPilots()
    }

    private fun initializeAmericanPilots() {
        var pilot = PilotData( "D'Glester", "Hardunkichud" )
        pilots.add(pilot)
        pilot = PilotData( "Alice", "Wonderland" )
        pilots.add(pilot)
        pilot = PilotData( "Chuck", "Mahoney" )
        pilots.add(pilot)
        pilot = PilotData( "Roger", "Smith" )
        pilots.add(pilot)
        pilot = PilotData( "Grover", "Drucker" )
        pilots.add(pilot)
        pilot = PilotData( "Josh", "Jacobs" )
        pilots.add(pilot)
        pilot = PilotData( "Clelin", "Ferrell" )
        pilots.add(pilot)

    }

    private fun initializeAlaskanPilots() {
        var pilot = PilotData( "Mike", "Stanton" )
        pilots2.add(pilot)
        pilot = PilotData( "Suzie", "Cue" )
        pilots2.add(pilot)
        pilot = PilotData( "Nick", "Elbag" )
        pilots2.add(pilot)
        pilot = PilotData( "Stan", "Lee" )
        pilots2.add(pilot)
    }

    private fun initializeFrontierPilots() {
        var pilot = PilotData( "Harvey", "Moon" )
        pilots3.add(pilot)
        pilot = PilotData( "Mitch", "Conner" )
        pilots3.add(pilot)
        pilot = PilotData( "Hannah", "Flanders" )
        pilots3.add(pilot)
        pilot = PilotData( "Francine", "Smith" )
        pilots3.add(pilot)
        pilot = PilotData( "Bruce", "Hixon" )
        pilots3.add(pilot)
    }



    private fun initializeAmerican() {
        var flight = FlightData("1", "CPT", "747", "ANC", "CURRENT")
        flights.add(flight)

        flight = FlightData("2", "CPT", "757", "ANC", "CURRENT")
        flights.add(flight)

        flight = FlightData("3", "FO", "73G", "ONT", "IMPORTING")
        flights.add(flight)

        flight = FlightData("4", "FO", "757", "ONT", "CURRENT")
        flights.add(flight)

    }

    private fun initializeAlaskan() {
        var flight = FlightData("5", "CPT", "A300", "SEA", "CURRENT")
        flights2.add(flight)

        flight = FlightData("6", "FO", "A300", "SEA", "CURRENT")
        flights2.add(flight)

        flight = FlightData("7", "CPT", "777", "SEA", "IMPORTING")
        flights2.add(flight)

    }

    private fun initializeFrontier() {
        var flight = FlightData("8", "CPT", "73G", "DEN", "CURRENT")
        flights3.add(flight)

        flight = FlightData("9", "FO", "73G", "DEN", "IMPORTING")
        flights3.add(flight)

    }

}
