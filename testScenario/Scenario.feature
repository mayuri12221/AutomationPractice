Feature: Test various functionalities of an application


Background:
Given user is on Home page

@Registration
Scenario: Successful registration 
		When user navigates to sign in page
		And user clicks enters valid email
		And user click on create an account
		And user give all required registration details
		And user clicks on register 
		Then user should be able to register successfully
		
@InvalidEmail
	Scenario: Error displayed for invalid email address
		When user navigates to sign in page
		And user enters invalid email
		And user click on create an account
		Then error message should be displayed
		
@SummerDressesMegamenu
	Scenario: Validate Summer Dresses Megamenu
		When user clicks on Dresses
		And user clicks on Summer Dresses
		Then user navigates Summer Dresses page
		
@Sorting
	Scenario: Sort summer dresses by price
	  When user clicks on Dresses
	  And user clicks on Summer Dresses
	  And user clicks on Sort by price
	  Then items should be arranged accordingly

@CartSummary
	Scenario:  Validate product details in the cart summary
  	When user clicks on Dresses
  	When user select a dress 
  	And user change the dress color to blue
  	And user add the product to cart
  	Then user should see proper Details of the product in the cart summary
