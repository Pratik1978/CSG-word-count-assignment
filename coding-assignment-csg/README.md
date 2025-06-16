# CSG-word-count-assignment

This project takes list of String as an input and  :

    -> Counts how many words start with the letter M or m.

    -> Returns a list of words that have more than 5 characters.
------------------------------------------------------------------------------
Technologies used:-

Java 17
Spring boot 3.x
Maven
Version Control System

----------------------------------------------------------------------------

Usage: 

Running the application (e.g., mvn spring-boot:run).
Accessing the application ( http://localhost:8080).   

-----------------------------------------------------------------------------
Endpoint details:- 

POST endpoints:

REST-API:- Counts how many words start with the letter M or m.

URL:-http://localhost:8080/count-starting-with-m


Payload:- {
    "words": [
        "Mango",
        "apple",
        "melon",
        "Banana",
        "muffin"
    ]
}
---------------------------------------------------------------------------------
REST-API:- Returns a list of words that have more than 5 characters.
URL:- http://localhost:8080/longer-than-five


Payload:- 
    {
        "words": [
            "Mango",
            "apple",
            "melon",
            "Banana",
            "muffin"
        ]
    }

-----------------------------------------------------------------------------------
