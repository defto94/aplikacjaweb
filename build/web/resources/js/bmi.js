function ClearForm(form) {
    form.weight.value = "";
    form.height.value = "";
    form.bmi.value = "";
    form.my_comment.value = "";
}
function bmi(weight, height) {
    bmindx = weight / eval(height * height);
    return bmindx;
}
function checkform(form) {
    if (form.weight.value == null || form.weight.value.length == 0 || form.height.value == null || form.height.value.length == 0) {
        alert("\n Wypełnij formularz.");
        return false;
    } else if (parseFloat(form.height.value) <= 0 ||
            parseFloat(form.height.value) >= 300 ||
            parseFloat(form.weight.value) <= 0 ||
            parseFloat(form.weight.value) >= 300) {
        alert("\nCoś poszło nie tak \nWpisz wartości jeszcze raz. \nWagę w kilogramach and \n wzrost w centymetrach");
        ClearForm(form);
        return false;
    }
    return true;

}
function computeform(form) {
    if (checkform(form)) {

        yourbmi = Math.round(bmi(form.weight.value, form.height.value / 100));
        form.bmi.value = yourbmi;
        if (yourbmi > 50) {
            form.my_comment.value = "Otyłość IV stopnia! (skrajna) Potrzebujesz hospitalizacji.";
        } else if (yourbmi > 40 && yourbmi <= 50) {
            form.my_comment.value = "Otyłość III stopnia! (śmiertelna) Potrzebujesz hospitalizacji.";
        } else if (yourbmi > 35 && yourbmi <= 40) {
            form.my_comment.value = "Otyłość II stopnia! Skonsultuj się ze specjalistą.";
        } else if (yourbmi > 30 && yourbmi <= 35) {
            form.my_comment.value = "Otyłość I stopnia! Skonsultuj się ze specjalistą i osiągnij zdrową wagę. ";
        } else if (yourbmi >= 27 && yourbmi <= 30) {
            form.my_comment.value = "Masz nadwagę II stopnia. Skonsutuj się ze specjalistą i osiągnij zdrową wagę.";
        } else if (yourbmi >= 25 && yourbmi < 27) {
            form.my_comment.value = "Masz nadwagę I stopnia. Skonsutuj się ze specjalistą i osiągnij zdrową wagę.";
        } else if (yourbmi >= 18  && yourbmi < 25) {
            form.my_comment.value = "Masz zdrową wagę. Tak trzymaj.";
        } else if (yourbmi<18) {
            form.my_comment.value = "Niedowaga! Skonsultuj się ze specjalistą.";  
        } else {
            form.my_comment.value = "Wprowadź prawidłowy wzrost i wagę. ";
        }
    }
    return;
}
