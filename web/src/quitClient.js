export class QuitClient {
    quitThisJob(senderEmail, firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay) {
        console.log("inside QuitThisJob");
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
