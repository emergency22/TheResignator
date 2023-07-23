import { QuitClient }  from './quitClient.js';
const quitClient = new QuitClient();

//Verifies that all form fields are filled and warns the user.
async function confirmQuit(event) {
    event.preventDefault(); // Prevents the default form submission

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
            const senderEmail = sessionStorage.getItem("validatedEmail");
            const firstName = formData.get('firstName');
            const lastName = formData.get('lastName');
            const position = formData.get('position');
            const organization = formData.get('organization');
            const recipientFirstName = formData.get('recipientFirstName');
            const recipientEmail = formData.get('recipientEmail');
            const executionDate = formData.get('executionDate');
            const lastDay = formData.get('lastDay');

            quitClient.quitThisJob(senderEmail, firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay);

            document.getElementById('ready').innerHTML = "";
            document.getElementById('theFormArea').innerHTML = "";
            document.getElementById('theFormArea').innerHTML +=
                `<h5><div class="text-center">That's it. Consider it done.</div></h5><br><br><div id="emailSection"></div>`;
            console.log("Quitting job...");
        } else {
            // User clicked "Cancel" or "No"
            document.getElementById('ready').innerHTML = "";
            document.getElementById('disclaimer').innerHTML = "";
            document.getElementById('theFormArea').innerHTML = "";
            document.getElementById('theFormArea').innerHTML +=
                `<h5><div class="text-center">Cancelled. Maybe go for a hike instead? <a href="https://www.nps.gov">https://www.nps.gov</a></div></h5><br><br>`;
            console.log("Job quitting canceled.");
        }
    } else {
        alert("Please fill in all the required fields.");
    }
}
//Displays the form that captures all the data
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
            <input type="submit" value="Submit" class="btn btn-success"></form>
        </div>`;
}

document.addEventListener('DOMContentLoaded', function() {
    displayForm();

    const submitButton = document.querySelector('.btn.btn-success');
    submitButton.addEventListener('click', confirmQuit);
});
