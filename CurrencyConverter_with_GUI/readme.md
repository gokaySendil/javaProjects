# Currency Converter-GUI version
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Classes](#Class-Info)
* [Setup](#setup)


## General info
This is a currency converter project that converts money between 2 two currency types.
	
## Technologies
Project is created with:
* Java 15.0.2
* json jar
* Intellij IDEA
* Exchange rate api(https://www.exchangerate-api.com)


## Class-Info
### CurrencyConverter
#### Attributes

* String API_KEY => holds the user's API_KEY value
* String from => First selected currency
* String to => Second selected currency
* String amount => money amount that will be converted
* String url = holds api url
#### Methods
* connect(String key) => key is the name of the currency that is amount of money be converted to.Method connects to api and checks the connection is OK or not.
* read(HttpURLConnection request) => reads the respond from api and returns as a string.
* make_request(String req,String key) => returns the convertion rate of "key" currency.
### ComboItem
#### Attributes
* String key => holds currency name
* String value => holds index value of currency
### Converter
#### Attributes
* JButton CalculalteButton; => Calculate button that actives the calculation of convertion
* JPanel plane; => main plane of frame
* JComboBox comboBox1; => fist currency selection box
* JComboBox comboBox2; => second currency selection box
* JTextField textField1; => input box of amount
* JLabel result; => display label of convertion result
#### Methods
* Converter()=>Constructor of class at the same time action listener of calculate button
* add_items()=> adds the initial elements of comboboxes

## Setup
* Firstly assign your api key value as string to String API_KEY attribute of CurrencyConverter class
* Secondly enable json jar from project structure tab
