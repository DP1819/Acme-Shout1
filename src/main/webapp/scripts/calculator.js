function calculator() {
	var x1 = Number(document.getElementById('x').value);
	var y1 = Number(document.getElementById('y').value);
	var op = document.getElementById('operator').value;
	var res;
	if (op == "+") {
		res = x1 + y1;
	} else if (op == "-") {
		res = x1 - y1;
	} else if (op == "*") {
		res = x1 * y1;
	} else if (op == "/") {
		res = x1 / y1;
	} else {
		res = "---";
	}
	document.getElementById('result').innerHTML = res;
}
