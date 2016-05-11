using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            ViewBag.Title = "Página Inicial";
            return View();
        }

        public ActionResult FichaTecnica()
        {
            ViewBag.Title = "Ficha Técnica";
            return View();
        }
  
        public ActionResult Sobre()
        {
            SobreMimModel SobreMim = new SobreMimModel()
            {
                Nome = "Andrews Kuhn da silva",
                Idade = "21",
                DataDeNascimento = new DateTime(1994, 9, 30),
                Altura = 180,
                LinkGitHub = "https://github.com/AndrewsK30"
            };
            ViewBag.Title = "Sobre mim";
            return View(SobreMim);
        }
    }
}