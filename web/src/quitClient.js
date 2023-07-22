export class QuitClient {

    //Takes in all the information from the form and starts the API POST request to the backend.
    quitThisJob(senderEmail, firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay) {

        const data = {
            senderEmail: senderEmail,
            firstName: firstName,
            lastName: lastName,
            position: position,
            organization: organization,
            recipientFirstName: recipientFirstName,
            recipientEmail: recipientEmail,
            executionDate: executionDate,
            lastDay: lastDay
        };

        const jsonData = JSON.stringify(data);

        console.log(data);

        axios.post('http://localhost:3000/resignator', jsonData)
            .then((result) => console.log(result))
            .catch((error) => console.log(error));
    }


}
