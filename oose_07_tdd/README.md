# lab_05_tdd_sevens
## Setup
* Check the following links to understand how Snaps and Sevens work
  * [https://en.wikipedia.org/wiki/Snap_(card_game)](https://en.wikipedia.org/wiki/Snap_(card_game))
  * [https://www.wikihow.com/Play-Sevens-(Card-Game)](https://www.wikihow.com/Play-Sevens-(Card-Game))
  * [https://www.youtube.com/watch?v=oYH5-Or5ik0](https://www.youtube.com/watch?v=oYH5-Or5ik0)

## Overview
* You will firstly complete the snap card game. The user will match when the two cards have either the same suit or face card e.g. ten or ace.
* Secondly you will complete the sevens card game, see details of the game above.
* In both cases you will use test driven development.
  * Create the test first - test name - test<method name><scenario>
  * Run the test to fail
  * Commit the test with an appropriate commit message
  * Write the code so the test passes
  * Refactor
  * Commit your code with an appropriate commit message
  
## Task One - Snap Tests - 
* Please find a video walking through TDD and creating snap, [video](https://mediaspace.gla.ac.uk/media/TDD+Snap/1_qg0h32d6).
* Please write each test and commit your work and leave a comment with the method changed e.g. git commit -m "Completed isSnapWithSuit"
* Please write the code to pass the test and commit your work
  * ``testIsSnapSameSuitCheckSuit`` - Test if two cards of the same suit e.g. D3 and D4 will return true
  * ``testIsSnapSameRankCheckSuit`` - Test if two cards with the same face will return false e.g. C5 and H5
  * ``testIsSnapSameRankCheckRank`` - Test if two cards of the same face will return true. Note the last parameter snapSuitOn will be false
  * ``testIsSnapSameSuitCheckRank`` - Test if two cards of the same suit return false when sanpSuitOn is false
* The code needs to compile/build and no file or method names are changed.

## Task Two Sevens 
* A video explaining the sevens tests, see [link](https://uofglasgow.zoom.us/rec/share/WszGJGDM6LvE2t1J1uWdnu7XmP0pmq_vlEBxTqnVgzSAABV27DQgB1cXgcuO25ZF.HIOb1Ea89hGnx9Jp?startTime=1644252860000)
* A video to explain creating the first test [link](https://mediaspace.gla.ac.uk/media/TDD+Sevens+Java+First+Test/1_rak01lse)
* Each test is named as follows "test<method name><scenario>", so tests below are for the "playToHandAtTable" method.
* Please work through completing each test that has no code. All the tests are for the playToSevenHand function. Commit after the test has been completed and again after the code has been written to pass the test. Leave a comment for the commit.
  * ``testPlayToTablePlayASevenToEmpty`` - Can you play a seven to an empty hand. Test provide as an example you still need to write the code. 
  * ``testPlayToTablePlayASevenNotEmpty`` - Can you play a seven of hearts when the hand already has cards, this should return false 
  * ``testPlayToTablePlayASevenCheckCard`` - Play a seven of hearts to an empty hand, check the card has been played
* Rerun your tests to check the still work and try playing the game does it partially work

## Task Three Sevens 
* Please work through completing each test that has no code. All the tests are for the playToSevenHand function. Commit after the test has been completed and again after the code has been written to pass the test. Leave a comment for the commit.
  * ``testPlayToTablePlayASixWithASeven`` - Can play a six of heart when a seven of hearts is already in the hand 
  * ``testPlayToTablePlayAFiveWithNoSix`` - Can not play a five of hearts when only a seven of hearts has been played into the hand 
  * ``testPlayToTablePlayASixCheckCard`` - Play the actually six of hearts to the hand when there is a seven of hearts already played 
  * ``testPlayToTablePlayAnEightWithASeven`` - Can play the eight of hearts when only a seven of heart is already in the hand 
  * ``testPlayToTablePlayANineWithNoEight`` - Can not play the nine of hearts when only a seven of hearts has already been played into the hand 
  * ``testPlayToTablePlayAnEightCheckCard`` - Actually play the eight of hearts to a hand with only the seven of hearts, check the card has been played to the hand 
* Rerun your tests to check the still work and try playing the game does it partially work

## Task Four Sevens
* Please work through completing each test that has no code. All the tests are for the playToSevenHand function. Commit after the test has been completed and again after the code has been written to pass the test. Leave a comment for the commit.
  * ``testPlayerHasWonTrue`` - Set competitor to have won, set finishGame true and return true if they have no cards in their hand 
  * ``testPlayerHasWonFalse`` - Return false if they have cards in their hand 

## Task Five Sevens 
* Please work through completing each test that has no code. All the tests are for the playToSevenHand function. Commit after the test has been completed and again after the code has been written to pass the test. Leave a comment for the commit.
  * ``testDetermineWinner`` - Pass in a list of competitors each with a hand. Check the returned competitor is the one that had no cards in their hand 
* Clean and efficient code 
  * ``determineWinner`` - Make it efficient, assume there will only be one winner 
  * ``determineWinner`` - Clean code, don't repeat yourself 
* Try playing the game does it work

## Submit
* Before you commit your final solution, double check it can build and all the test you completed can run.
* Go to the following weeks section and open the assessment
* In text paste the https .git for the forked project and submit
