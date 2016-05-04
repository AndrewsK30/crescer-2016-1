'use strict';

describe('Ex 1. Doadores de sangue', function () {
    it('obterDoadores retorna cavaleiros com tipo sanguíneo O', function () {
        var doadores = JSON.parse('[{"id":5,"nome":"Aiolia","dataNascimento":"1967-08-16T03:00:00.000Z","alturaCm":185,"pesoLb":187.392923,"signo":"Leão","tipoSanguineo":"O","localNascimento":"Grécia","localTreinamento":"Santuário, Grécia","golpes":["Cápsula do Poder","Pata do Leão","Relâmpago de Plasma"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14900613/c4ba42f0-0d67-11e6-9c0e-e79c2278ab0b.png","isThumb":true}]},{"id":9,"nome":"Aiolos","dataNascimento":"1960-11-30T03:00:00.000Z","alturaCm":187,"pesoLb":187.392923,"signo":"Sagitário","tipoSanguineo":"O","localNascimento":"Grécia","localTreinamento":"Santuário, Grécia","golpes":["Trovão Atômico","Flecha da Justiça"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14901061/e5fe3b90-0d69-11e6-9a78-2449055be1fa.png","isThumb":true}]},{"id":12,"nome":"Afrodite","dataNascimento":"1965-03-10T03:00:00.000Z","alturaCm":183,"pesoLb":158.732829,"signo":"Peixes","tipoSanguineo":"O","localNascimento":"Suécia","localTreinamento":"Groelândia","golpes":["Rosas Diabólicas Reais","Rosas Piranhas","Rosa Branca"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14901259/f4a0b3ca-0d6a-11e6-89b1-59855cabc43d.png","isThumb":true}]}]');
        expect(doadores).toEqual(obterDoadores());
    });
});

describe('Ex 2. Com mais golpes', function () {
    it('obterCavaleiroComMaisGolpes  retorna cavaleiros com mais golpes', function () {
        var comMaisGolpes = JSON.parse('{"id":6,"nome":"Shaka","dataNascimento":"1967-09-19T03:00:00.000Z","alturaCm":182,"pesoLb":149.914338,"signo":"Virgem","tipoSanguineo":"AB","localNascimento":"\u00cdndia","localTreinamento":"Ganges, \u00cdndia","golpes":["Rendi\u00e7\u00e3o Divina","Ciclo das 6 Exist\u00eancias","Tesouro do C\u00e9u","Invoca\u00e7\u00e3o dos Esp\u00edritos","Ohm!","Kahn!"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900695\/4a5675dc-0d68-11e6-8396-2a775a2b0c39.png","isThumb":true}]}');
        expect(comMaisGolpes).toEqual(obterCavaleiroComMaisGolpes());
    });
});

describe('Ex 3. Mes com mais aniversarios', function () {
    it('obterMesesComMaisAniversarios retorna mes com mais Aniversários', function () {
        expect(['Março', 'Maio', 'Novembro']).toEqual(obterMesesComMaisAniversarios());
    });
});

describe('Ex 4. Altura média', function () {
    it('obterAlturaMedia retorna a altura média dos guerreiros(em metros)', function () {
        expect(1.86).toEqual(obterAlturaMedia());
    });
});

describe('Ex 5. Altura mediana', function () {
    it('obterAlturaMediana retorna a altura mediana dos guerreiros(em metros)', function () {
        expect(1.85).toEqual(obterAlturaMediana());
    });
});

describe('Ex 6. Peso médio de todos ou só de doadores', function () {
    it('obterPesoMedio retorna o peso médio dos guerreiros(em Kg)', function () {
        expect(84.27).toEqual(obterPesoMedio());
    });

    it('obterPesoMedioDoadores retorna o peso médio dos guerreiros que são doadores(em Kg)', function () {
        expect(80.67).toEqual(obterPesoMedioDoadores());
    });
});

describe('Ex 7. Obter IMC dos guerreiros', function () {
    it('obterIMC retorna o IMC dos guerreiros que tem peso registrado', function () {
        var arrayIMC = [22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5];
        expect(arrayIMC).toEqual(obterIMC());
    });
});

describe('Ex 8. Obter array com quem está acima do peso', function () {
    it('obterSobrepeso retorna um array com os guerreiros acima do peso e que tenha peso registrado', function () {
        var quemEstaAcimaDoPeso = [{
            "id": 2
            , "nome": "Aldebaran"
            , "dataNascimento": "1967-05-08T03:00:00.000Z"
            , "alturaCm": 210
            , "pesoLb": 286.600941
            , "signo": "Touro"
            , "tipoSanguineo": "B"
            , "localNascimento": "Brasil"
            , "localTreinamento": "Brasil"
            , "golpes": ["Grande Chifre"]
            , "imagens": [{
                "url": "https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900419\/dca83616-0d66-11e6-9757-8d07311e6999.png"
                , "isThumb": true
            }]
        }];
        expect(quemEstaAcimaDoPeso).toEqual(obterSobrepeso());
    });
});