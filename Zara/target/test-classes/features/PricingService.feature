
Feature: Pricing Service

Scenario: Posting a price with a specific start date
Given a price with start date of "2020-06-14 10:00:00" for product ID 35455 and brand ID 1
Then the response status code should be 200
And the response body should not be null

Scenario: Posting a price with a specific start date
Given a price with start date of "2020-06-14 16:00:00" for product ID 35455 and brand ID 1
Then the response status code should be 200
And the response body should not be null

Scenario: Posting a price with a specific start date
Given a price with start date of "2020-06-14 21:00:00" for product ID 35455 and brand ID 1
Then the response status code should be 200
And the response body should not be null

Scenario: Posting a price with a specific start date
Given a price with start date of "2020-06-15 10:00:00" for product ID 35455 and brand ID 1
Then the response status code should be 200
And the response body should not be null

Scenario: Posting a price with a specific start date
Given a price with start date of "2020-06-16 21:00:00" for product ID 35455 and brand ID 1
Then the response status code should be 200
And the response body should not be null
