﻿using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models.Login
{
    public class UsuarioLogadoModel
    {
        public string Email { get; private set; }
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }


        public UsuarioLogadoModel(Usuario usuario)
        {
            this.Email = usuario.Email;
            this.Nome = usuario.Nome;
            this.Permissoes = usuario.Permissoes;
        }
       
        public bool TemPermissao(string permissao)
        {
            return Permissoes != null
                   && Permissoes.Any(p => p.Equals(permissao));
        }
    }
}