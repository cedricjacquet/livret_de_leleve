
$(document).ready(function () {
	
	$.get("/lde/cycles/" + cycleId + "/niveaux", function(data) {
	    var $this = $("#niveauxCollections");
	    var items = [];
	    $.each(data, function(i, item) {
	    	 items.push('<li class="collection-item"><div>'+item.nom+'<a href="/cycles/'+ cycleId+ '/niveaux/' + item.id + '" class="secondary-content"><i class="material-icons">send</i></a></div></li>');	
	    });
	    $this.append( items.join('') );
	});
	
	
});