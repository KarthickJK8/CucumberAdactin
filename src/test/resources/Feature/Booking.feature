Feature: Verifying Adactin Booking details 

@smoke5 
Scenario Outline: Verifying Booking details with all fields 
	Given User should login in the adactin page using "<userName>" and "<password>" 
	When User should search hotel by "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checOutDate>","<adultsPerRoom>" and "<childrenPerRoom>" 
	And User should book a hotel by "<firstName>","<lastName>","<billingAddress>" 
		| creditCardNo     | creditCardType  | month    | year | cvvNumber |
		| 1234432112344321 | AmericanExpress | January  | 2022 |       123 |
		| 1234432112344321 | VISA            | February | 2022 |       321 |
		| 1234432112344321 | Master Card     | March    | 2022 |       451 |
		| 1234432112344321 | Rupay           | April    | 2022 |       123 |
		
	Examples: 
		| userName  | password    | location | hotels      | roomType | numberOfRooms | checkInDate | checOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
		| Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 25/03/2021  | 26/03/2021  | 1 - One       | 0 - None        | Newton    | Ashok    | Chennai        |
		
		@smoke6 
		Scenario Outline: Verifying Booking details without entering fields 
			Given User should login in the adactin page using "<userName>" and "<password>" 
			When User should search hotel by "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>" 
			And User should book a hotel 
			
			Examples: 
				| userName  | password    | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
				| Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 26/03/2021  | 27/03/2021   | 1 - One       | 0 - None        |
