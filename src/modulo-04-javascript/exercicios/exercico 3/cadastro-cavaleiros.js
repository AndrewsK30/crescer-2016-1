'use strict';

$('#btnGolpe').click(function(){
    $('#form-imgs')
    .append(
        $('<input>')
        .addClass('input-imagens form-control')
        .attr('type','text');
    );
});


$(function() {
  var $frmNovoCavaleiro = $('#frmNovoCavaleiro');
  $frmNovoCavaleiro.submit(function(e) {
    console.log($(this));
    console.log($frmNovoCavaleiro.serialize());
    var nome = $('#txtNomeCavaleiro').val();
    var urlImagem = $('#txtUrlImagem').val();
    $('#cavaleiros')
      .append(
        $('<li>').append(
          $('<img>').attr('src', urlImagem).fadeIn()
        )
      );

    goldSaints.push({
      nome: nome,
      imagens: [
        { url: urlImagem, isThumb: true }
      ]
    });

    localStorage['cavaleiros'] = JSON.stringify(goldSaints);

    return e.preventDefault();
  });

  // Carregando imagens sequencialmente na ordem, de forma recursiva.
  // No carregamento já registramos o evento de click na imagem para exibir os detalhes do cavaleiro.

  (function carregaImg(indice) {
    var $detalhesCavaleiro = $('#detalhes-cavaleiro');
    var cavaleiro = goldSaints[indice];
    var imgCavaleiro = new Image();
    imgCavaleiro.src = cavaleiro.imagens[0].url;
    imgCavaleiro.alt = cavaleiro.nome;
    imgCavaleiro.id = cavaleiro.id;
    imgCavaleiro.onload = function() {
      var $img = $(imgCavaleiro);
      $img.appendTo($('<li>').appendTo($('#cavaleiros'))).fadeIn();
      $img.on('click', function() {
        var self = $(this);
        var nome = self.attr('alt');
        var altura = goldSaints.filter(function(elem) {
          return elem.id === parseInt(self.attr('id'));
        })[0].alturaCm;        
        $detalhesCavaleiro.children().detach();
        $detalhesCavaleiro.append($('<h3>').text( nome ));
        $detalhesCavaleiro.append($('<h3>').text( altura / 100 ));
      });
      if (indice < goldSaints.length - 1) carregaImg(indice + 1);  
    };
  })(0);    

});
