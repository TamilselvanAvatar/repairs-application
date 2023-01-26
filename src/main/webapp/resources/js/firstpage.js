function show(shown,hidden){

document.getElementById(shown).style.display = "block";
document.getElementById(hidden).style.display = "none";
return "false";
}


/*
function validation() {
	var name = document.getElementById("name").value;
	var number = document.getElementById("number").value;
	var location = document.getElementById("location").value;

	if (name.length >= 3 && name.length < 15 && name == ("/^[a-ZA-Z]+ [\s]{0,} [a-zA-Z]* $/" ) && name != "") {
		if (number >= 6000000000 && number <= 9999999999) {
			if (location.length >= 3 && location == ("[a-zA-Z]{3,}")) {
				return "true";
			}
			else {
				alert("Invalid Location");
				return "false";
			}
		}
		else {
			alert("Invalid Phone Number");
			return "false";
		}
	}
	else {
		alert("Invalid Name");
		return "false";
	}


	/*if (name == "" || name.length <= 2))) {
		alert("Invalid Name");
		return false;
	}
	if (!isNaN(name)) {
		alert("Name should not be number");
		return false;
	}


	if (name.length > 15) {
		alert("Name character should never exceed 15");
		return false;
	}

	if (isNaN(number)) {
		alert("Invalid Number");
		return false;
	}

	if (number.length != 10 || number.length < 10 || number == "" || ) {
		alert("Invalid Number");
		return false;
	}

	if (location == "" || location.length <= 3) {
		alert("Invalid Location");
		return false;
	}

	if (!isNaN(location)) {
		alert("Location should not be number");
		return false;
	}
*/




