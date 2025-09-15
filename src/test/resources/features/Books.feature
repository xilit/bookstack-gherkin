@Suite
  Feature: Book management
    Scenario: Create book without image
      Given User on a main page
      When User click on "Books"
      And User clicks on "Create book" {title} description {description} button
      |test| dsadcsrvrs |400 |
      |test| dsadcsrvrs |400 |
      |test| dsadcsrvrs |400 |
      |test| dsadcsrvrs |400 |
      |test| dsadcsrvrs |400 |
      |test| dsadcsrvrs |400 |

      And User creates valid book without image
      Then Book should be successfully created

      Scenario: Remove book
        Given User on a main page
        When User click on "Books"
        And User clicks on "Create book" button
        And User creates valid book without image
        Then Book should be successfully created
        And User remove book