
$(function () {

    $('#buttonModal').click(function () {
        $('#myModal').modal('show');


    });
    //popover
    $(function () {
        $('[data-toggle="popover"]').popover();
    });


    $("#glownaBody a:contains('Start')").parent().addClass('active');
    $("#kontaktBody a:contains('Kontakt')").parent().addClass('active');

    //wysuwane menu jako hover
    $('ul.nav li.dropdown').hover(function () {

        $('.dropdown-menu', this).fadeIn();

    }, function () {

        $('.dropdown-menu', this).fadeOut('fast');

    });
    
    $("#sendAlert").click(function() {
        $("#contactForm").submit(); 
        alert("Dziękujemy za wysłanie maila. Wkrótce otrzymasz odpowiedź.");
    });


    //strzałka w górę

    $(document).ready(function () {
        $('#upArray').hide();

        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $('#upArray').fadeIn(500);
            } else {
                $('#upArray').fadeOut(500);
            }
        });
        $('#upArray').click(function () {
            $('html, body').animate({scrollTop: 0}, 1000);
            return false;
        });
    });
});









