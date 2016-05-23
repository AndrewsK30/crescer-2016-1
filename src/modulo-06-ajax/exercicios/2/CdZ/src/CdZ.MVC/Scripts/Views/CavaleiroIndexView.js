'use strict';
//TODO:Refactory
function CavaleiroIndexView(options) {
    options = options || {};
    this.errorToast = options.errorToast;
    this.successToast = options.successToast;
    this.cavaleirosUi = options.cavaleirosUi;
    this.cavaleiros = new Cavaleiros({
        urlGet: options.urlCavaleiroGet,
        urlGetById: options.urlCavaleiroGetById,
        urlPost: options.urlCavaleiroPost,
        urlDelete: options.urlCavaleiroDelete,
        urlPut: options.urlCavaleiroPut
    });
    this.numCavaleiros = [];
    this.pagina = 0;
    this.numDecavaleirosNovos = 0;
    this.botaoForm = options.cavaleroBotaoForm;
    this.inputsImagens = options.inputsImagens;
    this.inputsGolpes = options.inputsGolpes;
    this.formCadastro = options.formCadastro;
    this.atualizar = false;
};

CavaleiroIndexView.prototype.addCavaleiro = function (id) {
    this.numCavaleiros.push(id);
}

CavaleiroIndexView.prototype.cavaleiroJaExistente = function (id) {
    return this.numCavaleiros.indexOf(id) === -1
}



CavaleiroIndexView.prototype.anteriorPagina = function () {
    if (this.pagina > 0) {
        this.pagina--;
        this.mudarPagina();
    } 
    
}
CavaleiroIndexView.prototype.proximaPagina = function () {
    this.pagina++;
    this.mudarPagina();
}
CavaleiroIndexView.prototype.mudarPagina = function () {
    this.cavaleirosUi.find("tr:not(:first)").remove();
    this.numCavaleiros = [];   
    this.updateView();
}



CavaleiroIndexView.prototype.updateView = function () {
var self = this;

    this.cavaleiros.paginado(self.pagina)
    .then(
        function onSuccess(res) {
            var cavaleirosFiltrados = res.data.filter(function (cavaleiro) {
                return self.cavaleiroJaExistente(cavaleiro.Id)
            });
            cavaleirosFiltrados.forEach(function (cava) {
                self.addCavaleiro(cava.Id);
                self.cavaleirosUi.append(
                    self.criarHtmlCavaleiro(cava)
                );
            });
            var totalCavaleiros = cavaleirosFiltrados.length;
            if (totalCavaleiros > 0)
                this.numDecavaleirosNovos += totalCavaleiros;
        },
        function onError(res) {
            self.errorToast.show(res.status + ' - ' + res.statusText);
        }
    );
}

CavaleiroIndexView.prototype.notificacaoUpdateView = function () {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var options = {
                body: this.numDecavaleirosNovos + (this.numDecavaleirosNovos === 1 ? ' novo cavaleiro foi adicionado' : ' novos cavaleiros foram adicionados!'),
                icon: 'http://i68.servimg.com/u/f68/13/28/07/38/icon10.png'
            }
            new Notification('', options);
            this.numDecavaleirosNovos = 0;
        }
    });
};

CavaleiroIndexView.prototype.bindBtnCriar = function () {
    var self = this;
    // 2 - Registra evento de clique para inserção do cavaleiro fake
    // TODO - remover quando colocar o bind dos campos do formulário
    $('#btnCriar').click(function () {
        self.cavaleiros.inserir(cavaleiroHardCoded).done(function (res) {
            // Aqui estamos otendo os detalhes atualizados do cavaleiro recém inserido.
            // Notem o custo de fazer toda separação conceitual (uma action para cada tipo de operação no banco, etc).
            // Poderíamos ter retornado no resultado do POST a entidade atualizada invés de apenas o id, concordam?
            self.cavaleiros.buscar(res.id)
                .done(function (detalhe) {
                    cavaleiroHardCoded = detalhe.data;
                });
        });
    });
};

CavaleiroIndexView.prototype.criarHtmlCavaleiro = function (cava) {
    var imagethumb =  cava.Imagens.filter(function(item){
        return item.IsThumb
    });
    var imagem = imagethumb.length === 0 ? 'http://kicell.com/arq/wallpaper/1/KICELL_WALLPAPER_W394B30E75E7F9948339_128X128.jpg' :
                                           imagethumb[0].Url;
    var botaoExcluir = $('<button>');
    var popUpContent = $('<div>').addClass('col-md-12').attr('title', cava.nome);
    var data = new Date(cava.DataNascimento);
        popUpContent.append(
        $('<p>').text('AlturaCm: '+cava.AlturaCm),
        $('<p>').text('PesoLb: ' + cava.PesoLb),
        $('<p>').text('Data de Nascimento: ' + data.getDate() + '/' + data.getMonth() + '/' + data.getFullYear()),
        $('<p>').text('Signo: ' + cava.StringSigno),
        $('<p>').text('Tipo sanguineo: ' + cava.StringTipoSanguineo),
        $('<p>').text('Local de nascimento: ' + cava.LocalNascimento.Texto),
        $('<p>').text('Local de treinamento: ' + cava.LocalTreinamento.Texto)
        );
        $.each(cava.Golpes, function (index) {
            popUpContent.append(
                 $('<p>').text('Golpe ' + (index+1)+ ': ' + this.Nome)
            );
        });
    return $('<tr>')
        .append(
         $('<th>').text(cava.Nome)
         ).append(
         $('<th>').append(
            $('<img>').attr('src', imagem).click(function () {
                popUpContent.dialog();
            })
            )
         ).append(
          $('<th>').append(
                $('<button>')
                .on('click', { id: cava.Id, self: this, submit:this.botaoForm }, this.editarCavaleiroNoServidor)
                .text('Editar').addClass('btn btn-primary')
         ).append(
                botaoExcluir
                .on('click', {
                    id: cava.Id, self: this, button: botaoExcluir
                }, this.excluirCavaleiroNoServidor)
                .text('Excluir').addClass('btn btn-primary')
            
        ));
};

CavaleiroIndexView.prototype.adicionarImageView = function (valor,isThumb,IdValue) {
    var inputValor = valor || '';
    var checkBox = isThumb || false;
    var imagemId = IdValue || '0';

    this.inputsImagens
            .append(
                    $('<p>').append(
                        $('<button>')
                       .addClass('btn btn-danger btn-sm')
                       .text('Remover:')
                       .click(function () {
                           var pai = $(this).parent()
                           pai.next().next().remove();
                           pai.next().remove();
                           pai.remove();
                       })
            )
            ).append(
                $('<input>')
                .addClass('input-adicionar-imagens form-control')
                .attr('type', 'text')
                .val(inputValor)
                .attr("data-id-imagem", imagemId)
            ).append(
                $('<label>').text('É thumbnail?')
                .append(
                    $('<input>')
                    .attr('type', 'checkbox')
                    .attr('value', 'true')
                    .attr('checked', checkBox)
                )
            );
}

CavaleiroIndexView.prototype.adicionarGolpesView = function (valor,idGolpe) {
    var inputValor = valor || '';
    var idDoGolpe = idGolpe || '0';
    this.inputsGolpes.append(
        $('<p>').append(
            $('<button>')
            .addClass('btn btn-danger btn-sm')
            .text('Remover:')
            .click(function () {
                var pai = $(this).parent();
                pai.next().remove();
                pai.remove();
            })
       )
    ).append(
        $('<input>')
        .addClass('input-adicionar-golpes form-control')
        .attr('type', 'text')
        .val(inputValor).attr("data-id-golpe", idDoGolpe)
        
    );
}

CavaleiroIndexView.prototype.excluirCavaleiroNoServidor = function (e) {
    // dispensamos o uso do atributo 'data-cavaleiro-id' utilizando event.data:
    // pirou? rtfm => http://api.jquery.com/event.data/
    var btnExcluir= $(this);
    var self = e.data.self;
    self.cavaleiros.excluir(e.data.id)
        .done(function (res) {            
            btnExcluir.parent().parent().remove();
            self.successToast.show('Excluído com sucesso!');
        });
};

CavaleiroIndexView.prototype.trocarDeContextoForm = function (configs) {
    this.formCadastro.unbind("submit").submit(configs, this.salvarCavaleiroNoServidor);
};

CavaleiroIndexView.prototype.editarCavaleiroNoServidor = function(e) {
    var cavaleiroId = e.data.id;
    var self = e.data.self;   
    var botaoSubmit = e.data.submit;
    self.cavaleiros.buscar(cavaleiroId)
        .done(function (detalhe) {
            //TODO: desengessar
            var configs = { tipoDeSubmit: 'atualizar', id: detalhe.data.id};
            botaoSubmit.text('Atualizar');
           $('#txtNomeCavaleiro').val(detalhe.data.Nome);
           $('#slTipoSanguineo').val(detalhe.data.TipoSanguineo).change();
           $('#txtPeso').val(detalhe.data.PesoLb);
           $('#txtAltura').val(detalhe.data.AlturaCm);
           var Data = new Date(detalhe.data.DataNascimento);
           $('#txtNascimento').val(Data.getDay() + '/' + Data.getMonth() + '/' + Data.getFullYear());
           $('#txtLocalNascimento').val(detalhe.data.LocalNascimento.Texto)
           $('#txtLocaTreinamento').val(detalhe.data.LocalTreinamento.Texto)
           $('#slSigno').val(detalhe.data.Signo).change();
          
           $.each(detalhe.data.Golpes, function () {
               self.adicionarGolpesView(this.Nome,this.Id);
           });

           $.each(detalhe.data.Imagens,function () {
               self.adicionarImageView(this.Url, this.IsThumb, this.Id);
           });

            //TODO:Terminar atulizar, e com isso Trocar de contexto.
            self.trocarDeContextoForm(configs);
        });
};

CavaleiroIndexView.prototype.salvarCavaleiroNoServidor = function (e) {
    var dados = (typeof e === 'undefined') ? null :
                e.data;
    var nome = $('#txtNomeCavaleiro').val()
         , tipoSanquineo = $('#slTipoSanguineo').val()
         , peso = $('#txtPeso').val()
         , altura = $('#txtAltura').val()
         , datanascimento = $('#txtNascimento').val().split('/')
         , localNascimento = $('#txtLocalNascimento').val()
         , localTreinamento = $('#txtLocaTreinamento').val()
         , signo = $('#slSigno').val()
         , imagens = []
         , golpes = [];
    $('.input-adicionar-imagens').each(function () {
        imagens.push({
            url: $(this).val()
            , isThumb: $(this).next().children().is(':checked')
        });

        $(this).next().remove();
        $(this).remove();
    });

    $('.input-adicionar-golpes').each(function () {
        golpes.push({ Nome: $(this).val() });
        $(this).remove()
    });

    var mandar = {
        Nome: nome
            , DataNascimento: new Date(Date.UTC(datanascimento[2], datanascimento[1], datanascimento[0])).toISOString()
            , AlturaCm: JSON.stringify(altura * 100)
            , PesoLb: JSON.stringify(peso * 2.20462)
            , signo: signo
            , TipoSanguineo: tipoSanquineo
            , LocalNascimento: { Texto: localNascimento }
            , localTreinamento: { Texto: localTreinamento }
            , Golpes: golpes
            , imagens: imagens
    };
    if (dados != null && e.data.tipoDeSubmit === 'atualizar') {
        mandar.Id = e.data.Id;
    } else {
        ViewCavaleiros.cavaleiros.inserir(mandar);
    }

   
    return e.preventDefault();
}




// TODO: remover cavaleiro hard-coded quando fizer bind do formulário.
var cavaleiroHardCoded = {
    Nome: 'Xiru ' + new Date().getTime(),
    AlturaCm: 187,
    Signo: 7,
    TipoSanguineo: 1,
    // Estamos enviando a data UTC (sem timezone) para que seja corretamente armazenada e posteriormente exibida de acordo com o fuso-horário da aplicação cliente que consumir os dados
    DataNascimento: new Date(Date.UTC(2001, 1, 15)).toISOString(),
    Golpes: [{ Nome: 'Cólera do Dragão' }, { Nome: 'Cólera dos 100 dragões' }],
    LocalNascimento: {
        Texto: 'Beijing'
    },
    LocalTreinamento: {
        Texto: '5 picos de rosan'
    },
    Imagens: [{
        Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
        IsThumb: true
    }, {
        Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
        IsThumb: false
    }]
};

// TODO: Implementar atualização a partir de um formulário ou campos na tela, e não hard-coded
function simularAtualizacaoHardCoded() {
    cavaleiroHardCoded.Nome = 'Novo nome após update ' + new Date().getTime();
    cavaleiroHardCoded.AlturaCm = 205;
    cavaleiroHardCoded.Signo = 3;
    cavaleiroHardCoded.TipoSanguineo = 2;
    // Estamos enviando a data UTC (sem timezone) para que seja corretamente armazenada e posteriormente exibida de acordo com o fuso-horário da aplicação cliente que consumir os dados
    cavaleiroHardCoded.DataNascimento = new Date(Date.UTC(2010, 9, 10)).toISOString();
    if (cavaleiroHardCoded.Golpes.length > 0) {
        cavaleiroHardCoded.Golpes[0] = cavaleiroHardCoded.Golpes[0] || {};
        cavaleiroHardCoded.Golpes[0].Nome = 'Voadora do Sub-Zero Brasileiro'
        cavaleiroHardCoded.Golpes[1] = cavaleiroHardCoded.Golpes[1] || {};
        cavaleiroHardCoded.Golpes[1].Nome = 'Cólera dos 42 dragões';
        cavaleiroHardCoded.Golpes[2] = { Nome: 'Novo golpe aterrador' };
    }
    cavaleiroHardCoded.LocalNascimento.Texto = 'Porto Alegre';
    cavaleiroHardCoded.LocalTreinamento.Texto = 'Alvorada';
    if (cavaleiroHardCoded.Imagens.length > 0) {
        cavaleiroHardCoded.Imagens[0] = cavaleiroHardCoded.Imagens[0] || {};
        cavaleiroHardCoded.Imagens[0].Url = 'https://cloud.githubusercontent.com/assets/526075/15443404/5c97dde6-1ebe-11e6-8ae6-83372051dda7.png';
        cavaleiroHardCoded.Imagens[0].IsThumb = true;
        cavaleiroHardCoded.Imagens[1] = cavaleiroHardCoded.Imagens[1] || {};
        cavaleiroHardCoded.Imagens[1].Url = 'https://cloud.githubusercontent.com/assets/526075/15443410/6e9ba586-1ebe-11e6-8b90-64aca9e18a32.png';
        cavaleiroHardCoded.Imagens[1].IsThumb = false;
    }
};