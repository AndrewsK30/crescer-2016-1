"use strict"

function listaAlbunsPorId(id) {
     var $elementoAppend = $('#lista-albuns');
    var request = $.ajax({
        url: 'https://api.spotify.com/v1/artists/' + id + '/albums'
        , method: "GET"
        , data: {
            limit: 50
        }
        , dataType: "json"
        , async: true
    });

    request.then(
        function onSuccess(res) {           
            $elementoAppend.empty();
            (function carregaImg(indice) {                
                var imgAlbum = new Image();
                imgAlbum.src = res.items[indice].images[2].url;
                imgAlbum.onload = function () {
                    $('<a>').attr('href', res.items[indice].external_urls.spotify).text('Link spotify').insertAfter(
                        $('<h4>').addClass('media-heading').text(res.items[indice].name).appendTo(
                            $('<div>').addClass('media-body').insertAfter(
                                $(imgAlbum).addClass('media-object pull-left').appendTo(
                                    $('<li>').addClass("media").appendTo(
                                        $elementoAppend
                                    )
                                )
                            )
                        )
                    );
                    if (indice < res.items.length - 1) carregaImg(indice + 1);
                };
            })(0);
        }
        , function onError(res) {
            $elementoAppend.append($('<li>').text('Caro usuário, devido a um erro '+res.status+' não foi possível pesquisar por '+ id));
            
        }
    );
}
