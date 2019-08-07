Feature: Multi-Currency Bank Account Management

  In order to leave my money in custody
  As a client of Plaza Bank
  I want to deposit, withdraw and ask for my account balance, summarized and detailed, in pesos and / or dollars

  Scenario Outline: As a client who own an account in Plaza Bank
  when I ask for my account balance in pesos
  I want to know my account summarized balance in pesos

    Given my bank account with number <account_number> in <currency>
    And <original_balance> already deposited
    When I ask for the account <account_number> balance
    Then the balance is <final_balance>

    Examples:
      | account_number | currency | original_balance | final_balance |
      | 1234-BNK       | pesos    | 10 pesos         | 10 pesos      |
      | 1234-BNK       | pesos    | 0 pesos          | 0 pesos       |
      | 1234-BNK       | pesos    | 12 pesos         | 12 pesos      |

  Scenario Outline: As a client who own an account in Plaza Bank
  when I make a deposit of an amount of pesos
  then I get my updated account summarized balance in pesos

    Given my bank account with number <account_number> in <currency>
    And <original_balance> already deposited
    When I made a deposit of <amount> into <account_number>
    Then the balance is <final_balance>

    Examples:
      | account_number | currency | original_balance | amount  | final_balance |
      | 1234-BNK       | pesos    | 10 pesos         | 5 pesos | 15 pesos      |
      | 1234-BNK       | pesos    | 0 pesos          | 5 pesos | 5 pesos       |
      | 1234-BNK       | pesos    | 5 pesos          | 5 pesos | 10 pesos      |

#  Scenario Outline: As a client who own an account in Plaza Bank
#  when I make a withdrawal of an amount of pesos
#  then I get my updated account summarized balance in pesos

#    Given my bank account with number <account_number> in <currency>
#    And <original_balance> already deposited
#    When I made a withdraw of <amount>
#    Then the balance is <final_balance>

#    Examples:
#      | account_number | currency | original_balance | amount  | final_balance      |
#      | 1234-BNK       | pesos    | 10 pesos         | 5 pesos | 5 pesos            |
#      | 1234-BNK       | pesos    | 0 pesos          | 5 pesos | insufficient funds |
#      | 1234-BNK       | pesos    | 5 pesos          | 5 pesos | 0 pesos            |

#  Scenario Outline: As a client who own an account in Plaza Bank
#  when I ask for my account balance in dollars
#  and the exchange value is ratio
#  I want to know my account summarized balance in dollars

#    Given my bank account with number <account_number> in <currency>
#    And <original_balance> already deposited
#    And exchange value is <ratio>
#    When I ask for the account balance
#    Then the balance is <final_balance>

#    Examples:
#      | account_number | currency | original_balance | final_balance | ratio |
#      | 1234-BNK       | pesos    | 10 pesos         | 0.24 dollars  | 42.5  |
#      | 1234-BNK       | pesos    | 42.5 pesos       | 1 dollars     | 42.5  |
#      | 1234-BNK       | pesos    | 12 pesos         | 0.29 dollars  | 42.5  |