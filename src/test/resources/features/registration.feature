Feature: User Registration on Basketball England

  As a user,
  I want to be able to create a new account,
  So that I can use the membership services.

  Scenario Outline: Create user successfully
    Given I am on the registration page using "<browser>"
    When I fill in the registration form with valid details
    Then I submit the form
    And I should see a successful registration message

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Create user with missing last name
    Given I am on the registration page using "<browser>"
    When I fill in the registration form with missing last name
    Then I submit the form
    And I should see a last name required error

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Create user with non-matching passwords
    Given I am on the registration page using "<browser>"
    When I fill in the registration form with mismatched passwords
    Then I submit the form
    And I should see a password mismatch error

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Create user without accepting terms and conditions
    Given I am on the registration page using "<browser>"
    When I fill in the registration form without accepting terms and conditions
    Then I submit the form
    And I should see terms and conditions errors

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Create user with invalid email format
    Given I am on the registration page using "<browser>"
    When I fill in the registration form with an invalid email format
    Then I submit the form
    And I should see an invalid email error


    Examples:
      | browser |
      | chrome  |
      | firefox |