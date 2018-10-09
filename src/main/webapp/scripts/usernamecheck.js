function usernamecheckFunction(username) {
	var checked = document.getElementById('usernamecheck').checked;
	var usernameInput = document.getElementById('username');
	if (checked) {
		usernameInput.disabled = false;
		usernameInput.value = '';
	} else {
		usernameInput.value = username;
		usernameInput.disabled = true;
	}
}
