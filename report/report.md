#Мутанты

##Примеры убитых мутантов

###public boolean deposit(int sum)
1. return false;
2. return true;
3. KILL
4. blockDepositTest()

###public boolean withdraw(int sum)
1. return false;
2. return true;
3. KILL
4. blockWithdrawTest()

###public int getBalance()
1. return balance;
2. return 0;
3. KILL
4. getBalanceTest(), bigWithdrawTest(), withdrawTest(), overBoundWithdrawTest(), depositTest(), overBoundDepositTest()
EqBoundWithdrawTest()
###public int getMaxCredit()
1. return -maxCredit;
2. return 0;
3. KILL
4. bigWithdrawTest(), getMaxCreditTest(), eqMaxCreditWithdrawTest(), setMaxCredit(), unblockUnSuccess()

###public boolean isBlocked()
1. return blocked;
2. false
3. KILL
4. unblockUnSuccess(), block()

###public void block()
1. blocked = true;
2. blocked = false;
3. KILL
4. block(),  blockDepositTest(), unblockUnSuccess(), setMaxCredit(), blockWithdrawTest()

###public boolean unblock()
1. return false;
2. return true;
3. KILL
4. unblockUnSuccess()

###public boolean setMaxCredit(int mc)
1. if (!blocked)
2. if (blocked)
3. KILL
4. unblockSetMaxCreditTest, demo.AccountTest#setMaxCredit

##Пример эквивалентных мутантов

###public boolean withdraw(int sum)
1. else if(sum < 0 || sum > bound || Math.abs(balance - sum) > bound)
2. else if(sum < 0 || sum > bound || Math.abs(balance - sum) >= bound)
3. Данный мутант эквивалентный так как далее проверяется условие else if(balance <= maxCredit + sum)
которое компенсирует эту проверку.