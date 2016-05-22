using LojaNinja.Dominio;
using LojaNinja.MVC.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using LojaNinja.Repositorio.ADO;
using LojaNinja.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;


namespace LojaNinja.MVC.Controllers
{
    public class ProdutoController : Controller
    {

        private RepositorioVendas repositorio = new RepositorioVendas();
        
        private UsuarioServico _usuarioServico;

        public ProdutoController()
        {

            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorioEF()
                );
        }

        [HttpGet]
        [LojaToken]
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }
            return RedirectToAction("Listagem");
        }

        [HttpGet]
        [LojaToken(Roles = "COMUM")]
        public ActionResult CadastrarProduto(int? id)
        {

            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new ProdutoModel()
                {
                    Id = pedido.Id,
                    DataEntrega = pedido.DataEntregaDesejada,
                    NomeCliente = pedido.NomeCliente,
                    Nome = pedido.NomeProduto,
                    ValorVenda = pedido.Valor,
                    Pagamento = pedido.TipoDePagamento,
                    Cidade = pedido.Cidade,
                    Estado = pedido.Estado

                };

                return View("CadastrarProduto", model);
            }
            else
            {
                return View("CadastrarProduto");
            }
        }

        [HttpPost]
        [LojaToken(Roles = "COMUM")]
        [ValidateAntiForgeryToken]
        public ActionResult SalvarProduto(ProdutoModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(model.Id.GetValueOrDefault(), model.DataEntrega, model.Nome, model.ValorVenda, model.Pagamento, model.NomeCliente, model.Cidade, model.Estado);

                    if (model.Id.HasValue)
                    {
                        repositorio.AtualizarPedido(pedido);
                        ViewBag.Mensagem = "Atualizado com sucesso";
                    }
                    else
                    {
                        repositorio.IncluirPedido(pedido);
                        ViewBag.Mensagem = "Salvo com sucesso";                        
                    }
                    return View("Sucesso");
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("CadastrarProduto", model);
                }
                
            }
            else
            {
                return View("CadastrarProduto", model);
            }

        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Cadastrar(UsuarioModel usuarioModel)
        {
            if (ModelState.IsValid)
            {
                if (_usuarioServico.regraDeSenhaOK(usuarioModel.Senha))
                {
                    _usuarioServico.CadastrarUsuario(usuarioModel.Email, usuarioModel.Senha, usuarioModel.Nome);
                    return RedirectToAction("Login");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Senha digitada deve conter 8 numeros no mínimo,1 letra maiuscula e minúscula e um número");
                }
            }

            return View("Cadastro", usuarioModel);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Logar(LoginViewModel loginViewModel)
        {
            if(ModelState.IsValid)
            {
                
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("Listagem");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }
        
        [HttpGet]       
        public ActionResult Login()
        {            
            return View();
        }

        [HttpGet]
        public ActionResult Cadastro()
        {
            return View();
        }


        [HttpGet]
        [LojaToken(Roles = "COMUM")]
        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidos(cliente, produto);
            return View(pedidos);
        }

        [HttpGet]
        [LojaToken(Roles = "ADMIN")]
        public ActionResult ListagemUsuarios(string cliente, string produto)
        {
            //TODO:Crirar função com melhor descrição para busca de usuriaos
            var usuarios = _usuarioServico.BuscarTodosUsuarios();
            return View(usuarios);
        }

        [HttpPost]
        [LojaToken(Roles = "COMUM")]
        [ValidateAntiForgeryToken]
        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);
            ViewBag.Mensagem = "Excluido com sucesso";
            return View("Sucesso");
        }

        [HttpGet]
        [LojaToken(Roles = "COMUM")]
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }
    }
}