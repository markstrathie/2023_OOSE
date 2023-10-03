# lab_03_monster_testing

## Background

You will work on a project to *test* an open world game that can be played via the command line in Java. You play as a trainer in the game who travels around fighting monsters with their own team of monsters catching more of them as you play.

## Provided

The ```MonsterTest``` class has been provided with a number of unit tests. Read over, try to understand and run the tests.

## To Do
### Task One - Fire Family Tests
Create a new file ```FireFamilyTest``` with class ```FireFamilyTest```
Create a class level ```fireFamily``` instance with a name, level of one, health of ten and max fire mana of ten\
Add the following tests:
- ```testGetMaxFireMana``` - create test, assert equals 10 and get max fire mana
- ```testGetFireMana``` - create test, assert equals 10 and get fire mana
- ```testLevelUpHealth``` - create the test, call the levelUp on the fireFamily, assertEquals 30 and fireFamily.getMaxHealth
- ```testLevelUpLevel``` - create the test, call the levelUp on the fireFamily, assertEquals 2 and fireFamily.getMonsterLevel
- ```testLevelUpFireMana``` - create the test, call the levelUp on the fireFamily, assertEquals 22 and fireFamily.getMaxFireMana
- ```testTakeDamage``` - create test, call the takeDamage on the fireFamily with a Damage of normal and amount 5. Assert equals 5 and the fireFamily.getCurrentHealth
- ```testSpecialAttackType``` - create test, assert equals FIRE and fireFamily.specialAttack
- ```testSpecialAttackLessFireMana``` - create test, assert equals 10 and fireFamily.specialAttack().getAmount()
- ```testSpecialAttackGreaterFireMana``` - create test, for the fire family setFireMana to 20, assert equals 15 and fireFamily.special_attack().getAmount()
- ```testBasicAttack``` - create test, assert equals 10 and fire family.basicAttack.getAmount()
- ```testRest``` - create test, fireFamily take damage of NORMAL and 5, the rest the fireFamily and assert equals 10 and the fireFamily.getCurrentHealth()
- ```testIsConsciousNoLonger``` - create a test when the fire family has suffered damage to have zero health and assert False to is conscious
### Task Two - Plant Family Tests
Create a new file ```PlantFamilyTest``` with class ```PlantFamilyTest```
Create a class level ```PlantFamily``` instance with a name, level of one, health of ten and max charges of one\
Add the following tests:
- ```testGetMaxCharges``` - create test, assert equals 1 and get max charges
- ```testGetCharges``` - create test, assert equals 1 and get charges
- ```testLevelUpHealth``` - create the test, call the level up on the plant family, assertEquals 10 and plant family get current health
- ```testLevelUpLevel``` - create the test, call the level up on the plant family, assertEquals 2 and plant family get monster level
- ```testLevelUpMaxCharges``` - create the test, call the level up on the plant family, assertEquals 2 and plant family get max charges
- ```testTakeDamagePlant``` - test the take damage for a plant
- ```testTakeDamageFire``` - test the take damage for a fire
- ```testTakeDamageNormal``` - test the take damage for a normal damage
- ```testSpecialAttackCharged``` - test the damage produced when the plant family is charged
- ```testSpecialAttackNotCharged``` - test the damage produced when the plant family is not charged
- ```testSpecialAttackType``` - test the special attack created Plant damage
- ```testBasicAttackType``` - test the basic attack created normal damage
- ```testRestCharge``` - test a rest will increment the charge
### Task Three - Scorchitile
Create a new file ```ScorchitileTest``` with class ```ScorchitileTest```\
Add the following tests:
- ```testGetName```
- ```testGetMonsterBreed```
- ```testGetMonsterLevel```
- ```testGetCurrentHealth```
- ```testGetMaxHealth```
- ```testBasicAttack```
### Task Four - Seedatops
Create a new file ```SeedatopsTest``` with class ```SeedatopsTest```\
Add the following tests:
- ```testGetName```
- ```testGetMonsterBreed```
- ```testGetMonsterLevel```
- ```testGetCurrentHealth```
- ```testGetMaxHealth```
- ```testBasicAttack```
- ```testTakeDamage```
- ```testTakeDamageAndBasicAttack``` - The Seedatops should take damage and perform a basic attack. Then check their current health.
### Task Five - Trainer
Create a new file ```TrainerTest``` with class ```TrainerTest```\
Add the following tests:
- ```testConstructorTrainer``` - check the fist monster of the trainer monsters has the correct name
- ```testAddMonster``` - Add six monsters and check six have been added
- ```testAddMonsterOnlyMax``` - Add seven monsters and check only six have been added
- ```testFightLossToHigherLevel``` - Fight the first monster against a monster with more health and higher level. Assert the first monster has zero health 
- ```testRestTeam``` - Fight the first monster to lose, as above. The restTeam, check the first monster is back to full health
- ```testFightLevelUp``` - Let the first monster win and check the first monster is now a higher level
- ```testFightSeedatopLevel1LossToScorchitileLevel2``` - Fight a Seedatops monster in the trainers monster to a higher Scochitile monster. Check the seedpatops is not conscious.
### Submit
- Check that the correct teaching group has been [added with maintainer access](https://stgit.dcs.gla.ac.uk/software-engineering/git_get_started/-/wikis/home/Access-Control).
- Commit and push all your changes.
- Check that the [pipeline](https://stgit.dcs.gla.ac.uk/software-engineering/git_get_started/-/wikis/home/Pipelines) passes.
- Submit a link to your project on Moodle.
