$(function() {
goldSaints.forEach(function(e) {
      var $imgMu = $('<img>')
        .attr('src', e.imagens[0].url)
        .attr('alt', e.nome);
      $('#cavaleiros').append( $('<li>').append($imgMu) );
    });
});