# oose_09_mocking
## Setup
* See if not done from the last lab [https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/setup](https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/setup)
* Make sure you have invited the tutor group.


## Overview
* The lab will look at doubling using Mockito mock/spy. Please refer to the Doubling lecture on Doubling and Mocking. 
* Please find a video overview of what you need to know from the Doubling and Mocking lecture for the lab [https://uofglasgow.zoom.us/rec/share/1NIWYa_H9epBHLeke9MRufES4EbjqoFZjtC2mTOdAqMmXo-GoT1rRK8tCu7cl0iY.meiKTntbwgPGAW3J?startTime=1644504493000](https://uofglasgow.zoom.us/rec/share/1NIWYa_H9epBHLeke9MRufES4EbjqoFZjtC2mTOdAqMmXo-GoT1rRK8tCu7cl0iY.meiKTntbwgPGAW3J?startTime=1644504493000). Please see slides [https://gla.sharepoint.com/:f:/s/COMPSCI2008OBJECT-ORIENTEDSOFTWAREENGINEERING22/EqkJHUJO_1dOssa-Au6gvNUBl4iSNeniTN5QeLV1wL0xYw?e=Hr7IlR](https://gla.sharepoint.com/:f:/s/COMPSCI2008OBJECT-ORIENTEDSOFTWAREENGINEERING22/EqkJHUJO_1dOssa-Au6gvNUBl4iSNeniTN5QeLV1wL0xYw?e=Hr7IlR).
* Please pair programme, see [video](https://uofglasgow.zoom.us/rec/share/XIZHQPqGLUBvHPHfANcSgkBCS3m6i7rVHFWN9F80qqPK2E5gnX8jA2VWmGZLxrA.Dhr39Oam-BH9tdcZ?startTime=1644508665000) and [wiki](https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Pair-Programming) and register on the [form](https://forms.office.com/Pages/ResponsePage.aspx?id=KVxybjp2UE-B8i4lTwEzyELpM2ZClsRNrJBn7A_b41VUMDdGOEY2QjhQVlVHNTJETUM2RlhGQk0yMS4u)

## Already Done
* Please review the mocks that already exist in CardGameTest plus the lecture slides for Doubling and Mocking.
* You have also had a worked example for mocking please see [https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingrockpaperscissor](https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingrockpaperscissor)

## CardGame Tests
* Aim to mock or spy at the earliest point so mock Scanner rather than getString to maximise the code tested. If you mock external libraries you test more of your code.
* If you are testing a class, client class, that calls another class, calling class. Check if there is a setter in the client class for the calling class. You can then mock the calling class and set it into the client class. Example CounsoleInput is the client class and Scanner is the class called. ConsoleInput has a setter setUserInput to setup or change the called class Scanner. You can then change ConsoleInput to use the mock of Scanner.
* Create a test for getComputerPlayersNames, create a mock for LoadConfig, CardGame.loadConfig is protected.
  * Moderate - Test name getComputerPlayersNames you can get a list of at least three names. Use different names to the playersNames.cfg. 
* Create two tests for createComputerPlayers, see above mocking
  * Easy after previous - Test name createComputerPlayers for a list of three names and check the name of the third computer player is correct
  * Easy - Test name createComputerPlayersSize to see three players have been created. Not you pass four as the noOfPlayers to create three players, it assumes a human player is created.
* Create a test for createHumanPlayer
  * Easy - Test name createHumanPlayer, check the name of the human player
* Create a test for initiatePlayers
  * Easy - Test name initiatePlayers, check the number of players created
* Create a test for initiate
  * Easy - Test name initiate, check at least one player has been dealt cards
* Create a test for play
  * Moderate - Test name play, think about the play while condition, try to run the game end to end

## BlackJack
* Create a test for "play", so an end to end test
  * Advanced - Test name is "play", check if the game has finished

## LoadConfig
* Create a test for populatePropertyData
  * Moderate - Test name populatePropertyData, check you can get at least two line mocked
* Create a test for getConfig
  * Easy with above test logic - Test name getConfig, same as above

## Submit
* Before you commit your final solution, double check it can build and all the test you completed can run.
