Feature: Bank Account

  In order to leave my money in custody
  As a client of Plaza Bank
  I want to deposit, withdraw and ask for my account balance , summarized and detailed, in pesos and / or dollars

  Scenario Outline: Ask for my account balance in pesos

    Given my bank account numbered <account> with <balance>
    When I ask for the account balance
    Then the balance is <balance>

    Examples:
      | account  | balance  |
      | 1234-BNK | 10 pesos |
      | 1234-BNK | 0 pesos  |
      | 1234-BNK | 12 pesos |

  Scenario Outline: Deposit of an amount of pesos in my account

    Given my bank account numbered <account> with <original_balance>
    When I made a deposit of <deposit>
    And I ask for the account balance
    Then the balance is <balance>

    Examples:
      | account  | original_balance | deposit | balance  |
      | 1234-BNK | 10 pesos         | 5 pesos | 15 pesos |
      | 1234-BNK | 0 pesos          | 5 pesos | 5 pesos  |
      | 1234-BNK | 5 pesos          | 5 pesos | 10 pesos |

  Scenario Outline: Withdraw of an amount of pesos in my account

    Given my bank account numbered <account> with <original_balance>
    When I made a withdraw of <withdraw>
    And I ask for the account balance
    Then the balance is <balance>

    Examples:
      | account  | original_balance | withdraw | balance             |
      | 1234-BNK | 10 pesos         | 5 pesos  | 5 pesos             |
      | 1234-BNK | 0 pesos          | 5 pesos  | insufficient founds |
      | 1234-BNK | 5 pesos          | 5 pesos  | 0 pesos             |
