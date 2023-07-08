function confirmQuit(event) {
    event.preventDefault(); // Prevents the default form submission

    const quitJob = "Quit my job";
    const cancel = "Cancel";

    const confirmation = confirm("There are no takesies backsies. \n \n Press OK to quit your job, or Cancel to stay in your job.");

    if (confirmation) {
        // User clicked "OK" or "Yes"
        // Perform the action to quit the job
        // Replace this with your own logic or redirect to a new page
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