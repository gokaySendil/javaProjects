# Currency Converter v2
* [General info](#general-info)
* [Technologies](#technologies)
* [Class Info](#Classes and Methods)

## General info
This project is simple currency converter.User enters the amount and select 2 currency types one is from other is to.Then the program converts to amount to second currency due to current convertsion rate.
	
## Technologies
Project is created with:
* Java 15.0.2
* Jetbrains IntelliJ IDEA
* json jar file
* API(https://www.exchangerate-api.com)

## Classes and Methods
### ComboItem
#### Attributes
* String key => Display value in the combo box
* String value => Index of the value
#### Methods
* Constructor() => Get the values of value and key and assign to attributes
* Getter() and Setter() => Gets the values and set the values
### Converter
#### Attributes
* JComboBox comboBox1 => First currency selection box(From)
* JComboBox comboBox2 => Second currency selection box(To)
* JTextField textField1 =>Texfield for entering amount
* JLabel result => Result display text
* #### Methods
* add_items()=> adds the inital items to comboboxes
* Constructor()=>This has action listener of calculate button
* Getters() and Setters()=>Gets and sets the values of attributes
