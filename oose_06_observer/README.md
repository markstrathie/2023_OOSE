## Setup
* see [https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Git/Project_Setup](https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Git/Project_Setup)
* Clone your copy using gitbash
* Open using existing files in your IDE

## Overview
* The three files have the starting point for you to implement a solution: 
  * ``Race.java`` 
  * ``RaceWeather.java``
  * ``RaceCar.java``
* You clean code and easy your solution to maintain will be graded. This is a link to a style guide that will be used [https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Style_Guide](https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Style_Guide)

## Task One
* Create an ``Observer`` interface with an ``update`` method to change the ``WeatherType`` 
* Amend the ``RaceCar`` to implement the ``Observer`` interface 

## Task Two
* Create a ``Subject`` interface class with a ``registerObserver``, ``removeObserver`` and ``notifyObsever`` 
* Amend ``RaceWeather`` to use the Subject interface and implment ``registerObserver``, ``removeObserver`` and ``notifyObsever``
* Amend the ``RaceCar`` to register with the RaceWeather

## Task Three
* Create a ``FastDriving`` behaviour as a subclass of Behaviour 
  * ``DRY`` - 20
  * ``MISTY`` - 5
  * ``WET`` - 8
* Create a ``CautiousDriving`` behaviour as a subclass of Behaviour 
  * ``DRY`` - 12
  * ``MISTY`` - 10
  * ``WET`` - 10

## Task Four
* Amend ``Race`` class to have a ``makeFourCars`` method to create four cars 
* Amend ``Race`` class to have the main call ``makeFourCars`` and race the cars 
  * Car One - Cautious
  * Car Two - Fast
  * Car Three - Cautious
  * Car Four - Fast

## Task Five - Wheels
* Create a ``ThickWheel`` class to subclass from Behaviour
  * ``DRY`` - "-2"
  * ``MISTY`` - "0"
  * ``WET`` - "+2"
* Create a ``ThinWheel`` class to subclass from Behaviour
  * ``DRY`` - "+2"
  * ``MISTY`` - "0"
  * ``WET`` - "-2"
* Amend ``RaceCar`` to have a ``setWheel``, don't change the constructor
* Amend ``RaceCar`` ``driveCar`` to take account of the wheels used
* Amend ``Race`` to use wheels and play the race
