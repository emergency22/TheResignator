import { QuitClient }  from './quitClient.js';
const quitClient = new QuitClient();

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
            const email = formData.get('email');

            const domain = email.split('@')[1];

            const isSuperValid = readCSV('../static_assets/domains.csv', domain);

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

            <input type="submit" value="That's it. I quit!" class="btn btn-success" onClick="confirmQuit(event)">
        </div>`;
}

document.addEventListener('DOMContentLoaded', function() {
    displayForm();

    const submitButton = document.querySelector('.btn.btn-success');
    submitButton.addEventListener('click', confirmQuit);
});

    function parseCSV(csv) {
        const rows = csv.split('\n')
        const data = []
        for (let i=0; i < lines.length; i++) {
            const rowItem =  rows[i];
            data.push(rowItem);
        }
        return data;
    }

    function readCSV(file, domain) {
        fetch(file)
            .then(response => response.text())
            .then(csvString => {
                const data = parseCSV(csv);
                console.log(data);

                for(let i=0; i < data.length; i++) {
                    if (domain === data[i]) {
                        console.log("Domain found!");
                        return false;
                    }
                }
            })
        return true;
    }