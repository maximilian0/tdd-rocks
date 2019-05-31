Feature: Multi-Currency Bank Account Management

  In order to leave my money in custody
  As a client of Plaza Bank
  I want to deposit, withdraw and ask for my account balance, summarized and detailed, in pesos and / or dollars

  Scenario Outline: As a client who own an account in Plaza Bank
  when I ask for my account balance in pesos
  I want to know my account summarized balance

    Given my bank account with number <account_number> in <currency>
    And <original_balance> already deposited
    When I ask for the account balance
    Then the balance is <final_balance>

    Examples:
      | account_number | currency | original_balance | final_balance |
      | 1234-BNK       | pesos    | 10 pesos         | 10 pesos      |
      | 1234-BNK       | pesos    | 0 pesos          | 0 pesos       |
      | 1234-BNK       | pesos    | 12 pesos         | 12 pesos      |

  Scenario Outline: As a client who own an account in Plaza Bank
  when I make a deposit of an amount of pesos
  and I ask for my account balance in pesos
  I want to know my account summarized balance

    Given my bank account with number <account_number> in <currency>
    And <original_balance> already deposited
    When I made a deposit of <amount>
    And I ask for the account balance in <currency>
    Then the balance is <final_balance>

    Examples:
      | account_number | currency | original_balance | amount  | final_balance |
      | 1234-BNK       | pesos    | 10 pesos         | 5 pesos | 15 pesos      |
      | 1234-BNK       | pesos    | 0 pesos          | 5 pesos | 5 pesos       |
      | 1234-BNK       | pesos    | 5 pesos          | 5 pesos | 10 pesos      |

  Scenario Outline: As a client who own an account in Plaza Bank
  when I make a withdrawal of an amount of pesos
  and I ask for my account balance in pesos
  I want to know my account summarized balance

    Given my bank account with number <account_number> in <currency>
    And <original_balance> already deposited
    When I made a withdraw of <amount>
    And I ask for the account balance in <currency>
    Then the balance is <final_balance>

    Examples:
      | account_number | currency | original_balance | amount  | final_balance       |
      | 1234-BNK       | pesos    | 10 pesos         | 5 pesos | 5 pesos             |
      | 1234-BNK       | pesos    | 0 pesos          | 5 pesos | insufficient founds |
      | 1234-BNK       | pesos    | 5 pesos          | 5 pesos | 0 pesos             |
