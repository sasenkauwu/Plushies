function getUser() {
    const email = document.getElementById('userEmail').value;
    fetch(`user/getUser?email=${email}`)

        .then(response => response.json())

        .then(data => {
            document.getElementById('userID').textContent = data.id;
            document.getElementById('userFirstName').textContent = data.name;
            document.getElementById('userLastName').textContent = data.surname;
            document.getElementById('userUsername').textContent = data.username;
            document.getElementById('userEmailAddress').textContent = data.email;
            document.getElementById('userPhone').textContent = data.phoneNumber;

            document.getElementById('userInfo').style.display = 'block';
            console.log(data);
        })
        .catch(error => console.error('Error:', error));
}