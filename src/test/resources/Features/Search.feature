Feature: Search
Scenario: Search functionality
Given Visit the homepage  of Urban Leader
And User click on search type sofa and enter search
And user apply filter price
And user Add to cart item
And user proceed to checkout
Then Verify that the checkout process proceeds successfully up to the payment page
And Close browser