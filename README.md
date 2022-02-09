# Abraham Ospina test

This project contains Automation Challenge with scenarios and test cases in BDD format.

## Context

Test cases were automated for Create and Delete users features in the "https://reqres.in" API.

For the persistence layer of the api an in-memory database was implemented. The object persisted in the database is the successful response from user creation in the API    

The configuration of the persistence is in the file src/test/resources/META-INF/persistence.xml

The persisted entity is in the class src/test/java/database/UserRepository.java

## Installation

Clone the repository:

```bash
 git clone https://github.com/aaospina/appGateAbrahamOspina.git
```

## Usage

```python
# Run tests
mvn clean verify
```

