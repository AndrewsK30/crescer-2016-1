using LojaNinja.Dominio;
using LojaNinja.MVC.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
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
        // TODO: Refazer Index, E refazer design.
        private UsuarioServico _usuarioServico;

        public ProdutoController()
        {

            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorio()
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
        [LojaToken(Roles = "COMUM,ADMIN")]
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
        // TODO: Fazer cadastro.
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
        // TODO: refazer design de login.
        [HttpGet]       
        public ActionResult Login()
        {            
            return View();
        }

        [HttpGet]
        [LojaToken(Roles = "COMUM,ADMIN")]
        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidos(cliente, produto);
            return View(pedidos);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);
            ViewBag.Mensagem = "Excluido com sucesso";
            return View("Sucesso");
        }

        [HttpGet]
        [LojaToken(Roles = "COMUM,ADMIN")]
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }
    }
}