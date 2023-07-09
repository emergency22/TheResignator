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

    function confirmQuit(event) {
        event.preventDefault(); // Prevents the default form submission

        const quitJob = "Quit my job";
        const cancel = "Cancel";

        const confirmation = confirm("There are no takesies backsies. \n \n Press OK to quit your job, or Cancel to stay in your job.");

        if (confirmation) {
            // User clicked "OK" or "Yes"
            // Perform the action to quit the job
            // Replace this with your own logic or redirect to a new page
            document.getElementById('ready').innerHTML = "";
            document.getElementById('theFormArea').innerHTML = "";
            document.getElementById('theFormArea').innerHTML +=
                `<h5><div class="text-center">That's it. Consider it done.</div></h5><br><br>`;
            console.log("Quitting job...");
        } else {
            // User clicked "Cancel" or "No"
            // Do nothing or perform any other desired action
            console.log("Job quitting canceled.");
        }
    }




// addHoseFormSubmitter(fireDept, apparatusTypeAndNumber) {
//     var addHoseFormToClient = document.getElementById('addHoseForm');
//     addHoseFormToClient.addEventListener('submit', async (event) => {
//         event.preventDefault()  //prevents auto-submit
//
//         var inputName = document.getElementById('name').value;
//         var inputColor = document.getElementById('colorSelector').value;
//         var inputLength = document.getElementById('lengthSelector').value;
//         var inputDiameter = document.getElementById('diameterSelector').value;
//         var inputGallons = document.getElementById('gpmSelector').value;
//
//         await this.client.addHose(fireDept, apparatusTypeAndNumber, inputName, inputColor, inputLength, inputDiameter, inputGallons);
//         await this.displayHoses(fireDept, apparatusTypeAndNumber);
//     });