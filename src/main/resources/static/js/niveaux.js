
$(document).ready(function () {
	
	$.get("/lde/cycles/" + cycleId + "/niveaux/"+niveauId+ "/eleves", function(data) {
	    var $this = $("#elevesCollections");
	    var items = [];
	    $.each(data, function(i, item) {
	    	 items.push('<li class="collection-item"><div>'+item.prenom+' '+item.nom+'<a href="#" class="secondary-content"><i class="material-icons">send</i></a></div></li>');	
	    });
	    $this.append( items.join('') );
	});
	
	
});