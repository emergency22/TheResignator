function parseCSV(csv) {
    const rows = csv.split('\n');
    const data = [];
    for (let i = 0; i < rows.length; i++) {
        const rowItem = rows[i];
        data.push(rowItem);
    }
    return data;
}

function readCSV(file, domain) {
    return fetch(file)
        .then(response => response.text())
        .then(csvString => {
            const data = parseCSV(csvString);

            for (let i = 0; i < data.length; i++) {
                console.log(data[i]);
                if (domain === data[i]) {
                    console.log("Domain found!");
                    return Promise.resolve(false); // Reject the Promise if domain is found
                }
            }

            return Promise.resolve(true); // Resolve the Promise if domain is not found
        });
}

async function checkEmail(event) {
    event.preventDefault(); // Prevents the default form submission

    const submissionData = document.getElementById('theForm');
    const formData = new FormData(submissionData);

    const emailFromTheForm = formData.get('email');

    // Check if any field is empty
    let isValid = true;
    if (emailFromTheForm.trim() === '') {
        isValid = false;
    }

    if (isValid) {
        const domain = emailFromTheForm.split('@')[1];

        const isSuperValid = await readCSV('../static_assets/domains.csv', domain);

        if (isSuperValid) {
            window.location.assign("../static_assets/paidUser.html");
        } else {
            alert("Please enter your company email address. \n \n No personal email addresses.");
        }
    } else {
        alert("Please enter your company email address.");
    }
}

function displayForm() {
    document.getElementById('emailForm').innerHTML = "";

    document.getElementById('emailForm').innerHTML += `<div class="text-center"><form id="theForm">
        <input type="text" id="email" name="email" class="boxSize" placeholder="Enter your company email address" required><br><br>

            <input type="submit" value="That's it. I quit!" class="btn btn-success">
        </div>`;

    const submitButton = document.querySelector('.btn.btn-success');
    submitButton.addEventListener('click', checkEmail);
}

document.addEventListener('DOMContentLoaded', function () {
    displayForm();
});
