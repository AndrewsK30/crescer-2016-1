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
        private static readonly object objetoLock = new object();

        private List<string> ObterDados()
        {
            return File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
        }

        public List<Usuario> ObterUsuarios(string email = null, string senha = null)
        {
            var linhasArquivo = ObterDados();
            var linhasConvertidas = ConverteLinhasEmUsuarios(linhasArquivo);
            if (!string.IsNullOrEmpty(email))
                linhasConvertidas = linhasConvertidas.Where(x => x.Email.ToLower().Equals(email.ToLower())).ToList();
            if (!string.IsNullOrEmpty(senha))
                linhasConvertidas = linhasConvertidas.Where(x => x.Senha.Equals(senha)).ToList();
            return linhasConvertidas;
        }


        List<Usuario> IUsuarioRepositorio.BuscarTodosUsuarios()
        {
            
            return this.ObterUsuarios();
        }

        Usuario IUsuarioRepositorio.BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            List<Usuario> usuario = this.ObterUsuarios(email, senha);
            return usuario.Count == 0 ? null : usuario[0];
        }

        void IUsuarioRepositorio.CadastraNovoUsuario(Usuario usuario)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterUsuarios().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConverteUsuarioEmLinhaCSV(usuario, idGerado);
                File.AppendAllText(PATH_ARQUIVO, novaLinha);
            }
        }

        private string ConverteUsuarioEmLinhaCSV(Usuario usuario, int proximoId)
        {
            
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4}",
                                proximoId.ToString(),
                                usuario.Nome,
                                usuario.Senha,
                                usuario.Email,
                                String.Join(",", usuario.Permissoes));
        }

        private List<Usuario> ConverteLinhasEmUsuarios(List<string> linhasArquivo)
        {
            var listaUsuarios= new List<Usuario>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = linha.Split(';')[0];
                var nome = linha.Split(';')[1];
                var senha =linha.Split(';')[2];
                var email = linha.Split(';')[3];
                var permissoes = linha.Split(';')[4];

                var usuario = new Usuario(Convert.ToInt32(id), email, senha, nome, new List<Permissao>() { new Permissao(1, permissoes) });
                listaUsuarios.Add(usuario);
            }

            return listaUsuarios;
        }

    }
}
