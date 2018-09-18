/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Rodriguez
 */
public class CheckingAccount extends Account{
        public static int CheckingAccount (double transferAmount, Account fromAccount, Account toAccount) {          
        //If balance is greater or equal to than 1000
        if(fromAccount.getBalance() >= AccountConstants.CHECKING_BALANCE_THRESHOLD){            
             //Check if balance of transferring account is greater than transferAmount
            if (fromAccount.getBalance() >= transferAmount){
                //No deduction
                transferTo(transferAmount, fromAccount, toAccount); 
                return 0;
            }
            //Insufficient funds
            else{
               return -2; 
            }            
        }
        //Balance is less than 100
        else {            
           //Check if balance of transferring account(-2) is greater than transferAmount
            if ((fromAccount.getBalance() - AccountConstants.TRANSFER_FEE) >=  transferAmount){
                //deduct $2 after transfer is made
                transferTo((transferAmount - AccountConstants.TRANSFER_FEE), fromAccount, toAccount); 
                return 1;
            }
            //Insufficient funds
            else{
               return -1; 
            }
        }         
    }
}
