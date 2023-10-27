# UIDataDriven
This Project has been build to run the test cases after getting input data from external files

# Tools and Framework Used:
  • Selenium
  • Maven repository
  • Poi and Poi-ooxml
  • TestNG

# Main Features
	• DataDriver Approach is implemented for Each test cases can be represented as a row or some rows (if the test case consists of multiple rows) in the relevant Excel sheet. All you need is to know what is your scope in testing and just add the test data in the Excel sheet with the predefined schema with proper column cound and data set.
	• All classes and methods are implemented in Java with Maven repository to include all dependencies needed.
	• Supports any UI Automation testing.
	• Utilizes the capabilities of TestNG flexible test suites configuration and management. Created 2 types of default html report.
		○ The Default HTML reports are very descriptive with good statistics reports that can be integrated with Jenkins after test execution to have summary status of each deployment. located at:test-output/emailable-report.html
		○ Extra Default Reports can be found at: test-output/index.html

# Test Covered
	• AmazonSearch: 
	1. Launch the browser.
  2. Open URL - http://www.google.com
	3. Enter the keyword "amazon" in the search bar
	4. print all the search results
	5. Click on the link which takes you to the amazon login page. 6. login to https://www.amazon.in/
	7. click on all buttons on search & select Electronics.
	8. search for dell computers
	9. apply the filter of range Rs 30000 to 50000
	10. Print all the products whose rating is 5 out of 5
	
# DataDriven

• Data for all the testcase are getting input from the external Excel file located at: UIDataDriven/data.xlsx
• Based on number of rows number of times respective test case will execute. 

![image](https://github.com/rishabhdesire/UIDataDriven/assets/74549534/6b33b310-35c6-4335-ac17-6b34a812298e)


# Execution using command promt
	• You can use below commands to execute respective test case.
	• Commands:
		○ To run respective test: mvn test -Dtest="AmazonSearch"

# Reports:
2 Types of reports get generated:
	• The Default HTML reports are very descriptive with good statistics reports that can be integrated with Jenkins after test execution to have summary status of each deployment. located at:test-output/emailable-report.html
	• Extra Default Reports can be found at: test-output/index.html

 ![image](https://github.com/rishabhdesire/UIDataDriven/assets/74549534/8cfe4014-ecfc-43a6-a2c1-e8f33e91bce7)

# Log Files:
• Log are getting tracked inside default HTML report file located at:test-output/emailable-report.html

![image](https://github.com/rishabhdesire/UIDataDriven/assets/74549534/71a79ec2-8442-4436-a0a9-7bab70d9ada6)





