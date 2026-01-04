# Core Java Assignments
This document contains Day 1 Core Java backend training assignments focused on OOP concepts, memory management, multithreading, file handling, reflection, generics, and exception handling for hands-on learning.

**Question 1**

Develop two classes

Alpha class with following properties

private int

protected int

public int

Generate getter and setter method for these properties

Beta class with public static void main method

Create an object of Alpha class

Try accessing modification of protected and public data member of the Alpha class

Use getter and setter method for retrieving and for modifying values of private member

**Question 2**

Memory management : Stack vs Heap

int intVal;

String stringVal;

Generate getter and setter methods for the variables above

Implement toString() method for the class DataObject

Implemetswap method which takes DataObjectclass and swaps the content from current object with the input object

Implement main method, and create two instances of the DataObjectclass

Call swap method on one of the instance and pass the other instance as an input

Use toString() method to print the content of the class

**Question 3**

Implement Employee class with following specification

String firstName

String lastName

Date dateOfBirth

double experience

Implement MyCollection class with the following specification

Array of 300 entries of Employee class

writeCounter

readCounter

The following methods to be syncronized

add(Employee) → new element should be added at writeCounter, writeCounter should be increment after every insert

Employee get() → element should be readCounter, readCounter should be incremented after every read operation

Define a interface MyFileHandler with following methods

read

write

Declare CSVFileHandler, XMLFileHandler, JsonFileHandler classes that implements MyFileHandler

CSVFileHandler should have ability to read and write data in CSV

XMLFileHandler should have ability to read and write data in XML

JsonFileHandler should have ability to read and write data in JSON

Generate three data files and each file containing 100 records

File one should be CSV format

File two should be XML format

File three should be JSON format

Develop a controller class MyController with the following logic

Create three threads and allocate one threads each for reading data from CSV, XML and JSON

Each thread reads record by record and insert into MyCollection class

Main thread that has created three threads should wait for all threads to finish

Once the read finishes

Print the count of elements from MyCollection

It should be 300

Write counter should be properly updated to 300

Create three threads to write data from MyCollection with the following specifications

Each thread reading one record from MyCollection, read method should return the value and increment the counter

Thread 1 should write record in CSV

Thread 2 should write records in XML

Thread 3 should write records in JSON

Once record is wirtten to the file thread should seek next record from MyCollection

Each thread should finish reading after 100 records

Files should not have duplicate records and should not have more than 100 records

**Question 4**

Reference:
https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html

Create following classes

Employee Class with the following properties

private String firstName

private String lastName

private long age

private Date dateOfJoining

Generate getter and setter methods

Override the following methods

toString()

equals()

hashCode()

Create ReflectionTest class with main method and implement following logic

Using reflection features get the Class object for Employee class

Get the list of declared members / fields for the class

Get the list of methods implemented

Get the list of Annotations defined in the class

**Question 5**

Implement MyList generic class, which has a member of generic array of size hundred

This class should support the following operations:

Add a new value

Delete based on index

Delete based on value

Get from an index

This class should be used to create a list of:

Integer

String

Custom class

Create following custom Exception classes:

MaxSizeException

NoDataException

Modify the MyList class implementation using the above exceptions based on the conditions which satisfy these exception cases
