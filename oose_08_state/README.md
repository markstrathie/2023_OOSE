# Lab_07_State_Student_Flow

## Task One A  - Easy
* Change the traffic light flow to: Red -> Blue -> Green -> Amber -> Red
* See [video](https://mediaspace.gla.ac.uk/media/State+Traffic+Light+-+Blue/1_s2y1ss30) ~ 3 minutes
* Add a BlueState implementing ColourState to the Traffic Lights.
* Add a new LightColour enumerator of Blue
* BlueState.getState returns the LightColour.Blue
* BlueState.setState sets to GreenState
* RedState.setState sets to BlueState

## Task One B - Medium
* There are three levels of car wash, see LevelOfCarWash enumerator.
  * SILVER - Start -> Car Body -> Wheels -> Finish 
  * GOLD - Start -> Car Body -> Wheels -> Dry -> Finish
  * PLATINUM - Start -> Car Body -> Wheels -> Dry -> Polish -> Finish
* Amend CarWashStage to add a Dry and Polish enumerator
* Create a DryState implementing WashState
  * setState will go to Finish if GOLD and POLISH if PLATINUM
* Amend WashWheelState if SILVER go to Finish else Dry
* Create a PolishState implementing WashState
  * setState will go to Finish

## Task One C - Hard
* There are three levels of car wash, see LevelOfCarWash enumerator.
  * SILVER - Start -> Car Body -> Wheels -> Finish
  * GOLD - Start -> Car Body -> Wheels -> Dry -> Finish
  * PLATINUM - Start -> Car Body -> Wheels -> Dry -> Polish -> Finish
* Amend CarWashStage to add a Dry and Polish enumerator
* Create a SilverCarWash, GoldCarWash and PlatinumCarWash to control the flow

## Task Two - Easy
* Create a RegistrationState that implements State
* Amend ApplicationState setState
  * studentRecord.setState take new RegistrationState as a parameter
  * Only do this when the student has a student id, a first name and the email contains a "@"
* Amend ApplicationState getState to return the StudentStateType.APPLICATION

## Task Three - Very Easy
* Create a FinancialState that implements State
* Amend RegistrationState setState
  * studentRecord.setState take new FinancialState as a parameter
  * Only do this when the captureRegistration.state return a not null StudentRegistrationRecord
* Amend RegistrationState getState to return the StudentStateType.REGISTRATION

## Task Four - Very Easy
* Create a ActiveState that implements State
* Amend FinancialState setState
  * studentRecord.setState take new ActiveState as a parameter
  * Only do this when the captureFinancial.state return a not null StudentFinancialRecord
* Amend FinancialState getState to return the StudentStateType.FINANCIAL
* 
## Task Five - Hard
* Create an EnterPaymentState that implements State
* Amend FinancialState setState
  * If how to pay is not "SAAS" go to EnterPaymentState else ActiveState
* Create a CaptureEnterPayment to gather the following:
  * Card Type
  * Card Number
* Create a StudentPaymentRecord to store the above
* Amend StudentStateType to add an ENTER_PAYMENT enumerator item
* EnterPaymentState.getState return ENTER_PAYMENT enumerator
* EnterPaymentState.setState got to ActiveState if captureEnterPayment returns a not null StudentPaymentRecord
* Once the lab is completed, the pipeline (CI/CD tab on the left) should pass.
* 
