export class QuitClient {

    //Takes in all the information from the form and starts the API POST request to the backend.
    async quitThisJob(senderEmail, firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay) {

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
            .then((result) => {
                console.log(result);
                console.log("1", result.data);  //This is a step in the right direction
                console.log("subject", result.data.subject);
                const backendRecipientAddress = result.data.recipientAddress;
                const backendSubject = result.data.subject;
                const backendExecutionDate = result.data.executionDate;
                const backendBody = result.data.body;

                document.getElementById('emailSection').innerHTML = "";
                document.getElementById('emailSection').innerHTML += `
                <h5>We will send this email: </h5><br>
                
                Recipient Email: ${backendRecipientAddress} <br>
                Subject: ${backendSubject} <br>
                
                ${backendExecutionDate} <br><br>
                
                ${backendBody} <br>
                `


            })
            .catch((error) => {
                console.log(error);
            });

        // document.getElementById('theFormArea').innerHTML = "";
        // document.getElementById('theFormArea').innerHTML +=
        //     `<h5><div class="text-center">That's it. Consider it done.</div></h5><br><br><div id="emailSection"></div>`;

    }
}
