# PaySlip Calculator


## Steps to Build and Run

Main ClassName: com.payslip.calculator.PaySlipGenerator

- Implemented and tested using Java 8

- Tests Require JUnit

- Project dependencies and compiling managed by Maven

Create a file input.txt with the following records like below:-
David,Rudd,60050,9%,01 March – 31 March
Ryan,Chen,120000,10%,01 March – 31 March

This is the sample data.

- Run: `mvn exec:java`

Sample Input
input.txt output.txt

This will create a output.txt with the expected result.

## Assumptions

* Payslip is only calculated for specific month not for certain days.
* Header is not expected in the input file.
* Program quits if the input csv is in incorrect format.
