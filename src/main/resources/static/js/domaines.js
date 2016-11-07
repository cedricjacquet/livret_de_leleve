
$(document).ready(function () {
	
	$.get("/lde/cycles/" + cycleId + "/domaines/"+ domaineId + "/sousdomaines/", function(data) {
	    var $this = $("#sousdomainesCollections");
	    var items = [];
	    $.each(data, function(i, item) {
	    	 items.push('<li class="collection-item"><div>'+item.nom+'<a href="#" class="secondary-content"><i class="material-icons">send</i></a></div></li>');	
	    });
	    $this.append( items.join('') );
	});
	
	
});