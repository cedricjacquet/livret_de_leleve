
$(document).ready(function () {
	
	$.get("/lde/cycles/" + cycleId + "/domaines/", function(data) {
	    var $this = $("#domainesCollections");
	    var items = [];
	    $.each(data, function(i, item) {
	    	 items.push('<li class="collection-item"><div>'+item.nom+'<a href="/cycles/'+ cycleId+ '/niveaux/'+ niveauId +'/eleves/' + eleveId + '/domaines/' + item.id + '" class="secondary-content"><i class="material-icons">send</i></a></div></li>');	
	    });
	    $this.append( items.join('') );
	});
	
	
});