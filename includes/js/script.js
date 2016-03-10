
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
	
});
	
	
