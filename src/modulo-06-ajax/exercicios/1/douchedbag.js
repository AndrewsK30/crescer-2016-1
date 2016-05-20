"use strict"

$("#form-procura-artista").submit(function (e) {
    var valorDado = $("#input-procura-artista").val();
    if(valorDado.toLocaleLowerCase() === 'justin bieber' && Math.floor(Math.random() < 0.21)){
        listaAlbunsPorId('douchebag');
    }else{
    $.ajax({
            url: 'https://api.spotify.com/v1/search'
            , method: 'GET'
            , data: {
                q: valorDado
                , type : 'artist'
            }
            , dataType: "json"
            , async: true
        })
        .then(
            function onSuccess(res) {
                var id = listaAlbunsPorId(res.artists.items[0].id);
                
            }
        );
    }
    return e.preventDefault();
});