# ITBootcamp_Final_Selenium_Project
### Web automation final project at IT Bootcamp: Demonstrating skills for software application testing with Selenium and TestNG libraries
#### Technologies - ***Java***, ***Maven***, ***Selenium***, ***TestNG***, ***Git***  
#### Tasks:
1. ***Automated functional testing*** of web application [My awesome App](https://vue-demo.daniel-avellaneda.com)
2. Implementation of ***Page Object Model(POM)*** for structured organization of automated tests
3. Utilization of ***Selenium library*** for web-page interaction
4. ***Test implementation*** for:  
     a) *login*  
     b) *registration*  
     c) *administering location*  
     d) *language modulation*

Project consists of 28 tests arranged into 6 test scenarios:

- [x] **Login tests**: Verifying user login functionality 
- [x] **Signup tests**: Verifying user signup functionality 
- [x] **Admin Cities tests**: Testing functionalities for creating, editing and deleting cities 
- [x] **Auth Routes tests**: Testing route protection for unauthenticated users
- [x] **Locale tests**: Testing page content in different languages
- [x] **Profile tests**: Testing profile page form and its functionalities

All test cases for this project can be found [here](TEST_CASES.md)

Tests are being organized and implemented using testng.xml and run with command line:   
**mvn clean test -Dsurefire.suiteXmlFiles=testng.xml**

