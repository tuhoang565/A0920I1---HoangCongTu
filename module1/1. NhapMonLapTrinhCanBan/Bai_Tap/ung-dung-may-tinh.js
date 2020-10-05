let firstNum = parseFloat(document.getElementById("firstNum").value);
let secondNum = parseFloat(document.getElementById("secondNum").value);
let result = document.getElementById("result");

function addition(firstNum, secondNum, result ) {
    result.value = firstNum + secondNum;
}

function subtraction() {
    result.value = firstNum - secondNum;
}

function multiplication() {
    result.value = firstNum * secondNum;
}

function division() {
    result.value = firstNum/secondNum;
}