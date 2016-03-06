
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
	
	//walidacja formularza
	
	
	
});
	
	
