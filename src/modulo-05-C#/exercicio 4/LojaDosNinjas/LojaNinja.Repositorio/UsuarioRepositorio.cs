using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using LojaNinja.Dominio;
using System.IO;

namespace LojaNinja.Repositorio
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        // TODO: refactory, e busca por email lowercase e cadastro.
        private string PATH_ARQUIVO = @"C:\Users\Andrews\Documents\crescer-2016-1\src\modulo-05-C#\exercicio 4\LojaDosNinjas\usuarios.txt";

        private List<string> ObterDados()
        {
            return File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
        }

        public List<Usuario> ObterUsuarios(string email = null, string senha = null)
        {
            var linhasArquivo = ObterDados();
            var linhasConvertidas = ConverteLinhasEmPedidos(linhasArquivo);
            if (!string.IsNullOrEmpty(email))
                linhasConvertidas = linhasConvertidas.Where(x => x.Email.ToLower() == email.ToLower()).ToList();
            if (!string.IsNullOrEmpty(senha))
                linhasConvertidas = linhasConvertidas.Where(x => x.Senha.ToLower() == senha.ToLower()).ToList();
            return linhasConvertidas;
        }

        Usuario IUsuarioRepositorio.BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            return this.ObterUsuarios().FirstOrDefault(x => x.Email == email && x.Senha == senha);
        }

        Usuario IUsuarioRepositorio.CadastraNovoUsuario(string email, string senha)
        {
            throw new NotImplementedException();
        }

        private List<Usuario> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaUsuarios= new List<Usuario>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                
                var nome = linha.Split(';')[1];
                var senha =linha.Split(';')[2];
                var email = linha.Split(';')[3];
                var permissoes = linha.Split(';')[4];

                var usuario = new Usuario()
                {
                    Email = email,
                    Senha = senha, 
                    Nome = nome,
                    Permissoes = new string[] { permissoes }
                };
                listaUsuarios.Add(usuario);
            }

            return listaUsuarios;
        }

    }
}
