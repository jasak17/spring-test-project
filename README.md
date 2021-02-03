## Instructions

- move to database folder
- docker build -t database .
- docker run -d --name database-contaner -p 5555:5432 database

- move to server directory
- mvn install
- mvn spring-boot:run

- you can see basic API documentation at http://localhost:8080/swagger-ui/
- GET request on http://localhost:8080/api/v1/doctors return all doctors
- POST request on http://localhost:8080/api/v1/doctors with json body (below is example) create all needed entities

{
  "doctor": {
    "id": "100",
    "department": "marand",
    "patients": {
      "patient": [
        {
          "id": "1",
          "first_name": "John",
          "last_name": "Smith",
          "diseases": {
            "disease": ["nice_to_people", "long_legs"]
          }
        },
        {
          "id": "2",
          "first_name": "Jenny",
          "last_name": "Cox",
          "diseases": {
            "disease": ["used_to_have_dredds", "nice_to_people"]
          }
        },
        {
          "id": "3",
          "first_name": "Martin",
          "last_name": "Lewis",
          "diseases": {
            "disease": ["chocaholic", "great_haircut"]
          }
        }
      ]
    }
  }
}

