# Currency Converter v2
* [General info](#general-info)
* [Technologies](#technologies)
* [Class Info](#Classes)

## General info
This project is simple currency converter.Converts an amout of TRY to other currencies.User selects the currency that want to change to and enters the amount.
	
## Technologies
Project is created with:
* Java 15.0.2
* Jetbrains IntelliJ IDEA
* json jar file
* API(https://www.exchangerate-api.com)

## Classes
### CurrencyConverter
#### Attributes
* String API_KEY => Stores api key value
* String from => First currency name 
* String to => Second currency name
* String amount => amount to be converted
* String urls=> api url
#### Methods
* Constructor()=>Sets the initial attribute values
* conncet() => Connects to api
* read() => Reads the respond from api
* make_request() =>gets the conversion rate from read file
