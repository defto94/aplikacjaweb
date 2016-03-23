
$(function() {

	$('#sendAlert').click(function(e) {
	
		e.preventDefault();
		
		$('#successAlert').slideDown();
	
	});
	
	$("#glownaBody a:contains('Start')").parent().addClass('active');
	$("#kontaktBody a:contains('Kontakt')").parent().addClass('active');
	
	//wysuwane menu jako hover
	$('ul.nav li.dropdown').hover(function() {
	
		$('.dropdown-menu', this).fadeIn();
		
	}, function() {
	
		$('.dropdown-menu',this).fadeOut('fast');
	
	});
	
	//strzałka w górę
	
$(document).ready(function(){
	   $('#upArray').hide();
	   
	   $(window).scroll(function(){
		  if ($(this).scrollTop() > 100) {
			 $('#upArray').fadeIn(500);
		  }
		  else {
			 $('#upArray').fadeOut(500);
		  }
	   });
	   $('#upArray').click(function(){
		  $('html, body').animate({ scrollTop: 0 }, 1000);
		  return false;
	   });
	});
	/*
		Skrypt jQuery spełnia kilka funkcji:

	ukrywa przycisk przy załadowaniu strony,
	przy przewijaniu strony w dół wyświetla przycisk, przy powrocie do góry strony ponownie go ukrywa,
	po kliknięciu na strzałkę przewija płynnie stronę do góry.

*/
	$(document).ready(function(){
	
            $(".firstShow").click(function(){
                    $(this).hide();
                    $("#collapseExampleOne").show(300);
                    $(".firstHide").show();
                    
            });

            $(".firstHide").click(function(){
                    $(this).hide();
                    $("#collapseExampleOne").hide(300);
                    $(".firstShow").show();
            });
            
            $(".secondShow").click(function(){
                    $(this).hide();
                    $("#collapseExampleSecond").show(300);
                    $(".secondHide").show();
            });

            $(".secondHide").click(function(){
                    $(this).hide();
                    $("#collapseExampleSecond").hide(300);
                    $(".secondShow").show();
            });
	});
	
	//popover
        $(function () {
		$('[data-toggle="popover"]').popover()
	});
	
	$('#myModal').on('shown.bs.modal', function () {
		$('#inputEmailLog').focus();
	});
	
	$('#myModal2').on('shown.bs.modal', function () {
		$('#inputLoginLog').focus();
	});
	
	
	

});
	
	
