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

    for (const fieldId in fields) {
        if (fields.hasOwnProperty(fieldId)) {
            const fieldValue = document.getElementById(fieldId).value;
            const errorMessage = fields[fieldId];

            if (!fieldValue) {
                alert(errorMessage);
                return false;
            }
            if (fieldId === "inputEmail" && !fieldValue.includes('@')) {
                alert('Please enter a valid e-mail address.');
                return false;
            }
            if (fieldId === 'inputPassword' && fieldValue.length < 8) {
                alert('Password must be at least 8 characters long.');
                return false;
            }
            if (fieldId === 'inputPhone' && !/^\d{10}$/.test(fieldValue)) {
                alert('Phone number is in wrong format.');
                return false;
            }
            if (fieldId === 'inputZip' && !/^\d{5}$/.test(fieldValue)) {
                alert('Zip code is not in valid format.');
                return false;
            }
        }
    }
    return true;
}

// Táto funkcia sa volá, keď sa pokúšaš odoslať registračný formulár
function submitRegistrationForm() {

    // Volá funkciu checkRegistrationForm, ktorá overuje, či sú všetky polia formulára správne vyplnené
    if (!checkRegistrationForm()) {
        return false;
    }

    // Pokračuje v spracovaní, ak prešiel validáciou formulára
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

    // Tu sa vykoná AJAX volanie na serverový endpoint '/user/registerUser'
    fetch('/user/registerUser', {
        method: 'POST', // Metóda HTTP požiadavky je POST
        headers: {
            'Content-Type': 'application/json', // Hlavička nastavuje typ obsahu na JSON
        },
        body: JSON.stringify(user) // Telo požiadavky obsahuje JSON reprezentáciu objektu user
    })
        .then(response => {
            // Táto časť sa spustí, keď server odpovie na požiadavku
            if (!response.ok) {
                // Ak server vrátil chybový stav, zaloguje sa chyba a skončí spracovanie
                console.error('Server returned an error response');
                return;
            }
            // Ak server vrátil úspešný stav, prevedie sa odpoveď na JSON
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
            // Táto časť sa spustí, keď sa úspešne prevedie odpoveď na JSON
            console.log('Success:', data); // Zaloguje sa úspešná odpoveď
        })
        .catch((error) => {
            // Ak nastane chyba počas odosielania alebo spracovania požiadavky, zaloguje sa chyba
            console.error('Error:', error);
        });

    // Zabraňuje štandardnému spracovaniu odoslania formulára (čo by obnovilo stránku)
    return false;
}