/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function textoMayuscula(cObj) {
    cObj.value = cObj.value.toUpperCase();
}

function textoMinuscula(cObj) {
    cObj.value = cObj.value.toLowerCase();
}

function numeros(evt, decimal) {
    var theEvent = evt || window.event;
    var key = theEvent.keyCode || theEvent.which;
    key = String.fromCharCode(key);
    var regex;
    if (decimal) {
        regex = /[0-9]/;
    } else {
        regex = /[0-9]|\./;
    }
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }
}

function traferirFoco() {
    var theEvent = evt || window.event;
    var key = theEvent.keyCode || theEvent.which;
    
    if (theEvent && key == 13) {
        alert('tranferir');
        key = 9;
    }
}