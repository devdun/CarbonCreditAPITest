# Automated API Test for Carbon Credits Details

This project demonstrates how to write an automated API test using Java and Rest Assured to verify the acceptance criteria for the Carbon Credits Details endpoint. The API endpoint is provided by Trade Me Sandbox and returns information about the Carbon Credits category.

## Acceptance Criteria

The acceptance criteria for the Carbon Credits Details API endpoint are:

- Name = "Carbon credits"
- CanRelist = true
- The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

## Prerequisites

To run this project, you need to have the following installed on your machine:

- Java (version 8 or above)
- Maven

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine:

```
bashCopy code
git clone https://github.com/devdun/CarbonCreditAPITest.git
```

1. Change into the project directory:

```
bashCopy code
cd CarbonCreditAPITest
```

1. Install the project dependencies:

```
bashCopy code
mvn clean install
```

1. Run the automated API test:

```
bashCopy code
mvn test
```

The test should pass if the acceptance criteria are met by the Carbon Credits Details API endpoint.

## Test Details

```
validateCarbonCredits
```

```
validateInvalidEndpoint
```

```
validateInvalidMethod
```

The `CarbonCreditTests` class contains multiple test methods. The valid test method sends a GET request to the Carbon Credits Details API endpoint and verifies that the acceptance criteria are met by the response.

The test uses Rest Assured to send the HTTP request and extract the response data. The acceptance criteria are verified using JSONPath expressions and assertions provided by the AssertJ library.

If the acceptance criteria are met, the test passes. Otherwise, the test fails with an appropriate error message.

## Conclusion

This project provides an example of how to write an automated API test using Java and Rest Assured. It demonstrates how to verify acceptance criteria for a REST API endpoint and use JSONPath expressions and assertions to validate the response data.

Feel free to modify this project to suit your needs or use it as a reference for your own API test automation projects.