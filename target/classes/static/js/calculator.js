$(document).ready(function(){
	console.log(JSON.stringify('1+3'));
	
	var $clear = $('#clear'),
		$display = $('#display');
		
	
	$('.field').on('mousedown', function(){
		$(this).css({
			'background-color': 'hsla(0,100%,0%,0.25)'
		})
	}).on('mouseup', function() {
		$(this).css({
			'background-color': 'hsla(0,100%,0%,0.15)'
		});
	});
	
	$('.append').on('click', function() {
		$display.val($display.val() + $(this).text());
	});
	
	$('#clear').on('click', function() {
		$display.val('');
	});
	
	$('#equals').on('click', function() {
		$.ajax({
			url: "/calc",
			type: 'POST',
			contentType: 'application/json',
			data: $display.val()
		}).done(function(result) {
			$display.val(result);
		});
	});
	
	$('#nextLine').on('click', function() {
		$display.val($display.val() + ',\n');
	});
});