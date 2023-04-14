This project is developed to work with the ALFA812.ru website.
It is based on the Selenium Framework.
Also used:
- csv
- exl
- swing

In order for the project to start, you need to download the Chrome web driver 
of the required version. Download to user.home/chromedriver_win32 folder.
For example - "users/username/chromedriver_win32/chromedriver.exe"

This project is needed to automate the process of ordering goods.

Preparation before starting the project: 
we need to get a csv file containing 4 columns (product name, article, price, quantity).
It is obtained by parsing from the site SP39.ru.

Next, we launch the program. 

A file selection window will open.
You must select a csv file. Then everything will work in standalone mode.

There is a drawback: if you minimize the browser, then over time the operating system
disables this browser and the program cannot add products; for each product not added,
it generates a report. The program continues to work.
The report contains the name of the product and the error that occurred (general error,
the product was not found, the price on the site is higher and the percentage
if there are more than one product (the program cannot decide which product
to choose and sends it to the report)).

At the end of the program, the shopping cart will open and a window
will appear with the inscription "Successful".

The Report file will appear in the Downloads folder.
It looks like this: Alfa-812_Report_14_04_2023.xls