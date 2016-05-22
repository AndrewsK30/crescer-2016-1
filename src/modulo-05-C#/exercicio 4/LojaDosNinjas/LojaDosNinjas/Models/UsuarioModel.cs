using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class UsuarioModel
    {
        [Display(Name = "Nome: ")]
        [Required(ErrorMessage = "Digite o seu nome")]
        public string Nome { get; set; }

        [Display(Name = "Email: ")]
        [Required(ErrorMessage = "Digite o Email")]
        [StringLength(160)]
        public string Email { get; set; }


        [Display(Name = "Senha: ")]
        [Required(ErrorMessage = "Digite o valor de venda")]
        public string Senha { get; set; }
    }
}