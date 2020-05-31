Feature: Exercise1 test
Scenario: Home Page Test
Given I open JDI GitHub site
And I login as user Roman Iovlev
Then 'Home Page' page should be opened
And User name should be 'ROMAN IOVLEV'
When I click on Service button in Header
And I click Different elements button
And I select checkbox 'Water'
And I select checkbox 'Wind'
And I select radio 'Selen'
And I select in dropdown 'Yellow'
And LogRow should contain following values:
|value |condition|
|Water |true     |
|Wind  |true     |
|metal |Selen    |
|Colors|Yellow   |