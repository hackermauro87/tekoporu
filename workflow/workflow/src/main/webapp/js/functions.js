	
function setAllSelected(id) {
	document.getElementById(id).selectionStart = 0;
	document.getElementById(id).selectionEnd = document.getElementById(id).value.length;

}