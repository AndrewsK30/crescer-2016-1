using LojaNinja.MVC.Models;
using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace LojaNinja.MVC.Filters
{
    public class LojaToken : AuthorizeAttribute
    {

        public LojaToken()
        {

        }

        private string[] _permissoesRequeridas = null;
        private string[] PermissoesRequeridas
        {
            get
            {
                if (_permissoesRequeridas == null)
                {
                    _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                        new string[0] :
                                        this.Roles.Split(',');
                }

                return _permissoesRequeridas;
            }
        }

        private bool TemAutorizacao
        {
            get
            {
                UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;

                if (this.PermissoesRequeridas.Length > 0)
                {
                    foreach (string permissao in PermissoesRequeridas)
                    {
                        if (usuarioLogado.TemPermissao(permissao))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }

                return false;
            }
        }
        
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.EstaLogado && TemAutorizacao;
        }

       
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

            if (!estaAutenticadoEAutorizado)
            {
               
                filterContext.Result = new RedirectToRouteResult(
                                    new RouteValueDictionary
                                    {
                                    { "action", "Login" },
                                    { "controller", "Produto" }
                                    });
            }

        }       
    }
}