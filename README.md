# roman-numerals
This is an simple rest application which converts Roman numerals to digits and digits to Roman numerals

#### How to install and run app:

1. Clone this **branch** or download this project as zip and unzip it to your projects location.
2. Open project location with Eclipse/ Intellij or any other IDEs, path example: “C:\Development\roman-numerals".
3. Open your project with Eclipse or other code editor and navigate with code editor terminal to same project directory as mentioned in **2 step**
4. Once the project is successfully imported, let the required maven dependencies be successfully downloaded!
5. Run the application, you will see message in terminal what port it is using.
6. Open your browser on that port location. Example: "http://localhost:8080/".

#### Swagger API Documentation
**URL**: http://localhost:8080/swagger-ui.html#/

#### API Endpoints
#### GET -> /roman-numerals/{input}
            -> @param Takes numbers from 1 to 4000 as input and converts to valid Roman Numerals
            -> @return Returns a valid roman numeral
            -> @throws InvalidInputException
    
#### GET -> /digits/{input}
            -> @param Takes valid Roman Numerals as input and converts to numbers
            -> @return Returns a number 
            -> @throws InvalidInputException
            
#### Assumptions
The Romans wrote numbers using letters: I, V, X, L, C, D, and M.
I have assumed and mapped the letters with numbers in the code as below.

#### I-1, IV-4, V-5, IX-9, X-10, XL-40, L-50, XC-90, C-100, CD-400, D-500, CM-900, M-1000
      
