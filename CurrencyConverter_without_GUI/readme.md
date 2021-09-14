#Currency Converter-Console Version
Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Classes](#Class-Info)
* [Setup](#setup)


## General info
This is a currency converter project that built on based currency as Turkish Lira.
	
## Technologies
Project is created with:
* Java 15.0.2
* json jar
* Intellij IDEA
* Exchange rate api(https://www.exchangerate-api.com)


## Classe-Info
### CurrencyConverter
#### Attributes
* String API_KEY=> stores the personal api key of user.
* String url => stores the api url that is gonna be used in project.
#### Methods
* connect(String key) => key is the name of the currency that is amount of money be converted to.Method connects to api and checks the connection is OK or not.
* read(HttpURLConnection request) => reads the respond from api and returns as a string.
* currency_read(String response) => creates a json object based on response then prints the all currency rates on console.
* get_specific_rate(String response,String key) => returns the exchange rate of currency "key" from json file.
* get_rate(int num)=> num is the users selection method returns the result of all rate calculations
* showMenu()=> shows the user initial elements of program and allows to user make selection.
## Setup
* Firstly assign your api key value as string to String API_KEY attribute of CurrencyConverter class
* Secondly enable json jar from project structure tab
