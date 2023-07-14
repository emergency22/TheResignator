function parseCSV(csv) {
    const rows = csv.split('\n');
    const data = [];

    for (let i = 0; i < rows.length; i++) {
        const rowItem = rows[i].split(',').map(column => column.trim()); // Split each row into columns and trim whitespace
        data.push(rowItem);
    }

    return data;
}

function readCSV(file, domain) {
    return fetch(file)
        .then(response => response.text())
        .then(csvString => {
            const data = parseCSV(csvString);
            // console.log("inside readCSV", domain);

            for (let i = 0; i < data.length; i++) {
                // console.log("data original: ", data[i]);
                // console.log("data changed: ", data[i][0])
                if (domain === data[i][0]) {

                    // console.log("Domain found!");
                    return Promise.resolve(false); // Reject the Promise if domain is found
                }
            }
            // console.log("Domain NOT found!");
            return Promise.resolve(true); // Resolve the Promise if domain is not found
        });
}

async function checkEmail(event) {
    event.preventDefault(); // Prevents the default form submission

    const formData = new FormData(document.getElementById('theForm'));
    const emailFromTheForm = formData.get('email');
    console.log("emailFromTheForm", emailFromTheForm);

    // Check if any field is empty
    let isValid = true;

    if (emailFromTheForm.trim() === '') {
        isValid = false;
    } else {
        // Check if the email is in a valid format
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        isValid = emailRegex.test(emailFromTheForm);
    }
    console.log("isValid: ", isValid);

    if (isValid) {
        const domain = emailFromTheForm.split('@')[1];
        console.log(domain);

        const isSuperValid = await readCSV('../static_assets/domains.csv', domain);

        if (isSuperValid) {
            window.location.assign("../static_assets/paidUser.html");
        } else {
            alert("Please enter your company email address.\n\nNo personal email addresses.");
        }
    }
    else {
        console.log("uh oh");
        alert("Please enter your company email address.");
    }
}


function displayForm() {
    document.getElementById('emailForm').innerHTML = "";

    document.getElementById('emailForm').innerHTML += `<div class="text-center"><form id="theForm">
        <input type="text" id="email" name="email" class="boxSize" placeholder="Enter your company email address" required><br><br>

            <input type="submit" value="That's it. I quit!" class="btn btn-success"></form>
        </div>`;

    const theForm = document.getElementById('theForm');
    theForm.addEventListener('submit', checkEmail);
}

document.addEventListener('DOMContentLoaded', function () {
    displayForm();
});
