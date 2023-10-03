# oose_04_strategy

Hint: Look at [Head First Design Patterns](https://legacy.cs.indiana.edu/classes/c212-dgerman/spr2015/griffin/a.pdf) chapter one to see what working strategy pattern code looks like - the solution here is similar but not identical!

In this lab you will demonstrate that you can understand the coding involved in developing the strategy pattern in several small steps.

You should not alter given class names, method signatures, or access modifiers to solve this problem but you will need to add some.

## Project Description

You will develop a system for managing vehicles that allows you to switch out their maintenance and travel behaviours. I'm giving an overview here of how the system will work and then we will go step-by-step into what you’ll need to do with your starter code.

Vehicle.java is an abstract class with data stored in it about the vehicle. There are two concrete implementations of the Vehicle class:
- ```Car```.java: this vehicle has a max speed of 70mph
- ```Bike```.java: max speed 15mph 

Travel Behaviours\
Calculates how far the vehicle has travelled based on the vehicles max speed (in miles per hour), the type of travel behaviour, and hours travelled and returns the value as a double. (Hint: You should increment the distanceSinceLastService for the vehicle as well here) 
- ```NoTravel```.java: Returns distance as 0 (already implemented)
- ```SlowTravel```.java: Returns distance as 0.5 times the vehicle's max speed times the hours travelled
- ```FastTravel```.java: Returns distance travelled as the vehicle's max speed times the hours travelled

Maintenance behaviours\
Calculate the cost to maintain the vehicle based on the distance travelled since the last service and the maintenance behaviour. The method will change the distanceSinceLastService to 0 and calculate a maintenanceBill value for the last maintenance work on them (note this value should be overriden when the maintenance behaviour is called again with the new value).
- ```NoMaintenance```.java: Doesn't do anything except print out that no maintenance is possible (Already Implemented) 
- ```EasyMaintenance```.java: Updates the vehicles maintenanceBill to be 0.005 times the distance since last service
- ```HardMaintenance```.java: Updates the vehicles maintenanceBill to be 0.1 times the distance since last service


### Step 1: Get the abstract Vehicle and Car and Bike working
- ```Vehicle```.java: constructor, travel and maintain need to be fixed in Vehicle.java
- ```Bike```.java: Get the constructor working (Hint: you'll need to look at the class declaration as well - something is missing!) 
- ```Car```.java: Make the constructor/class declaration work 

At this stage you should be able to create a car or bike object using the provided NoTravel and NoMaintenance behaviours.


### Step 2: Add in travel behaviours

- Implement the slow travel behaviour
- Implement the fast travel behaviour - you have less guidance on the structure here so refer back to slow travel to get a sense of it

### Step 3: Add in maintain behaviours

- Implement the easy maintenance behaviour first as it has more clues about the structure of your solution
- Implement hard maintenance next following the rules given in the description above.

At this stage you should be able to test that you can create new bikes and cars with the different move and maintain behaviours and change those behaviours dynamically.

### Step 4: Add in car specific behaviour change
So far you might have noticed that there is no difference between a car and a bike - they both have the same functionality depending on what behaviours we create them with. We're going to change that here as we start to add in subclass specific functionality. We don't always need this to be related to the behaviours the subclasses have, but in these cases they will be.

-  Cars can take damage, making it harder for them to be maintained - when their take damage method is called, their maintenance behaviour should become hard

### Step 5: Add in bike specific behaviour change

In the final step, you'll need to add in a totally new maintain behaviour. 

- Bikes can be maintained for free if you learn home maintenance - implement the method given in Bike.java to change their behaviour here when it is called to a new HomeMaintenance behaviour. 
Hint - you will need to add in another class to do this properly but don't worry about its specific name - we will test this implementation by calling methods in Bike.java and those inherited from Vehicle.java.  


### Submit
- Check that the correct teaching group has been [added with maintainer access](https://stgit.dcs.gla.ac.uk/software-engineering/git_get_started/-/wikis/home/Access-Control).
- Commit and push all your changes.
- Check that the [pipeline](https://stgit.dcs.gla.ac.uk/software-engineering/git_get_started/-/wikis/home/Pipelines) passes.
- Submit a link to your project on Moodle.
