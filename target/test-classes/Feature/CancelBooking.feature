Feature: Verifying Adactin Cancel Booking details 

@smoke7 
Scenario Outline: Verifying Cancel Booking details with all fields 
	Given User should login in the adactin page using "<userName>" and "<password>" 
	When User should search hotel by "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>" 
	And User should book a hotel by "<firstName>","<lastName>","<billingAddress>" 
		| creditCardNo     | creditCardType   | month    | year | cvvNumber  |
		| 1234432112344321 | AmericanExpress  | January  | 2022 |        321 |
		| 1234432112344321 | VISA             | February | 2022 |        111 |
		| 1234432112344321 | Master Card      | March    | 2022 |        345 |
		| 1234432112344321 | Rupay            | April    | 2022 |        585 |
	And User Should Cancel booking 
	
	Examples: 
		| userName  | password    | location | hotels      | roomType  | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
		| Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard  | 1 - One      | 27/03/2021  | 28/03/2021   | 1 - One       | 0 - None        | Karthick  | J     	| Chennai        |
		
		@smoke8 
		Scenario Outline: Verifying Cancel Booking with Existing order id 
			Given User should login in the adactin page using "<userName>" and "<password>" 
			When User should cancel booking using existing order id 
			
			Examples: 
				| userName  | password    |
				| Karthi007 | Karthi@1989 |
