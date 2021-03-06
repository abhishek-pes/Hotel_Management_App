# Hotel_Management_App

Hotel management system manages and maintains the records of customers, rooms and employees in the hotel. This system is aimed to maintain the day-to-day state of admission of residents, record of employees, room details and availability. This software application helps administrators  to handle customer information, room allocation details, payment details. The rooms have different categories like single bed, double bed etc. This software has a minimalistic GUI for performing database actions and carrying out hotel related transactions. Interactive GUI and the ability to manage various rooms, employees, drivers and customers make this system very flexible and convenient. The administrator is the superuser who has exclusive access to the system, secured with a password. This application gives managers the power and flexibility to manage the hotel from a single online system.

## Tools and Frameworks Used
 
  * Spring Boot Framework
  * MySQL Database
  * Thymeleaf
  * Intellij Idea IDE

## Design Principles and Design Patterns Applied

1. Single Responsibility Principle: A class was created for each use case  – Admin, Driver, Employee, Job, Room, User and the class handles all the responsibilities of only that use case.

2. Open-Close Principle: For each use case the interfaces were created and the interfaces were closed for modifications and opened for extension by a class

![image](https://user-images.githubusercontent.com/34886474/164423213-94613562-e72b-4577-9742-cad43170df42.png)
