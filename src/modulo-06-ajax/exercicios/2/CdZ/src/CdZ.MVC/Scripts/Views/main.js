'use strict'
ViewCavaleiros.updateView();
ViewCavaleiros.bindBtnCriar();

setInterval(function () { ViewCavaleiros.updateView(); }, 5000);

$('.anterior').click(function () {
    ViewCavaleiros.anteriorPagina();
});

$('.proximo').click(function () {
    ViewCavaleiros.proximaPagina();
});

$('#btn-adicionar-img').click(function () {
    ViewCavaleiros.adicionarImageView();
});

$('#btn-adicionar-golpe').click(function () {
    ViewCavaleiros.adicionarGolpesView();
});


