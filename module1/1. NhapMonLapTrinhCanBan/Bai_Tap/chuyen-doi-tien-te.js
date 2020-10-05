

function covertCurrency() {
    let amount = parseFloat(document.getElementById("amount").value);
    let currencyFrom = document.getElementById("currencyFrom");
    let currencyTo = document.getElementById("currencyTo");
    let result = document.getElementById("result");

    if(currencyFrom.value == "vnd" && currencyTo.value == "usd"){
        result.value = amount/23000;
    }else if (currencyFrom.value == "vnd" && currencyTo.value == "eur"){
        result.value = amount/27000;
    }else if (currencyFrom.value == "usd" && currencyTo.value == "vnd"){
        result.value = amount*23000;
    }else if (currencyFrom.value == "usd" && currencyTo.value == "eur"){
        result.value = amount*0.85;
    }else if(currencyFrom.value == "eur" && currencyTo.value == "usd"){
        result.value = amount*1.17;
    }else {
        result.value = amount*27000;
    }
}