using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class DesafioController : Controller
    {
        
        public ActionResult Index()
        {
            ViewBag.aluno = Request.QueryString.Count>0 ? Request.QueryString["aluno"].ToString() : "fabriciorissetto";
            return View();
        }
    }
}