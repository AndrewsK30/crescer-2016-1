using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class ExemploController : Controller
    {
        public ActionResult Index(int id=1)
        {
            var personagens = new List<PersonagemModel>()
                {
                    new PersonagemModel()
                    {
                        Nome = "Sasuke",
                        Id = 16,
                        Fodao = false
                    },
                    new PersonagemModel()
                    {
                        Nome = "Vegeta",
                        Id = 30,
                        Fodao = true
                    },
                    new PersonagemModel()
                    {
                        Nome = "Patrik",
                        Id = 11,
                        Fodao = true
                    },
                    new PersonagemModel()
                    {
                        Nome = "Pepe",
                        Id = 1,
                        Fodao = true
                    }
                };

            ViewBag.MensagemBoasVindas = "Olá, seja bem vindo!";

         
                var personagemEscolhido = personagens.FirstOrDefault(x => x.Id == id);

                return View(personagemEscolhido);
      
        }

        public ActionResult UsandoLayout()
        {
            return View();
        }
    }    
}