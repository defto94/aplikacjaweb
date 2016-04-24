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
        if (yourbmi > 40) {
            form.my_comment.value = "Otyłość! Potrzebujesz hospitalizacji.";
        } else if (yourbmi > 30 && yourbmi <= 40) {
            form.my_comment.value = "Nadwaga! Zacznij ćwiczyć i skonsultuj się ze specjalistą.";
        } else if (yourbmi > 27 && yourbmi <= 30) {
            form.my_comment.value = "Nadwaga! Zacznij ćwiczyć - osiągnij zdrową wagę dla swojego organizmu!";
        } else if (yourbmi > 22 && yourbmi <= 27) {
            form.my_comment.value = "Nie jest źle, jednak masz kilka kilogramów za dużo. ";
        } else if (yourbmi >= 21 && yourbmi <= 22) {
            form.my_comment.value = "Masz odpowiednią wagę. Tak trzymaj.";
        } else if (yourbmi >= 18 && yourbmi < 21) {
            form.my_comment.value = "Masz niedowagę. Zacznij jeść więcej.";
        } else if (yourbmi >= 16 && yourbmi < 18) {
            form.my_comment.value = "Twoje BMI jest poniżej normy! Skonsultuj się ze specjalistą.";
        } else if (yourbmi < 16) {
            form.my_comment.value = yourbmi + "Masz zdecydowanie zbyt niską wagę! Skonsultuj się ze specjalistą jak najszybciej. ";
        }
    }
    return;
}
