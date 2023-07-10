// import axios from 'axios';
export class QuitClient {
    quitThisJob(firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay) {
        console.log("QUITTTT!!!");
        console.log("firstName is: " + firstName);

        //take in the data from the form and pass it to the backend for processing via a POST request utilizing axios
        //include said data in the body
        // axios.post('http://localhost:8080/quit', {firstName: firstName, lastName: lastName, position: position, organization: organization, recipientFirstName: recipientFirstName, recipientEmail: recipientEmail, executionDate: executionDate, lastDay: lastDay});

        //On the backend, perhaps utilize Spring Boot @RequestBody to automatically map the request body data to a Java object
        //stretch: include and incorporate a response from the backend

        // axios.post(url, data, config)
        //     .then(response => {
        //         // Handle success
        //         console.log(response.data);
        //     })
        //     .catch(error => {
        //         // Handle error
        //         console.error(error);
        //     });



        return null;
    }
}
