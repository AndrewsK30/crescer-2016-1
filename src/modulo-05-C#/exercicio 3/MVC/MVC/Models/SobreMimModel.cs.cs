using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC.Models
{
    public class SobreMimModel
    {
        public string Nome { get; set; }
        public string Idade { get; set; }
        public DateTime DataDeNascimento { get; set;}
        public int Altura { get; set; }
        public string LinkGitHub { get; set; }
    }
}