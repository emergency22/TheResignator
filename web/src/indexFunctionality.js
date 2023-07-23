//Parses the CSV file and splits up domains, returning an array of separated domains.
function parseCSV(csv) {
    const rows = csv.split('\n');
    const data = [];

    for (let i = 0; i < rows.length; i++) {
        const rowItem = rows[i].split(',').map(column => column.trim()); // Split each row into columns and trim whitespace
        data.push(rowItem);
    }

    return data;
}

//Reads from the CSV files, parses it via the parseCSV function, and returns true of false if a match is found with the domain input
function readCSV(file, domain) {
    return fetch(file)
        .then(response => response.text())
        .then(csvString => {
            const data = parseCSV(csvString);

            for (let i = 0; i < data.length; i++) {
                if (domain === data[i][0]) {

                    return Promise.resolve(false);
                }
            }
            return Promise.resolve(true);
        });
}

//Checks if the email is in a valid format and if the domain matches banned domains
async function checkEmail(event) {
    event.preventDefault();

    const formData = new FormData(document.getElementById('theForm'));
    const emailFromTheForm = formData.get('email');

    let isValid = true;

    if (emailFromTheForm.trim() === '') {
        isValid = false;
    } else {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        isValid = emailRegex.test(emailFromTheForm);
    }

    if (isValid) {
        const domain = emailFromTheForm.split('@')[1];

        const isSuperValid = await readCSV('../static_assets/domains.csv', domain);

        if (isSuperValid) {
            const validatedEmail = emailFromTheForm.trim();
            await sessionStorage.setItem("validatedEmail", validatedEmail);
            window.location.assign("../static_assets/paidUser.html");
        } else {
            alert("Please enter your company email address.\n\nNo personal email addresses.");
        }
    }
    else {
        alert("Please enter your company email address.");
    }
}

//Displays the email input form
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
