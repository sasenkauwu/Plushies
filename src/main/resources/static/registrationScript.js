function checkRegistrationForm() {
    const fields = {
        'inputName': 'Please fill out your First Name.',
        'inputSurname': 'Please fill out your Last Name.',
        'inputEmail': 'Please fill out your E-mail.',
        'inputPhone': 'Please fill out your Phone Number.',
        'inputUsername': 'Please fill out your Username.',
        'inputPassword': 'Please fill out your Password.',
        'inputStreet': 'Please fill out your Street name.',
        'inputCity': 'Please fill out your City.',
        'inputZip': 'Please fill out your Zip code.',
        'inputCountry': 'Please fill out your Country.'
    };

    let isFormValid = true;

    for (const fieldId in fields) {
        if (fields.hasOwnProperty(fieldId)) {
            const field = document.getElementById(fieldId);
            const errorElementId = fieldId + 'Error';
            const errorElement = document.getElementById(errorElementId);
            field.classList.remove('is-invalid');
            errorElement.textContent = '';
        }
    }

    for (const fieldId in fields) {
        if (fields.hasOwnProperty(fieldId)) {
            const field = document.getElementById(fieldId);
            const fieldValue = document.getElementById(fieldId).value;
            const errorMessage = fields[fieldId];
            const errorElementId = fieldId + 'Error';
            const errorElement = document.getElementById(errorElementId);

            if (!fieldValue) {
                errorElement.textContent = errorMessage;
                field.classList.add('is-invalid');
                isFormValid = false;
            } else {
                field.classList.remove('is-invalid');
                errorElement.textContent = '';
                isFormValid = true;
            }

            if (fieldId === "inputEmail" && !fieldValue.includes('@')) {
                errorElement.textContent = 'Please enter a valid e-mail address.';
                field.classList.add('is-invalid');
                isFormValid = false;
            }
            if (fieldId === 'inputPassword' && fieldValue.length < 8) {
                errorElement.textContent = 'Password must be at least 8 characters long.';
                field.classList.add('is-invalid');
                isFormValid = false;
            }
            if (fieldId === 'inputPhone' && !/^\d{10}$/.test(fieldValue)) {
                errorElement.textContent = 'Phone number is in wrong format.';
                field.classList.add('is-invalid');
                isFormValid = false;
            }
            if (fieldId === 'inputZip' && !/^\d{5}$/.test(fieldValue)) {
                errorElement.textContent = 'Zip code is not in valid format.';
                field.classList.add('is-invalid');
                isFormValid = false;
            }
        }
    }
    if (!isFormValid) {
        return false;
    }
    return true;
}

function submitRegistrationForm() {

    if (!checkRegistrationForm()) {
        return false;
    }

    const user = {
        name: document.getElementById('inputName').value,
        surname: document.getElementById('inputSurname').value,
        email: document.getElementById('inputEmail').value,
        phoneNumber: document.getElementById('inputPhone').value,
        username: document.getElementById('inputUsername').value,
        password: document.getElementById('inputPassword').value,
        street: document.getElementById('inputStreet').value,
        city: document.getElementById('inputCity').value,
        zipCode: document.getElementById('inputZip').value,
        country: document.getElementById('inputCountry').value
    };

    fetch('/user/registerUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(user)
    })
        .then(response => {
            if (!response.ok) {
                console.error('Server returned an error response');
                return;
            }
            return response.json();
        })
        .then(data => {
            alert('Account was registered successfully!');
            document.getElementById('inputName').value = '';
            document.getElementById('inputSurname').value = '';
            document.getElementById('inputEmail').value = '';
            document.getElementById('inputPhone').value = '';
            document.getElementById('inputUsername').value = '';
            document.getElementById('inputPassword').value = '';
            document.getElementById('inputStreet').value = '';
            document.getElementById('inputCity').value = '';
            document.getElementById('inputZip').value = '';
            document.getElementById('inputCountry').value = '';

            window.location.href = '/login';
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    return false;
}

function loginUser() {
    var email = document.getElementById("inputEmail").value;
    var password = document.getElementById("inputPassword").value;

    fetch('/user/loginUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({email: email, password: password})
    })

        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Invalid email or password.');
            }
        })

        .then(data => {
            alert('You have been logged in successfully.')
            console.log(data);
            // neskor presmerovanie dokoncit window.location.href = '/home';
        })

        .catch(error => {
            console.error('Error:', error);
            alert('Invalid email or password.')
        })
    return false;
}