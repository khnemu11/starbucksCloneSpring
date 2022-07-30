$(document).ready(function(){
	if($('.tasting_notes p').text() == ""){
		$('.tasting_notes').remove();
	}
	if($('.enjoy_with p').text() == ""){
		$('.enjoy_with').remove();
	}
	if($('.processing_method p').text() == ""){
		$('.processing_method').remove();
	}
	
})