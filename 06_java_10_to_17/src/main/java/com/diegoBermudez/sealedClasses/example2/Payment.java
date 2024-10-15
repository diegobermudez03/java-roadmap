package com.diegoBermudez.sealedClasses.example2;

public sealed interface Payment permits Paypal, CreditCard, BankTransfer{
}
