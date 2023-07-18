export class QuitClient {
    quitThisJob(senderEmail, firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay) {
        console.log("inside QuitThisJob")
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

        const jsonString = JSON.stringify(data);
        console.log(jsonString);

        // axios.post('http://localhost:8080/quit', jsonString)
        //     .then(response => {
        //         // Handle success
        //         console.log("success", response.data);
        //     })
        //     .catch(error => {
        //         // Handle error
        //         console.error(error);
        //     });

        axios.post('http://localhost:3000/resignator', jsonString)
            .then((result) => console.log(result))
            .catch((error) => console.log(error))


    }
}
