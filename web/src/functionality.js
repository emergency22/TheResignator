// import * as quitClient from './quietClient.js';
// import QuitClient from './quietClient.js';
//
// const quitClient = new QuitClient();

document.addEventListener('DOMContentLoaded', function() {
        displayForm();
    });

    function displayForm() {
        document.getElementById('theFormArea').innerHTML = "";

        document.getElementById('theFormArea').innerHTML += `<form id="theForm">
        <input type="text" id="firstName" name="firstName" class="boxSize" placeholder="Your First Name" required><br><br>

        <input type="text" id="lastName" name="lastName" class="boxSize" placeholder="Your Last Name" required><br><br>

        <input type="text" id="position" name="position" class="boxSize" placeholder="Your Title/Position" required><br><br>

        <input type="text" id="organization" name="organization" class="boxSize" placeholder="Name of your Organization" required><br><br>

        <input type="text" id="recipientFirstName" name="recipientFirstName" class="boxSize" placeholder="First Name of Your Supervisor" required><br><br>

        <input type="text" id="recipientEmail" name="recipientEmail" class="boxSize" placeholder="Your Supervisor's Email Address" required><br><br>

        <label htmlFor="executionDate">Select a day to send your resignation notice:</label>
        <input type="date" id="executionDate" name="executionDate" required><br><br>

        <label htmlFor="lastDay">Select a last day of employment:</label>
        <input type="date" id="lastDay" name="lastDay" required><br><br>

        <div class="text-center">
            <input type="submit" value="Submit" class="btn btn-success" onClick="confirmQuit(event)">
        </div>`;
    }

    async function confirmQuit(event) {
        event.preventDefault(); // Prevents the default form submission

        const quitJob = "Quit my job";
        const cancel = "Cancel";

        const submissionData = document.getElementById('theForm');
        const formData = new FormData(submissionData);

        // Check if any field is empty
        let isValid = true;
        formData.forEach((value) => {
            if (value.trim() === '') {
                isValid = false;
                return;
            }
        });

        if (isValid) {
            const confirmation = confirm(
                "There are no takesies backsies. \n \n Press OK to quit your job, or Cancel to stay in your job."
            );

            if (confirmation) {
                // User clicked "OK" or "Yes"
                // Perform the action to quit the job
                const firstName = formData.get('firstName');
                const lastName = formData.get('lastName');
                const position = formData.get('position');
                const organization = formData.get('organization');
                const recipientFirstName = formData.get('recipientFirstName');
                const recipientEmail = formData.get('recipientEmail');
                const executionDate = formData.get('executionDate');
                const lastDay = formData.get('lastDay');

                quitClient.quitJob(firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay);

                document.getElementById('ready').innerHTML = "";
                document.getElementById('theFormArea').innerHTML = "";
                document.getElementById('theFormArea').innerHTML +=
                    `<h5><div class="text-center">That's it. Consider it done.</div></h5><br><br>`;
                console.log("Quitting job...");
            } else {
                // User clicked "Cancel" or "No"
                // Do nothing or perform any other desired action
                document.getElementById('ready').innerHTML = "";
                document.getElementById('theFormArea').innerHTML = "";
                document.getElementById('theFormArea').innerHTML +=
                    `<h5><div class="text-center">Cancelled. Maybe go for a hike instead? <a href="https://www.nps.gov">https://www.nps.gov</a></div></h5><br><br>`;
                console.log("Job quitting canceled.");
            }
        } else {
            alert("Please fill in all the required fields.");
        }
    }
